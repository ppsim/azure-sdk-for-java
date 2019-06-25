/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The number of Compute Nodes in each state for a Pool.
 */
public class PoolNodeCounts {
    /**
     * The ID of the Pool.
     */
    @JsonProperty(value = "poolId", required = true)
    private String poolId;

    /**
     * The number of dedicated Compute Nodes in each state.
     */
    @JsonProperty(value = "dedicated")
    private NodeCounts dedicated;

    /**
     * The number of low priority Compute Nodes in each state.
     */
    @JsonProperty(value = "lowPriority")
    private NodeCounts lowPriority;

    /**
     * Get the poolId value.
     *
     * @return the poolId value
     */
    public String poolId() {
        return this.poolId;
    }

    /**
     * Set the poolId value.
     *
     * @param poolId the poolId value to set
     * @return the PoolNodeCounts object itself.
     */
    public PoolNodeCounts withPoolId(String poolId) {
        this.poolId = poolId;
        return this;
    }

    /**
     * Get the dedicated value.
     *
     * @return the dedicated value
     */
    public NodeCounts dedicated() {
        return this.dedicated;
    }

    /**
     * Set the dedicated value.
     *
     * @param dedicated the dedicated value to set
     * @return the PoolNodeCounts object itself.
     */
    public PoolNodeCounts withDedicated(NodeCounts dedicated) {
        this.dedicated = dedicated;
        return this;
    }

    /**
     * Get the lowPriority value.
     *
     * @return the lowPriority value
     */
    public NodeCounts lowPriority() {
        return this.lowPriority;
    }

    /**
     * Set the lowPriority value.
     *
     * @param lowPriority the lowPriority value to set
     * @return the PoolNodeCounts object itself.
     */
    public PoolNodeCounts withLowPriority(NodeCounts lowPriority) {
        this.lowPriority = lowPriority;
        return this;
    }

}