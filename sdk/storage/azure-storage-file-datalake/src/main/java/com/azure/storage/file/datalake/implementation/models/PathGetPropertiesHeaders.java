// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.file.datalake.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.implementation.DateTimeRfc1123;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/**
 * Defines headers for GetProperties operation.
 */
@Fluent
public final class PathGetPropertiesHeaders {
    /*
     * Indicates that the service supports requests for partial file content.
     */
    @JsonProperty(value = "Accept-Ranges")
    private String acceptRanges;

    /*
     * If the Cache-Control request header has previously been set for the
     * resource, that value is returned in this header.
     */
    @JsonProperty(value = "Cache-Control")
    private String cacheControl;

    /*
     * If the Content-Disposition request header has previously been set for
     * the resource, that value is returned in this header.
     */
    @JsonProperty(value = "Content-Disposition")
    private String contentDisposition;

    /*
     * If the Content-Encoding request header has previously been set for the
     * resource, that value is returned in this header.
     */
    @JsonProperty(value = "Content-Encoding")
    private String contentEncoding;

    /*
     * If the Content-Language request header has previously been set for the
     * resource, that value is returned in this header.
     */
    @JsonProperty(value = "Content-Language")
    private String contentLanguage;

    /*
     * The size of the resource in bytes.
     */
    @JsonProperty(value = "Content-Length")
    private Long contentLength;

    /*
     * Indicates the range of bytes returned in the event that the client
     * requested a subset of the file by setting the Range request header.
     */
    @JsonProperty(value = "Content-Range")
    private String contentRange;

    /*
     * The content type specified for the resource. If no content type was
     * specified, the default content type is application/octet-stream.
     */
    @JsonProperty(value = "Content-Type")
    private String contentType;

    /*
     * The MD5 hash of complete file stored in storage. This header is returned
     * only for "GetProperties" operation. If the Content-MD5 header has been
     * set for the file, this response header is returned for GetProperties
     * call so that the client can check for message content integrity.
     */
    @JsonProperty(value = "Content-MD5")
    private String contentMD5;

    /*
     * A UTC date/time value generated by the service that indicates the time
     * at which the response was initiated.
     */
    @JsonProperty(value = "Date")
    private DateTimeRfc1123 dateProperty;

    /*
     * An HTTP entity tag associated with the file or directory.
     */
    @JsonProperty(value = "ETag")
    private String eTag;

    /*
     * The data and time the file or directory was last modified.  Write
     * operations on the file or directory update the last modified time.
     */
    @JsonProperty(value = "Last-Modified")
    private DateTimeRfc1123 lastModified;

    /*
     * A server-generated UUID recorded in the analytics logs for
     * troubleshooting and correlation.
     */
    @JsonProperty(value = "x-ms-request-id")
    private String requestId;

    /*
     * The version of the REST protocol used to process the request.
     */
    @JsonProperty(value = "x-ms-version")
    private String version;

    /*
     * The type of the resource.  The value may be "file" or "directory".  If
     * not set, the value is "file".
     */
    @JsonProperty(value = "x-ms-resource-type")
    private String resourceType;

    /*
     * The user-defined properties associated with the file or directory, in
     * the format of a comma-separated list of name and value pairs "n1=v1,
     * n2=v2, ...", where each value is a base64 encoded string. Note that the
     * string may only contain ASCII characters in the ISO-8859-1 character
     * set.
     */
    @JsonProperty(value = "x-ms-properties")
    private String properties;

    /*
     * The owner of the file or directory. Included in the response if
     * Hierarchical Namespace is enabled for the account.
     */
    @JsonProperty(value = "x-ms-owner")
    private String owner;

    /*
     * The owning group of the file or directory. Included in the response if
     * Hierarchical Namespace is enabled for the account.
     */
    @JsonProperty(value = "x-ms-group")
    private String group;

    /*
     * The POSIX access permissions for the file owner, the file owning group,
     * and others. Included in the response if Hierarchical Namespace is
     * enabled for the account.
     */
    @JsonProperty(value = "x-ms-permissions")
    private String permissions;

    /*
     * The POSIX access control list for the file or directory.  Included in
     * the response only if the action is "getAccessControl" and Hierarchical
     * Namespace is enabled for the account.
     */
    @JsonProperty(value = "x-ms-acl")
    private String acl;

    /*
     * When a resource is leased, specifies whether the lease is of infinite or
     * fixed duration.
     */
    @JsonProperty(value = "x-ms-lease-duration")
    private String leaseDuration;

    /*
     * Lease state of the resource.
     */
    @JsonProperty(value = "x-ms-lease-state")
    private String leaseState;

    /*
     * The lease status of the resource.
     */
    @JsonProperty(value = "x-ms-lease-status")
    private String leaseStatus;

    /*
     * The errorCode property.
     */
    @JsonProperty(value = "x-ms-error-code")
    private String errorCode;

    /**
     * Get the acceptRanges property: Indicates that the service supports
     * requests for partial file content.
     *
     * @return the acceptRanges value.
     */
    public String getAcceptRanges() {
        return this.acceptRanges;
    }

    /**
     * Set the acceptRanges property: Indicates that the service supports
     * requests for partial file content.
     *
     * @param acceptRanges the acceptRanges value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setAcceptRanges(String acceptRanges) {
        this.acceptRanges = acceptRanges;
        return this;
    }

    /**
     * Get the cacheControl property: If the Cache-Control request header has
     * previously been set for the resource, that value is returned in this
     * header.
     *
     * @return the cacheControl value.
     */
    public String getCacheControl() {
        return this.cacheControl;
    }

    /**
     * Set the cacheControl property: If the Cache-Control request header has
     * previously been set for the resource, that value is returned in this
     * header.
     *
     * @param cacheControl the cacheControl value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
        return this;
    }

    /**
     * Get the contentDisposition property: If the Content-Disposition request
     * header has previously been set for the resource, that value is returned
     * in this header.
     *
     * @return the contentDisposition value.
     */
    public String getContentDisposition() {
        return this.contentDisposition;
    }

    /**
     * Set the contentDisposition property: If the Content-Disposition request
     * header has previously been set for the resource, that value is returned
     * in this header.
     *
     * @param contentDisposition the contentDisposition value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
        return this;
    }

    /**
     * Get the contentEncoding property: If the Content-Encoding request header
     * has previously been set for the resource, that value is returned in this
     * header.
     *
     * @return the contentEncoding value.
     */
    public String getContentEncoding() {
        return this.contentEncoding;
    }

    /**
     * Set the contentEncoding property: If the Content-Encoding request header
     * has previously been set for the resource, that value is returned in this
     * header.
     *
     * @param contentEncoding the contentEncoding value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
        return this;
    }

    /**
     * Get the contentLanguage property: If the Content-Language request header
     * has previously been set for the resource, that value is returned in this
     * header.
     *
     * @return the contentLanguage value.
     */
    public String getContentLanguage() {
        return this.contentLanguage;
    }

    /**
     * Set the contentLanguage property: If the Content-Language request header
     * has previously been set for the resource, that value is returned in this
     * header.
     *
     * @param contentLanguage the contentLanguage value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setContentLanguage(String contentLanguage) {
        this.contentLanguage = contentLanguage;
        return this;
    }

    /**
     * Get the contentLength property: The size of the resource in bytes.
     *
     * @return the contentLength value.
     */
    public Long getContentLength() {
        return this.contentLength;
    }

    /**
     * Set the contentLength property: The size of the resource in bytes.
     *
     * @param contentLength the contentLength value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setContentLength(Long contentLength) {
        this.contentLength = contentLength;
        return this;
    }

    /**
     * Get the contentRange property: Indicates the range of bytes returned in
     * the event that the client requested a subset of the file by setting the
     * Range request header.
     *
     * @return the contentRange value.
     */
    public String getContentRange() {
        return this.contentRange;
    }

    /**
     * Set the contentRange property: Indicates the range of bytes returned in
     * the event that the client requested a subset of the file by setting the
     * Range request header.
     *
     * @param contentRange the contentRange value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setContentRange(String contentRange) {
        this.contentRange = contentRange;
        return this;
    }

    /**
     * Get the contentType property: The content type specified for the
     * resource. If no content type was specified, the default content type is
     * application/octet-stream.
     *
     * @return the contentType value.
     */
    public String getContentType() {
        return this.contentType;
    }

    /**
     * Set the contentType property: The content type specified for the
     * resource. If no content type was specified, the default content type is
     * application/octet-stream.
     *
     * @param contentType the contentType value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     * Get the contentMD5 property: The MD5 hash of complete file stored in
     * storage. This header is returned only for "GetProperties" operation. If
     * the Content-MD5 header has been set for the file, this response header
     * is returned for GetProperties call so that the client can check for
     * message content integrity.
     *
     * @return the contentMD5 value.
     */
    public String getContentMD5() {
        return this.contentMD5;
    }

    /**
     * Set the contentMD5 property: The MD5 hash of complete file stored in
     * storage. This header is returned only for "GetProperties" operation. If
     * the Content-MD5 header has been set for the file, this response header
     * is returned for GetProperties call so that the client can check for
     * message content integrity.
     *
     * @param contentMD5 the contentMD5 value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setContentMD5(String contentMD5) {
        this.contentMD5 = contentMD5;
        return this;
    }

    /**
     * Get the dateProperty property: A UTC date/time value generated by the
     * service that indicates the time at which the response was initiated.
     *
     * @return the dateProperty value.
     */
    public OffsetDateTime getDateProperty() {
        if (this.dateProperty == null) {
            return null;
        }
        return this.dateProperty.getDateTime();
    }

    /**
     * Set the dateProperty property: A UTC date/time value generated by the
     * service that indicates the time at which the response was initiated.
     *
     * @param dateProperty the dateProperty value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setDateProperty(OffsetDateTime dateProperty) {
        if (dateProperty == null) {
            this.dateProperty = null;
        } else {
            this.dateProperty = new DateTimeRfc1123(dateProperty);
        }
        return this;
    }

    /**
     * Get the eTag property: An HTTP entity tag associated with the file or
     * directory.
     *
     * @return the eTag value.
     */
    public String getETag() {
        return this.eTag;
    }

    /**
     * Set the eTag property: An HTTP entity tag associated with the file or
     * directory.
     *
     * @param eTag the eTag value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setETag(String eTag) {
        this.eTag = eTag;
        return this;
    }

    /**
     * Get the lastModified property: The data and time the file or directory
     * was last modified.  Write operations on the file or directory update the
     * last modified time.
     *
     * @return the lastModified value.
     */
    public OffsetDateTime getLastModified() {
        if (this.lastModified == null) {
            return null;
        }
        return this.lastModified.getDateTime();
    }

    /**
     * Set the lastModified property: The data and time the file or directory
     * was last modified.  Write operations on the file or directory update the
     * last modified time.
     *
     * @param lastModified the lastModified value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setLastModified(OffsetDateTime lastModified) {
        if (lastModified == null) {
            this.lastModified = null;
        } else {
            this.lastModified = new DateTimeRfc1123(lastModified);
        }
        return this;
    }

    /**
     * Get the requestId property: A server-generated UUID recorded in the
     * analytics logs for troubleshooting and correlation.
     *
     * @return the requestId value.
     */
    public String getRequestId() {
        return this.requestId;
    }

    /**
     * Set the requestId property: A server-generated UUID recorded in the
     * analytics logs for troubleshooting and correlation.
     *
     * @param requestId the requestId value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * Get the version property: The version of the REST protocol used to
     * process the request.
     *
     * @return the version value.
     */
    public String getVersion() {
        return this.version;
    }

    /**
     * Set the version property: The version of the REST protocol used to
     * process the request.
     *
     * @param version the version value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setVersion(String version) {
        this.version = version;
        return this;
    }

    /**
     * Get the resourceType property: The type of the resource.  The value may
     * be "file" or "directory".  If not set, the value is "file".
     *
     * @return the resourceType value.
     */
    public String getResourceType() {
        return this.resourceType;
    }

    /**
     * Set the resourceType property: The type of the resource.  The value may
     * be "file" or "directory".  If not set, the value is "file".
     *
     * @param resourceType the resourceType value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setResourceType(String resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    /**
     * Get the properties property: The user-defined properties associated with
     * the file or directory, in the format of a comma-separated list of name
     * and value pairs "n1=v1, n2=v2, ...", where each value is a base64
     * encoded string. Note that the string may only contain ASCII characters
     * in the ISO-8859-1 character set.
     *
     * @return the properties value.
     */
    public String getProperties() {
        return this.properties;
    }

    /**
     * Set the properties property: The user-defined properties associated with
     * the file or directory, in the format of a comma-separated list of name
     * and value pairs "n1=v1, n2=v2, ...", where each value is a base64
     * encoded string. Note that the string may only contain ASCII characters
     * in the ISO-8859-1 character set.
     *
     * @param properties the properties value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setProperties(String properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Get the owner property: The owner of the file or directory. Included in
     * the response if Hierarchical Namespace is enabled for the account.
     *
     * @return the owner value.
     */
    public String getOwner() {
        return this.owner;
    }

    /**
     * Set the owner property: The owner of the file or directory. Included in
     * the response if Hierarchical Namespace is enabled for the account.
     *
     * @param owner the owner value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Get the group property: The owning group of the file or directory.
     * Included in the response if Hierarchical Namespace is enabled for the
     * account.
     *
     * @return the group value.
     */
    public String getGroup() {
        return this.group;
    }

    /**
     * Set the group property: The owning group of the file or directory.
     * Included in the response if Hierarchical Namespace is enabled for the
     * account.
     *
     * @param group the group value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setGroup(String group) {
        this.group = group;
        return this;
    }

    /**
     * Get the permissions property: The POSIX access permissions for the file
     * owner, the file owning group, and others. Included in the response if
     * Hierarchical Namespace is enabled for the account.
     *
     * @return the permissions value.
     */
    public String getPermissions() {
        return this.permissions;
    }

    /**
     * Set the permissions property: The POSIX access permissions for the file
     * owner, the file owning group, and others. Included in the response if
     * Hierarchical Namespace is enabled for the account.
     *
     * @param permissions the permissions value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setPermissions(String permissions) {
        this.permissions = permissions;
        return this;
    }

    /**
     * Get the acl property: The POSIX access control list for the file or
     * directory.  Included in the response only if the action is
     * "getAccessControl" and Hierarchical Namespace is enabled for the
     * account.
     *
     * @return the acl value.
     */
    public String getAcl() {
        return this.acl;
    }

    /**
     * Set the acl property: The POSIX access control list for the file or
     * directory.  Included in the response only if the action is
     * "getAccessControl" and Hierarchical Namespace is enabled for the
     * account.
     *
     * @param acl the acl value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setAcl(String acl) {
        this.acl = acl;
        return this;
    }

    /**
     * Get the leaseDuration property: When a resource is leased, specifies
     * whether the lease is of infinite or fixed duration.
     *
     * @return the leaseDuration value.
     */
    public String getLeaseDuration() {
        return this.leaseDuration;
    }

    /**
     * Set the leaseDuration property: When a resource is leased, specifies
     * whether the lease is of infinite or fixed duration.
     *
     * @param leaseDuration the leaseDuration value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setLeaseDuration(String leaseDuration) {
        this.leaseDuration = leaseDuration;
        return this;
    }

    /**
     * Get the leaseState property: Lease state of the resource.
     *
     * @return the leaseState value.
     */
    public String getLeaseState() {
        return this.leaseState;
    }

    /**
     * Set the leaseState property: Lease state of the resource.
     *
     * @param leaseState the leaseState value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setLeaseState(String leaseState) {
        this.leaseState = leaseState;
        return this;
    }

    /**
     * Get the leaseStatus property: The lease status of the resource.
     *
     * @return the leaseStatus value.
     */
    public String getLeaseStatus() {
        return this.leaseStatus;
    }

    /**
     * Set the leaseStatus property: The lease status of the resource.
     *
     * @param leaseStatus the leaseStatus value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setLeaseStatus(String leaseStatus) {
        this.leaseStatus = leaseStatus;
        return this;
    }

    /**
     * Get the errorCode property: The errorCode property.
     *
     * @return the errorCode value.
     */
    public String getErrorCode() {
        return this.errorCode;
    }

    /**
     * Set the errorCode property: The errorCode property.
     *
     * @param errorCode the errorCode value to set.
     * @return the PathGetPropertiesHeaders object itself.
     */
    public PathGetPropertiesHeaders setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }
}
