/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.vmwarecloudsimple.v2019_04_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines headers for Stop operation.
 */
public class VirtualMachinesStopHeaders {
    /**
     * The azureAsyncOperation property.
     */
    @JsonProperty(value = "Azure-AsyncOperation")
    private String azureAsyncOperation;

    /**
     * The location property.
     */
    @JsonProperty(value = "Location")
    private String location;

    /**
     * The retryAfter property.
     */
    @JsonProperty(value = "Retry-After")
    private Integer retryAfter;

    /**
     * The contentType property.
     */
    @JsonProperty(value = "Content-Type")
    private String contentType;

    /**
     * Get the azureAsyncOperation value.
     *
     * @return the azureAsyncOperation value
     */
    public String azureAsyncOperation() {
        return this.azureAsyncOperation;
    }

    /**
     * Set the azureAsyncOperation value.
     *
     * @param azureAsyncOperation the azureAsyncOperation value to set
     * @return the VirtualMachinesStopHeaders object itself.
     */
    public VirtualMachinesStopHeaders withAzureAsyncOperation(String azureAsyncOperation) {
        this.azureAsyncOperation = azureAsyncOperation;
        return this;
    }

    /**
     * Get the location value.
     *
     * @return the location value
     */
    public String location() {
        return this.location;
    }

    /**
     * Set the location value.
     *
     * @param location the location value to set
     * @return the VirtualMachinesStopHeaders object itself.
     */
    public VirtualMachinesStopHeaders withLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Get the retryAfter value.
     *
     * @return the retryAfter value
     */
    public Integer retryAfter() {
        return this.retryAfter;
    }

    /**
     * Set the retryAfter value.
     *
     * @param retryAfter the retryAfter value to set
     * @return the VirtualMachinesStopHeaders object itself.
     */
    public VirtualMachinesStopHeaders withRetryAfter(Integer retryAfter) {
        this.retryAfter = retryAfter;
        return this;
    }

    /**
     * Get the contentType value.
     *
     * @return the contentType value
     */
    public String contentType() {
        return this.contentType;
    }

    /**
     * Set the contentType value.
     *
     * @param contentType the contentType value to set
     * @return the VirtualMachinesStopHeaders object itself.
     */
    public VirtualMachinesStopHeaders withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

}
