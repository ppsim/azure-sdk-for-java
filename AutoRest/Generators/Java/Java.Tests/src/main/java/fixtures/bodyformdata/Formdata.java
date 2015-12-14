/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator 0.13.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.bodyformdata;

import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import com.squareup.okhttp.ResponseBody;
import java.io.InputStream;
import java.io.IOException;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.PUT;

/**
 * An instance of this class provides access to all the operations defined
 * in Formdata.
 */
public interface Formdata {
    /**
     * The interface defining all the services for Formdata to be
     * used by Retrofit to perform actually REST calls.
     */
    interface FormdataService {
        @POST("/formdata/stream/uploadfile")
        Call<ResponseBody> uploadFile(InputStream fileContent, String fileName);

        @PUT("/formdata/stream/uploadfile")
        Call<ResponseBody> uploadFileViaBody(@Body InputStream fileContent, String fileName);

    }
    /**
     * Upload file.
     *
     * @param fileContent File to upload.
     * @param fileName File name to upload. Name has to be spelled exactly as written here.
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the InputStream object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<InputStream> uploadFile(InputStream fileContent, String fileName) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Upload file.
     *
     * @param fileContent File to upload.
     * @param fileName File name to upload. Name has to be spelled exactly as written here.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> uploadFileAsync(InputStream fileContent, String fileName, final ServiceCallback<InputStream> serviceCallback);

    /**
     * Upload file.
     *
     * @param fileContent File to upload.
     * @param fileName File name to upload. Name has to be spelled exactly as written here.
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the InputStream object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<InputStream> uploadFileViaBody(InputStream fileContent, String fileName) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Upload file.
     *
     * @param fileContent File to upload.
     * @param fileName File name to upload. Name has to be spelled exactly as written here.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> uploadFileViaBodyAsync(InputStream fileContent, String fileName, final ServiceCallback<InputStream> serviceCallback);

}
