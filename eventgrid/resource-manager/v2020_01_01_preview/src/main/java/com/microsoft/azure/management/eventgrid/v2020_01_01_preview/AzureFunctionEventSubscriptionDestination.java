/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.eventgrid.v2020_01_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Information about the azure function destination for an event subscription.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "endpointType")
@JsonTypeName("AzureFunction")
@JsonFlatten
public class AzureFunctionEventSubscriptionDestination extends EventSubscriptionDestination {
    /**
     * The Azure Resource Id that represents the endpoint of the Azure Function
     * destination of an event subscription.
     */
    @JsonProperty(value = "properties.resourceId")
    private String resourceId;

    /**
     * Maximum number of events per batch.
     */
    @JsonProperty(value = "properties.maxEventsPerBatch")
    private Integer maxEventsPerBatch;

    /**
     * Preferred batch size in Kilobytes.
     */
    @JsonProperty(value = "properties.preferredBatchSizeInKilobytes")
    private Integer preferredBatchSizeInKilobytes;

    /**
     * Get the Azure Resource Id that represents the endpoint of the Azure Function destination of an event subscription.
     *
     * @return the resourceId value
     */
    public String resourceId() {
        return this.resourceId;
    }

    /**
     * Set the Azure Resource Id that represents the endpoint of the Azure Function destination of an event subscription.
     *
     * @param resourceId the resourceId value to set
     * @return the AzureFunctionEventSubscriptionDestination object itself.
     */
    public AzureFunctionEventSubscriptionDestination withResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * Get maximum number of events per batch.
     *
     * @return the maxEventsPerBatch value
     */
    public Integer maxEventsPerBatch() {
        return this.maxEventsPerBatch;
    }

    /**
     * Set maximum number of events per batch.
     *
     * @param maxEventsPerBatch the maxEventsPerBatch value to set
     * @return the AzureFunctionEventSubscriptionDestination object itself.
     */
    public AzureFunctionEventSubscriptionDestination withMaxEventsPerBatch(Integer maxEventsPerBatch) {
        this.maxEventsPerBatch = maxEventsPerBatch;
        return this;
    }

    /**
     * Get preferred batch size in Kilobytes.
     *
     * @return the preferredBatchSizeInKilobytes value
     */
    public Integer preferredBatchSizeInKilobytes() {
        return this.preferredBatchSizeInKilobytes;
    }

    /**
     * Set preferred batch size in Kilobytes.
     *
     * @param preferredBatchSizeInKilobytes the preferredBatchSizeInKilobytes value to set
     * @return the AzureFunctionEventSubscriptionDestination object itself.
     */
    public AzureFunctionEventSubscriptionDestination withPreferredBatchSizeInKilobytes(Integer preferredBatchSizeInKilobytes) {
        this.preferredBatchSizeInKilobytes = preferredBatchSizeInKilobytes;
        return this;
    }

}
