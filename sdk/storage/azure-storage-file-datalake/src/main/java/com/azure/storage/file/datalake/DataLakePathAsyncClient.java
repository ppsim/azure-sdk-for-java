// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.file.datalake;

import com.azure.core.http.HttpPipeline;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.implementation.util.FluxUtil;
import com.azure.core.implementation.util.ImplUtils;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.BlobServiceVersion;
import com.azure.storage.blob.BlobUrlParts;
import com.azure.storage.blob.specialized.BlockBlobAsyncClient;
import com.azure.storage.blob.specialized.SpecializedBlobClientBuilder;
import com.azure.storage.common.Utility;
import com.azure.storage.file.datalake.implementation.DataLakeStorageClientBuilder;
import com.azure.storage.file.datalake.implementation.DataLakeStorageClientImpl;
import com.azure.storage.file.datalake.implementation.models.LeaseAccessConditions;
import com.azure.storage.file.datalake.implementation.models.ModifiedAccessConditions;
import com.azure.storage.file.datalake.implementation.models.PathGetPropertiesAction;
import com.azure.storage.file.datalake.implementation.models.PathRenameMode;
import com.azure.storage.file.datalake.implementation.models.PathResourceType;
import com.azure.storage.file.datalake.implementation.models.SourceModifiedAccessConditions;
import com.azure.storage.file.datalake.models.DataLakeRequestConditions;
import com.azure.storage.file.datalake.models.PathAccessControl;
import com.azure.storage.file.datalake.models.PathHttpHeaders;
import com.azure.storage.file.datalake.models.PathInfo;
import com.azure.storage.file.datalake.models.PathItem;
import com.azure.storage.file.datalake.models.PathProperties;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;

import static com.azure.core.implementation.util.FluxUtil.monoError;
import static com.azure.core.implementation.util.FluxUtil.withContext;

/**
 * This class provides a client that contains all operations that apply to any path object.
 */
public class DataLakePathAsyncClient {

    private final ClientLogger logger = new ClientLogger(DataLakePathAsyncClient.class);

    protected final DataLakeStorageClientImpl dataLakeStorage;
    private final String accountName;
    private final String fileSystemName;
    private final String pathName;
    protected final BlockBlobAsyncClient blockBlobAsyncClient;
    private final DataLakeServiceVersion serviceVersion;

    /**
     * Package-private constructor for use by {@link DataLakePathClientBuilder}.
     *
     * @param pipeline The pipeline used to send and receive service requests.
     * @param url The endpoint where to send service requests.
     * @param serviceVersion The version of the service to receive requests.
     * @param accountName The storage account name.
     * @param fileSystemName The file system name.
     * @param pathName The path name.
     * @param blockBlobAsyncClient The underlying {@link BlobContainerAsyncClient}
     */
    DataLakePathAsyncClient(HttpPipeline pipeline, String url, DataLakeServiceVersion serviceVersion,
        String accountName, String fileSystemName, String pathName, BlockBlobAsyncClient blockBlobAsyncClient) {
        this.dataLakeStorage = new DataLakeStorageClientBuilder()
            .pipeline(pipeline)
            .url(url)
            .version(serviceVersion.getVersion())
            .build();
        this.serviceVersion = serviceVersion;

        this.accountName = accountName;
        this.fileSystemName = fileSystemName;
        this.pathName = pathName;
        this.blockBlobAsyncClient = blockBlobAsyncClient;
    }

    /**
     * Converts the metadata into a string of format "key1=value1, key2=value2" and Base64 encodes the values.
     *
     * @param metadata The metadata.
     *
     * @return The metadata represented as a String.
     */
    static String buildMetadataString(Map<String, String> metadata) {
        StringBuilder sb = new StringBuilder();
        if (!ImplUtils.isNullOrEmpty(metadata)) {
            for (final Map.Entry<String, String> entry : metadata.entrySet()) {
                if (Objects.isNull(entry.getKey()) || entry.getKey().isEmpty()) {
                    throw new IllegalArgumentException("The key for one of the metadata key-value pairs is null, "
                        + "empty, or whitespace.");
                } else if (Objects.isNull(entry.getValue()) || entry.getValue().isEmpty()) {
                    throw new IllegalArgumentException("The value for one of the metadata key-value pairs is null, "
                        + "empty, or whitespace.");
                }

                /*
                The service has an internal base64 decode when metadata is copied from ADLS to Storage, so getMetadata
                will work as normal. Doing this encoding for the customers preserves the existing behavior of
                metadata.
                 */
                sb.append(entry.getKey()).append('=')
                    .append(new String(Base64.getEncoder().encode(entry.getValue().getBytes(StandardCharsets.UTF_8)),
                        StandardCharsets.UTF_8)).append(',');
            }
            sb.deleteCharAt(sb.length() - 1); // Remove the extraneous "," after the last element.
        }
        return sb.toString();
    }

    /**
     * Gets the URL of the object represented by this client on the Data Lake service.
     *
     * @return the URL.
     */
    String getPathUrl() {
        return dataLakeStorage.getUrl();
    }

    /**
     * Gets the associated account name.
     *
     * @return Account name associated with this storage resource.
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Gets the name of the File System in which this object lives.
     *
     * @return The name of the File System.
     */
    public String getFileSystemName() {
        return fileSystemName;
    }

    /**
     * Gets the path of this object, not including the name of the resource itself.
     *
     * @return The path of the object.
     */
    String getObjectPath() {
        return (pathName == null) ? null : Utility.urlDecode(pathName);
    }

    /**
     * Gets the name of this object, not including its full path.
     *
     * @return The name of the object.
     */
    String getObjectName() {
        // Split on / in the path
        String[] pathParts = getObjectPath().split("/");
        // Return last part of path
        return pathParts[pathParts.length - 1];
    }

    /**
     * Gets the {@link HttpPipeline} powering this client.
     *
     * @return The pipeline.
     */
    public HttpPipeline getHttpPipeline() {
        return dataLakeStorage.getHttpPipeline();
    }

    /**
     * Gets the service version the client is using.
     *
     * @return the service version the client is using.
     */
    public DataLakeServiceVersion getServiceVersion() {
        return serviceVersion;
    }


    /**
     * Package-private create method for use by {@link DataLakeFileAsyncClient} and {@link DataLakeDirectoryAsyncClient}
     *
     * @param resourceType {@link PathResourceType}
     * @param headers {@link PathHttpHeaders}
     * @param metadata Metadata to associate with the resource.
     * @param accessConditions {@link DataLakeRequestConditions}
     * @param permissions POSIX access permissions for the directory owner, the directory owning group, and others.
     * @param umask Restricts permissions of the directory to be created.
     * @param context Additional context that is passed through the Http pipeline during the service call.
     * @return A {@link Mono} containing a {@link Response} whose {@link Response#getValue() value} contains a {@link
     * PathItem}.
     */
    Mono<Response<PathInfo>> createWithResponse(PathResourceType resourceType, PathHttpHeaders headers,
        Map<String, String> metadata, DataLakeRequestConditions accessConditions, String permissions, String umask,
        Context context) {
        accessConditions = accessConditions == null ? new DataLakeRequestConditions() : accessConditions;

        LeaseAccessConditions lac = new LeaseAccessConditions().setLeaseId(accessConditions.getLeaseId());
        ModifiedAccessConditions mac = new ModifiedAccessConditions()
            .setIfMatch(accessConditions.getIfMatch())
            .setIfNoneMatch(accessConditions.getIfNoneMatch())
            .setIfModifiedSince(accessConditions.getIfModifiedSince())
            .setIfUnmodifiedSince(accessConditions.getIfUnmodifiedSince());

        return this.dataLakeStorage.paths().createWithRestResponseAsync(resourceType, null, null, null, null,
            buildMetadataString(metadata), permissions, umask, null, null, headers, lac, mac, null, context)
            .map(response -> new SimpleResponse<>(response, new PathInfo(response.getDeserializedHeaders().getETag(),
                response.getDeserializedHeaders().getLastModified())));
    }

    /**
     * Package-private delete method for use by {@link DataLakeFileAsyncClient} and {@link DataLakeDirectoryAsyncClient}
     *
     * @param recursive Whether or not to delete all paths beneath the directory.
     * @param accessConditions {@link DataLakeRequestConditions}
     * @param context Additional context that is passed through the Http pipeline during the service call.
     * @return A {@link Mono} containing containing status code and HTTP headers
     */
    Mono<Response<Void>> deleteWithResponse(Boolean recursive, DataLakeRequestConditions accessConditions,
        Context context) {
        accessConditions = accessConditions == null ? new DataLakeRequestConditions() : accessConditions;

        LeaseAccessConditions lac = new LeaseAccessConditions().setLeaseId(accessConditions.getLeaseId());
        ModifiedAccessConditions mac = new ModifiedAccessConditions()
            .setIfMatch(accessConditions.getIfMatch())
            .setIfNoneMatch(accessConditions.getIfNoneMatch())
            .setIfModifiedSince(accessConditions.getIfModifiedSince())
            .setIfUnmodifiedSince(accessConditions.getIfUnmodifiedSince());

        return this.dataLakeStorage.paths().deleteWithRestResponseAsync(recursive, null, null, null, lac, mac, context)
            .map(response -> new SimpleResponse<>(response, null));
    }

    /**
     * Changes a resource's metadata. The specified metadata in this method will replace existing metadata. If old
     * values must be preserved, they must be downloaded and included in the call to this method.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * {@codesnippet com.azure.storage.file.datalake.DataLakePathAsyncClient.setMetadata#Map}
     *
     * <p>For more information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/set-blob-metadata">Azure Docs</a></p>
     *
     * @param metadata Metadata to associate with the resource.
     * @return A reactive response signalling completion.
     */
    public Mono<Void> setMetadata(Map<String, String> metadata) {
        try {
            return setMetadataWithResponse(metadata, null).flatMap(FluxUtil::toMono);
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * Changes a resource's metadata. The specified metadata in this method will replace existing metadata. If old
     * values must be preserved, they must be downloaded and included in the call to this method.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * {@codesnippet com.azure.storage.file.datalake.DataLakePathAsyncClient.setMetadata#Map-DataLakeRequestConditions}
     *
     * <p>For more information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/set-blob-metadata">Azure Docs</a></p>
     *
     * @param metadata Metadata to associate with the resource.
     * @param accessConditions {@link DataLakeRequestConditions}
     * @return A reactive response signalling completion.
     */
    public Mono<Response<Void>> setMetadataWithResponse(Map<String, String> metadata,
        DataLakeRequestConditions accessConditions) {
        try {
            return this.blockBlobAsyncClient.setMetadataWithResponse(metadata,
                Transforms.toBlobRequestConditions(accessConditions));
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * Changes a resource's HTTP header properties. If only one HTTP header is updated, the others will all be erased.
     * In order to preserve existing values, they must be passed alongside the header being changed.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * {@codesnippet com.azure.storage.file.datalake.DataLakePathAsyncClient.setHttpHeaders#PathHttpHeaders}
     *
     * <p>For more information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/set-blob-properties">Azure Docs</a></p>
     *
     * @param headers {@link PathHttpHeaders}
     * @return A reactive response signalling completion.
     */
    public Mono<Void> setHttpHeaders(PathHttpHeaders headers) {
        try {
            return setHttpHeadersWithResponse(headers, null).flatMap(FluxUtil::toMono);
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * Changes a resources's HTTP header properties. If only one HTTP header is updated, the others will all be erased.
     * In order to preserve existing values, they must be passed alongside the header being changed.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * {@codesnippet com.azure.storage.file.datalake.DataLakePathAsyncClient.setHttpHeadersWithResponse#PathHttpHeaders-DataLakeRequestConditions}
     *
     * <p>For more information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/set-blob-properties">Azure Docs</a></p>
     *
     * @param headers {@link PathHttpHeaders}
     * @param accessConditions {@link DataLakeRequestConditions}
     * @return A reactive response signalling completion.
     */
    public Mono<Response<Void>> setHttpHeadersWithResponse(PathHttpHeaders headers,
        DataLakeRequestConditions accessConditions) {
        try {
            return this.blockBlobAsyncClient.setHttpHeadersWithResponse(Transforms.toBlobHttpHeaders(headers),
                Transforms.toBlobRequestConditions(accessConditions));
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * Returns the resources's metadata and properties.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * {@codesnippet com.azure.storage.file.datalake.DataLakePathAsyncClient.getProperties}
     *
     * <p>For more information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/get-blob-properties">Azure Docs</a></p>
     *
     * @return A reactive response containing the resource's properties and metadata.
     */
    public Mono<PathProperties> getProperties() {
        try {
            return getPropertiesWithResponse(null).flatMap(FluxUtil::toMono);
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * Returns the resource's metadata and properties.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * {@codesnippet com.azure.storage.file.datalake.DataLakePathAsyncClient.getPropertiesWithResponse#DataLakeRequestConditions}
     *
     * <p>For more information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/get-blob-properties">Azure Docs</a></p>
     *
     * @param accessConditions {@link DataLakeRequestConditions}
     * @return A reactive response containing the resource's properties and metadata.
     */
    public Mono<Response<PathProperties>> getPropertiesWithResponse(DataLakeRequestConditions accessConditions) {
        try {
            return blockBlobAsyncClient.getPropertiesWithResponse(Transforms.toBlobRequestConditions(accessConditions))
                .map(response -> new SimpleResponse<>(response, Transforms.toPathProperties(response.getValue())));
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * Changes the access control for a resource.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * {@codesnippet com.azure.storage.file.datalake.DataLakePathAsyncClient.setAccessControl#PathAccessControl}
     *
     * <p>For more information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/datalakestoragegen2/path/update">Azure Docs</a></p>
     *
     * @param accessControl {@link PathAccessControl}
     * @return A reactive response containing the resource info.
     */
    public Mono<PathInfo> setAccessControl(PathAccessControl accessControl) {
        try {
            return setAccessControlWithResponse(accessControl, null).flatMap(FluxUtil::toMono);
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }

    }

    /**
     * Changes the access control for a resource.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * {@codesnippet com.azure.storage.file.datalake.DataLakePathAsyncClient.setAccessControlWithResponse#PathAccessControl-DataLakeRequestConditions}
     *
     * <p>For more information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/datalakestoragegen2/path/update">Azure Docs</a></p>
     *
     * @param accessControl {@link PathAccessControl}
     * @param accessConditions {@link DataLakeRequestConditions}
     * @return A reactive response containing the resource info.
     */
    public Mono<Response<PathInfo>> setAccessControlWithResponse(PathAccessControl accessControl,
        DataLakeRequestConditions accessConditions) {
        try {
            return withContext(context -> setAccessControlWithResponse(accessControl, accessConditions, context));
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    Mono<Response<PathInfo>> setAccessControlWithResponse(PathAccessControl accessControl,
        DataLakeRequestConditions accessConditions, Context context) {

        Objects.requireNonNull(accessControl, "accessControl can not be null");
        accessConditions = accessConditions == null ? new DataLakeRequestConditions() : accessConditions;

        LeaseAccessConditions lac = new LeaseAccessConditions().setLeaseId(accessConditions.getLeaseId());
        ModifiedAccessConditions mac = new ModifiedAccessConditions()
            .setIfMatch(accessConditions.getIfMatch())
            .setIfNoneMatch(accessConditions.getIfNoneMatch())
            .setIfModifiedSince(accessConditions.getIfModifiedSince())
            .setIfUnmodifiedSince(accessConditions.getIfUnmodifiedSince());

        return this.dataLakeStorage.paths().setAccessControlWithRestResponseAsync(null, accessControl.getOwner(),
            accessControl.getGroup(), accessControl.getPermissions(), accessControl.getAcl(), null, lac, mac, context)
            .map(response -> new SimpleResponse<>(response, new PathInfo(response.getDeserializedHeaders().getETag(),
                response.getDeserializedHeaders().getLastModified())));
    }

    /**
     * Returns the access control for a resource.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * {@codesnippet com.azure.storage.file.datalake.DataLakePathAsyncClient.getAccessControl}
     *
     * <p>For more information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/datalakestoragegen2/path/getproperties">Azure Docs</a></p>
     *
     * @return A reactive response containing the resource access control.
     */
    public Mono<PathAccessControl> getAccessControl() {
        try {
            return getAccessControlWithResponse(false, null).flatMap(FluxUtil::toMono);
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * Returns the access control for a resource.
     *
     * <p><strong>Code Samples</strong></p>
     *
     * {@codesnippet com.azure.storage.file.datalake.DataLakePathAsyncClient.getAccessControlWithResponse#boolean-DataLakeRequestConditions}
     *
     * <p>For more information, see the
     * <a href="https://docs.microsoft.com/en-us/rest/api/storageservices/datalakestoragegen2/path/getproperties">Azure Docs</a></p>
     *
     * @param returnUpn When true, user identity values returned as User Principal Names. When false, user identity
     * values returned as Azure Active Directory Object IDs. Default value is false.
     * @param accessConditions {@link DataLakeRequestConditions}
     * @return A reactive response containing the resource access control.
     */
    public Mono<Response<PathAccessControl>> getAccessControlWithResponse(boolean returnUpn,
        DataLakeRequestConditions accessConditions) {
        try {
            return withContext(context -> getAccessControlWithResponse(returnUpn, accessConditions, context));
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    Mono<Response<PathAccessControl>> getAccessControlWithResponse(boolean returnUpn,
        DataLakeRequestConditions accessConditions, Context context) {
        accessConditions = accessConditions == null ? new DataLakeRequestConditions() : accessConditions;

        LeaseAccessConditions lac = new LeaseAccessConditions().setLeaseId(accessConditions.getLeaseId());
        ModifiedAccessConditions mac = new ModifiedAccessConditions()
            .setIfMatch(accessConditions.getIfMatch())
            .setIfNoneMatch(accessConditions.getIfNoneMatch())
            .setIfModifiedSince(accessConditions.getIfModifiedSince())
            .setIfUnmodifiedSince(accessConditions.getIfUnmodifiedSince());

        return this.dataLakeStorage.paths().getPropertiesWithRestResponseAsync(
            PathGetPropertiesAction.GET_ACCESS_CONTROL, returnUpn, null, null, lac, mac, context)
            .map(response -> new SimpleResponse<>(response, new PathAccessControl()
                .setAcl(response.getDeserializedHeaders().getAcl())
                .setGroup(response.getDeserializedHeaders().getGroup())
                .setOwner(response.getDeserializedHeaders().getOwner())
                .setPermissions(response.getDeserializedHeaders().getPermissions())));
    }

    /**
     * Package-private rename method for use by {@link DataLakeFileAsyncClient} and {@link DataLakeDirectoryAsyncClient}
     *
     * @param destinationPath The path of the destination relative to the file system name
     * @param sourceAccessConditions {@link DataLakeRequestConditions} against the source.
     * @param destAccessConditions {@link DataLakeRequestConditions} against the destination.
     * @param context Additional context that is passed through the Http pipeline during the service call.
     * @return A {@link Mono} containing a {@link Response} whose {@link Response#getValue() value} contains a {@link
     * DataLakePathAsyncClient} used to interact with the path created.
     */
    Mono<Response<DataLakePathAsyncClient>> renameWithResponse(String destinationPath,
        DataLakeRequestConditions sourceAccessConditions, DataLakeRequestConditions destAccessConditions,
        Context context) {

        destAccessConditions = destAccessConditions == null ? new DataLakeRequestConditions() : destAccessConditions;
        sourceAccessConditions = sourceAccessConditions == null ? new DataLakeRequestConditions()
            : sourceAccessConditions;

        // We want to hide the SourceAccessConditions type from the user for consistency's sake, so we convert here.
        SourceModifiedAccessConditions sourceConditions = new SourceModifiedAccessConditions()
            .setSourceIfModifiedSince(sourceAccessConditions.getIfModifiedSince())
            .setSourceIfUnmodifiedSince(sourceAccessConditions.getIfUnmodifiedSince())
            .setSourceIfMatch(sourceAccessConditions.getIfMatch())
            .setSourceIfNoneMatch(sourceAccessConditions.getIfNoneMatch());

        LeaseAccessConditions destLac = new LeaseAccessConditions().setLeaseId(destAccessConditions.getLeaseId());
        ModifiedAccessConditions destMac = new ModifiedAccessConditions()
            .setIfMatch(destAccessConditions.getIfMatch())
            .setIfNoneMatch(destAccessConditions.getIfNoneMatch())
            .setIfModifiedSince(destAccessConditions.getIfModifiedSince())
            .setIfUnmodifiedSince(destAccessConditions.getIfUnmodifiedSince());

        DataLakePathAsyncClient dataLakePathAsyncClient = getPathAsyncClient(destinationPath);

        String renameSource = "/" + fileSystemName + "/" + pathName;

        return dataLakePathAsyncClient.dataLakeStorage.paths().createWithRestResponseAsync(null /* pathResourceType */,
            null /* continuation */, PathRenameMode.LEGACY, renameSource, sourceAccessConditions.getLeaseId(),
            null /* metadata */, null /* permissions */, null /* umask */, null /* request id */, null /* timeout */,
            null /* pathHttpHeaders */, destLac, destMac, sourceConditions, context)
            .map(response -> new SimpleResponse<>(response, dataLakePathAsyncClient));
    }

    /**
     * Takes in a destination path and creates a DataLakePathAsyncClient with a new path name
     * @param destinationPath The destination path
     * @return A DataLakePathAsyncClient
     */
    DataLakePathAsyncClient getPathAsyncClient(String destinationPath) {
        if (ImplUtils.isNullOrEmpty(destinationPath)) {
            throw logger.logExceptionAsError(new IllegalArgumentException("'destinationPath' can not be set to null"));
        }
        // Get current Datalake URL and replace current path with user provided path
        String newDfsEndpoint = BlobUrlParts.parse(getPathUrl())
            .setBlobName(destinationPath).toUrl().toString();

        return new DataLakePathAsyncClient(getHttpPipeline(), newDfsEndpoint, serviceVersion, accountName,
            fileSystemName, destinationPath, prepareBuilderReplacePath(destinationPath).buildBlockBlobAsyncClient());
    }

    /**
     * Takes in a destination path and creates a SpecializedBlobClientBuilder with a new path name
     * @param destinationPath The destination path
     * @return An updated SpecializedBlobClientBuilder
     */
    SpecializedBlobClientBuilder prepareBuilderReplacePath(String destinationPath) {
        // Get current Blob URL and replace current path with user provided path
        String newBlobEndpoint = BlobUrlParts.parse(Transforms.endpointToDesiredEndpoint(getPathUrl(), "blob", "dfs"))
            .setBlobName(destinationPath).toUrl().toString();

        // TODO (gapra) : Investigate how to convert from datalake service version to blob service version
        return new SpecializedBlobClientBuilder()
            .pipeline(getHttpPipeline())
            .endpoint(newBlobEndpoint)
            .serviceVersion(BlobServiceVersion.getLatest());
    }

    BlockBlobAsyncClient getBlockBlobAsyncClient() {
        return this.blockBlobAsyncClient;
    }
}
