/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalakeanalytics.v2016_11_01.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.SubResource;

/**
 * Data Lake Analytics firewall rule information.
 */
@JsonFlatten
public class FirewallRuleInner extends SubResource {
    /**
     * The start IP address for the firewall rule. This can be either ipv4 or
     * ipv6. Start and End should be in the same protocol.
     */
    @JsonProperty(value = "properties.startIpAddress", access = JsonProperty.Access.WRITE_ONLY)
    private String startIpAddress;

    /**
     * The end IP address for the firewall rule. This can be either ipv4 or
     * ipv6. Start and End should be in the same protocol.
     */
    @JsonProperty(value = "properties.endIpAddress", access = JsonProperty.Access.WRITE_ONLY)
    private String endIpAddress;

    /**
     * The resource name.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /**
     * The resource type.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    /**
     * Get the start IP address for the firewall rule. This can be either ipv4 or ipv6. Start and End should be in the same protocol.
     *
     * @return the startIpAddress value
     */
    public String startIpAddress() {
        return this.startIpAddress;
    }

    /**
     * Get the end IP address for the firewall rule. This can be either ipv4 or ipv6. Start and End should be in the same protocol.
     *
     * @return the endIpAddress value
     */
    public String endIpAddress() {
        return this.endIpAddress;
    }

    /**
     * Get the resource name.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the resource type.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

}