/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.healthcareapis.v2018_08_20_preview;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The properties of a service instance.
 */
public class ServicesProperties {
    /**
     * The provisioning state. Possible values include: 'Deleting',
     * 'Succeeded', 'Creating', 'Accepted', 'Verifying', 'Updating', 'Failed',
     * 'Canceled', 'Deprovisioned'.
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * The access policies of the service instance.
     */
    @JsonProperty(value = "accessPolicies", required = true)
    private List<ServiceAccessPolicyEntry> accessPolicies;

    /**
     * The settings for the Cosmos DB database backing the service.
     */
    @JsonProperty(value = "cosmosDbConfiguration")
    private ServiceCosmosDbConfigurationInfo cosmosDbConfiguration;

    /**
     * Get the provisioning state. Possible values include: 'Deleting', 'Succeeded', 'Creating', 'Accepted', 'Verifying', 'Updating', 'Failed', 'Canceled', 'Deprovisioned'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the access policies of the service instance.
     *
     * @return the accessPolicies value
     */
    public List<ServiceAccessPolicyEntry> accessPolicies() {
        return this.accessPolicies;
    }

    /**
     * Set the access policies of the service instance.
     *
     * @param accessPolicies the accessPolicies value to set
     * @return the ServicesProperties object itself.
     */
    public ServicesProperties withAccessPolicies(List<ServiceAccessPolicyEntry> accessPolicies) {
        this.accessPolicies = accessPolicies;
        return this;
    }

    /**
     * Get the settings for the Cosmos DB database backing the service.
     *
     * @return the cosmosDbConfiguration value
     */
    public ServiceCosmosDbConfigurationInfo cosmosDbConfiguration() {
        return this.cosmosDbConfiguration;
    }

    /**
     * Set the settings for the Cosmos DB database backing the service.
     *
     * @param cosmosDbConfiguration the cosmosDbConfiguration value to set
     * @return the ServicesProperties object itself.
     */
    public ServicesProperties withCosmosDbConfiguration(ServiceCosmosDbConfigurationInfo cosmosDbConfiguration) {
        this.cosmosDbConfiguration = cosmosDbConfiguration;
        return this;
    }

}
