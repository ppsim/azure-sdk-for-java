/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactoryv2.v2018_06_01.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.management.datafactoryv2.v2018_06_01.ExposureControlRequest;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in ExposureControls.
 */
public class ExposureControlsInner {
    /** The Retrofit service to perform REST calls. */
    private ExposureControlsService service;
    /** The service client containing this operation class. */
    private DataFactoryManagementClientImpl client;

    /**
     * Initializes an instance of ExposureControlsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ExposureControlsInner(Retrofit retrofit, DataFactoryManagementClientImpl client) {
        this.service = retrofit.create(ExposureControlsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for ExposureControls to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ExposureControlsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.datafactoryv2.v2018_06_01.ExposureControls getFeatureValue" })
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.DataFactory/locations/{locationId}/getFeatureValue")
        Observable<Response<ResponseBody>> getFeatureValue(@Path("subscriptionId") String subscriptionId, @Path("locationId") String locationId, @Query("api-version") String apiVersion, @Body ExposureControlRequest exposureControlRequest, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.datafactoryv2.v2018_06_01.ExposureControls getFeatureValueByFactory" })
        @POST("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DataFactory/factories/{factoryName}/getFeatureValue")
        Observable<Response<ResponseBody>> getFeatureValueByFactory(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("factoryName") String factoryName, @Query("api-version") String apiVersion, @Body ExposureControlRequest exposureControlRequest, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Get exposure control feature for specific location.
     *
     * @param locationId The location identifier.
     * @param exposureControlRequest The exposure control request.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the ExposureControlResponseInner object if successful.
     */
    public ExposureControlResponseInner getFeatureValue(String locationId, ExposureControlRequest exposureControlRequest) {
        return getFeatureValueWithServiceResponseAsync(locationId, exposureControlRequest).toBlocking().single().body();
    }

    /**
     * Get exposure control feature for specific location.
     *
     * @param locationId The location identifier.
     * @param exposureControlRequest The exposure control request.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<ExposureControlResponseInner> getFeatureValueAsync(String locationId, ExposureControlRequest exposureControlRequest, final ServiceCallback<ExposureControlResponseInner> serviceCallback) {
        return ServiceFuture.fromResponse(getFeatureValueWithServiceResponseAsync(locationId, exposureControlRequest), serviceCallback);
    }

    /**
     * Get exposure control feature for specific location.
     *
     * @param locationId The location identifier.
     * @param exposureControlRequest The exposure control request.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ExposureControlResponseInner object
     */
    public Observable<ExposureControlResponseInner> getFeatureValueAsync(String locationId, ExposureControlRequest exposureControlRequest) {
        return getFeatureValueWithServiceResponseAsync(locationId, exposureControlRequest).map(new Func1<ServiceResponse<ExposureControlResponseInner>, ExposureControlResponseInner>() {
            @Override
            public ExposureControlResponseInner call(ServiceResponse<ExposureControlResponseInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Get exposure control feature for specific location.
     *
     * @param locationId The location identifier.
     * @param exposureControlRequest The exposure control request.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ExposureControlResponseInner object
     */
    public Observable<ServiceResponse<ExposureControlResponseInner>> getFeatureValueWithServiceResponseAsync(String locationId, ExposureControlRequest exposureControlRequest) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (locationId == null) {
            throw new IllegalArgumentException("Parameter locationId is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        if (exposureControlRequest == null) {
            throw new IllegalArgumentException("Parameter exposureControlRequest is required and cannot be null.");
        }
        Validator.validate(exposureControlRequest);
        return service.getFeatureValue(this.client.subscriptionId(), locationId, this.client.apiVersion(), exposureControlRequest, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<ExposureControlResponseInner>>>() {
                @Override
                public Observable<ServiceResponse<ExposureControlResponseInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<ExposureControlResponseInner> clientResponse = getFeatureValueDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<ExposureControlResponseInner> getFeatureValueDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<ExposureControlResponseInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<ExposureControlResponseInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Get exposure control feature for specific factory.
     *
     * @param resourceGroupName The resource group name.
     * @param factoryName The factory name.
     * @param exposureControlRequest The exposure control request.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the ExposureControlResponseInner object if successful.
     */
    public ExposureControlResponseInner getFeatureValueByFactory(String resourceGroupName, String factoryName, ExposureControlRequest exposureControlRequest) {
        return getFeatureValueByFactoryWithServiceResponseAsync(resourceGroupName, factoryName, exposureControlRequest).toBlocking().single().body();
    }

    /**
     * Get exposure control feature for specific factory.
     *
     * @param resourceGroupName The resource group name.
     * @param factoryName The factory name.
     * @param exposureControlRequest The exposure control request.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<ExposureControlResponseInner> getFeatureValueByFactoryAsync(String resourceGroupName, String factoryName, ExposureControlRequest exposureControlRequest, final ServiceCallback<ExposureControlResponseInner> serviceCallback) {
        return ServiceFuture.fromResponse(getFeatureValueByFactoryWithServiceResponseAsync(resourceGroupName, factoryName, exposureControlRequest), serviceCallback);
    }

    /**
     * Get exposure control feature for specific factory.
     *
     * @param resourceGroupName The resource group name.
     * @param factoryName The factory name.
     * @param exposureControlRequest The exposure control request.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ExposureControlResponseInner object
     */
    public Observable<ExposureControlResponseInner> getFeatureValueByFactoryAsync(String resourceGroupName, String factoryName, ExposureControlRequest exposureControlRequest) {
        return getFeatureValueByFactoryWithServiceResponseAsync(resourceGroupName, factoryName, exposureControlRequest).map(new Func1<ServiceResponse<ExposureControlResponseInner>, ExposureControlResponseInner>() {
            @Override
            public ExposureControlResponseInner call(ServiceResponse<ExposureControlResponseInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Get exposure control feature for specific factory.
     *
     * @param resourceGroupName The resource group name.
     * @param factoryName The factory name.
     * @param exposureControlRequest The exposure control request.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ExposureControlResponseInner object
     */
    public Observable<ServiceResponse<ExposureControlResponseInner>> getFeatureValueByFactoryWithServiceResponseAsync(String resourceGroupName, String factoryName, ExposureControlRequest exposureControlRequest) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (factoryName == null) {
            throw new IllegalArgumentException("Parameter factoryName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        if (exposureControlRequest == null) {
            throw new IllegalArgumentException("Parameter exposureControlRequest is required and cannot be null.");
        }
        Validator.validate(exposureControlRequest);
        return service.getFeatureValueByFactory(this.client.subscriptionId(), resourceGroupName, factoryName, this.client.apiVersion(), exposureControlRequest, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<ExposureControlResponseInner>>>() {
                @Override
                public Observable<ServiceResponse<ExposureControlResponseInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<ExposureControlResponseInner> clientResponse = getFeatureValueByFactoryDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<ExposureControlResponseInner> getFeatureValueByFactoryDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<ExposureControlResponseInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<ExposureControlResponseInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
