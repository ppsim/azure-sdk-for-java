/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.databox.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceFuture;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.management.databox.AvailableSkuRequest;
import com.microsoft.azure.management.databox.ValidateAddress;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Services.
 */
public class ServicesInner {
    /** The Retrofit service to perform REST calls. */
    private ServicesService service;
    /** The service client containing this operation class. */
    private DataBoxManagementClientImpl client;

    /**
     * Initializes an instance of ServicesInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ServicesInner(Retrofit retrofit, DataBoxManagementClientImpl client) {
        this.service = retrofit.create(ServicesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Services to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ServicesService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.databox.Services listAvailableSkus" })
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.DataBox/locations/{location}/availableSkus")
        Observable<Response<ResponseBody>> listAvailableSkus(@Path("subscriptionId") String subscriptionId, @Path("location") String location, @Query("api-version") String apiVersion, @Body AvailableSkuRequest availableSkuRequest, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.databox.Services validateAddressMethod" })
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.DataBox/locations/{location}/validateAddress")
        Observable<Response<ResponseBody>> validateAddressMethod(@Path("subscriptionId") String subscriptionId, @Path("location") String location, @Query("api-version") String apiVersion, @Body ValidateAddress validateAddress, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.databox.Services listAvailableSkusNext" })
        @GET
        Observable<Response<ResponseBody>> listAvailableSkusNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * This method provides the list of available skus for the given subscription and location.
     *
     * @param location The location of the resource
     * @param availableSkuRequest Filters for showing the available skus.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;SkuInformationInner&gt; object if successful.
     */
    public PagedList<SkuInformationInner> listAvailableSkus(final String location, final AvailableSkuRequest availableSkuRequest) {
        ServiceResponse<Page<SkuInformationInner>> response = listAvailableSkusSinglePageAsync(location, availableSkuRequest).toBlocking().single();
        return new PagedList<SkuInformationInner>(response.body()) {
            @Override
            public Page<SkuInformationInner> nextPage(String nextPageLink) {
                return listAvailableSkusNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * This method provides the list of available skus for the given subscription and location.
     *
     * @param location The location of the resource
     * @param availableSkuRequest Filters for showing the available skus.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<SkuInformationInner>> listAvailableSkusAsync(final String location, final AvailableSkuRequest availableSkuRequest, final ListOperationCallback<SkuInformationInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listAvailableSkusSinglePageAsync(location, availableSkuRequest),
            new Func1<String, Observable<ServiceResponse<Page<SkuInformationInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<SkuInformationInner>>> call(String nextPageLink) {
                    return listAvailableSkusNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * This method provides the list of available skus for the given subscription and location.
     *
     * @param location The location of the resource
     * @param availableSkuRequest Filters for showing the available skus.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;SkuInformationInner&gt; object
     */
    public Observable<Page<SkuInformationInner>> listAvailableSkusAsync(final String location, final AvailableSkuRequest availableSkuRequest) {
        return listAvailableSkusWithServiceResponseAsync(location, availableSkuRequest)
            .map(new Func1<ServiceResponse<Page<SkuInformationInner>>, Page<SkuInformationInner>>() {
                @Override
                public Page<SkuInformationInner> call(ServiceResponse<Page<SkuInformationInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * This method provides the list of available skus for the given subscription and location.
     *
     * @param location The location of the resource
     * @param availableSkuRequest Filters for showing the available skus.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;SkuInformationInner&gt; object
     */
    public Observable<ServiceResponse<Page<SkuInformationInner>>> listAvailableSkusWithServiceResponseAsync(final String location, final AvailableSkuRequest availableSkuRequest) {
        return listAvailableSkusSinglePageAsync(location, availableSkuRequest)
            .concatMap(new Func1<ServiceResponse<Page<SkuInformationInner>>, Observable<ServiceResponse<Page<SkuInformationInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<SkuInformationInner>>> call(ServiceResponse<Page<SkuInformationInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listAvailableSkusNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * This method provides the list of available skus for the given subscription and location.
     *
    ServiceResponse<PageImpl<SkuInformationInner>> * @param location The location of the resource
    ServiceResponse<PageImpl<SkuInformationInner>> * @param availableSkuRequest Filters for showing the available skus.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;SkuInformationInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<SkuInformationInner>>> listAvailableSkusSinglePageAsync(final String location, final AvailableSkuRequest availableSkuRequest) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (location == null) {
            throw new IllegalArgumentException("Parameter location is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        if (availableSkuRequest == null) {
            throw new IllegalArgumentException("Parameter availableSkuRequest is required and cannot be null.");
        }
        Validator.validate(availableSkuRequest);
        return service.listAvailableSkus(this.client.subscriptionId(), location, this.client.apiVersion(), availableSkuRequest, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<SkuInformationInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<SkuInformationInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<SkuInformationInner>> result = listAvailableSkusDelegate(response);
                        return Observable.just(new ServiceResponse<Page<SkuInformationInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<SkuInformationInner>> listAvailableSkusDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<SkuInformationInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<SkuInformationInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * This method validates the customer shipping address and provide alternate addresses if any.
     *
     * @param location The location of the resource
     * @param validateAddress Shipping address of the customer.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the AddressValidationOutputInner object if successful.
     */
    public AddressValidationOutputInner validateAddressMethod(String location, ValidateAddress validateAddress) {
        return validateAddressMethodWithServiceResponseAsync(location, validateAddress).toBlocking().single().body();
    }

    /**
     * This method validates the customer shipping address and provide alternate addresses if any.
     *
     * @param location The location of the resource
     * @param validateAddress Shipping address of the customer.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<AddressValidationOutputInner> validateAddressMethodAsync(String location, ValidateAddress validateAddress, final ServiceCallback<AddressValidationOutputInner> serviceCallback) {
        return ServiceFuture.fromResponse(validateAddressMethodWithServiceResponseAsync(location, validateAddress), serviceCallback);
    }

    /**
     * This method validates the customer shipping address and provide alternate addresses if any.
     *
     * @param location The location of the resource
     * @param validateAddress Shipping address of the customer.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AddressValidationOutputInner object
     */
    public Observable<AddressValidationOutputInner> validateAddressMethodAsync(String location, ValidateAddress validateAddress) {
        return validateAddressMethodWithServiceResponseAsync(location, validateAddress).map(new Func1<ServiceResponse<AddressValidationOutputInner>, AddressValidationOutputInner>() {
            @Override
            public AddressValidationOutputInner call(ServiceResponse<AddressValidationOutputInner> response) {
                return response.body();
            }
        });
    }

    /**
     * This method validates the customer shipping address and provide alternate addresses if any.
     *
     * @param location The location of the resource
     * @param validateAddress Shipping address of the customer.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AddressValidationOutputInner object
     */
    public Observable<ServiceResponse<AddressValidationOutputInner>> validateAddressMethodWithServiceResponseAsync(String location, ValidateAddress validateAddress) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (location == null) {
            throw new IllegalArgumentException("Parameter location is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        if (validateAddress == null) {
            throw new IllegalArgumentException("Parameter validateAddress is required and cannot be null.");
        }
        Validator.validate(validateAddress);
        return service.validateAddressMethod(this.client.subscriptionId(), location, this.client.apiVersion(), validateAddress, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<AddressValidationOutputInner>>>() {
                @Override
                public Observable<ServiceResponse<AddressValidationOutputInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<AddressValidationOutputInner> clientResponse = validateAddressMethodDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<AddressValidationOutputInner> validateAddressMethodDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<AddressValidationOutputInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<AddressValidationOutputInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * This method provides the list of available skus for the given subscription and location.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;SkuInformationInner&gt; object if successful.
     */
    public PagedList<SkuInformationInner> listAvailableSkusNext(final String nextPageLink) {
        ServiceResponse<Page<SkuInformationInner>> response = listAvailableSkusNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<SkuInformationInner>(response.body()) {
            @Override
            public Page<SkuInformationInner> nextPage(String nextPageLink) {
                return listAvailableSkusNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * This method provides the list of available skus for the given subscription and location.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<SkuInformationInner>> listAvailableSkusNextAsync(final String nextPageLink, final ServiceFuture<List<SkuInformationInner>> serviceFuture, final ListOperationCallback<SkuInformationInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listAvailableSkusNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<SkuInformationInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<SkuInformationInner>>> call(String nextPageLink) {
                    return listAvailableSkusNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * This method provides the list of available skus for the given subscription and location.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;SkuInformationInner&gt; object
     */
    public Observable<Page<SkuInformationInner>> listAvailableSkusNextAsync(final String nextPageLink) {
        return listAvailableSkusNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<SkuInformationInner>>, Page<SkuInformationInner>>() {
                @Override
                public Page<SkuInformationInner> call(ServiceResponse<Page<SkuInformationInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * This method provides the list of available skus for the given subscription and location.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;SkuInformationInner&gt; object
     */
    public Observable<ServiceResponse<Page<SkuInformationInner>>> listAvailableSkusNextWithServiceResponseAsync(final String nextPageLink) {
        return listAvailableSkusNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<SkuInformationInner>>, Observable<ServiceResponse<Page<SkuInformationInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<SkuInformationInner>>> call(ServiceResponse<Page<SkuInformationInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listAvailableSkusNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * This method provides the list of available skus for the given subscription and location.
     *
    ServiceResponse<PageImpl<SkuInformationInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;SkuInformationInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<SkuInformationInner>>> listAvailableSkusNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listAvailableSkusNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<SkuInformationInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<SkuInformationInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<SkuInformationInner>> result = listAvailableSkusNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<SkuInformationInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<SkuInformationInner>> listAvailableSkusNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<SkuInformationInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<SkuInformationInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}