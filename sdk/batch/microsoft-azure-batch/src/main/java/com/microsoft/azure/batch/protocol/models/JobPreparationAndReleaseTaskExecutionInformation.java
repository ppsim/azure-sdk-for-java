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
 * The status of the Job Preparation and Job Release Tasks on a Compute Node.
 */
public class JobPreparationAndReleaseTaskExecutionInformation {
    /**
     * The ID of the Pool containing the Compute Node to which this entry
     * refers.
     */
    @JsonProperty(value = "poolId")
    private String poolId;

    /**
     * The ID of the Compute Node to which this entry refers.
     */
    @JsonProperty(value = "nodeId")
    private String nodeId;

    /**
     * The URL of the Compute Node to which this entry refers.
     */
    @JsonProperty(value = "nodeUrl")
    private String nodeUrl;

    /**
     * Information about the execution status of the Job Preparation Task on
     * this Compute Node.
     */
    @JsonProperty(value = "jobPreparationTaskExecutionInfo")
    private JobPreparationTaskExecutionInformation jobPreparationTaskExecutionInfo;

    /**
     * Information about the execution status of the Job Release Task on this
     * Compute Node.
     * This property is set only if the Job Release Task has run on the Compute
     * Node.
     */
    @JsonProperty(value = "jobReleaseTaskExecutionInfo")
    private JobReleaseTaskExecutionInformation jobReleaseTaskExecutionInfo;

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
     * @return the JobPreparationAndReleaseTaskExecutionInformation object itself.
     */
    public JobPreparationAndReleaseTaskExecutionInformation withPoolId(String poolId) {
        this.poolId = poolId;
        return this;
    }

    /**
     * Get the nodeId value.
     *
     * @return the nodeId value
     */
    public String nodeId() {
        return this.nodeId;
    }

    /**
     * Set the nodeId value.
     *
     * @param nodeId the nodeId value to set
     * @return the JobPreparationAndReleaseTaskExecutionInformation object itself.
     */
    public JobPreparationAndReleaseTaskExecutionInformation withNodeId(String nodeId) {
        this.nodeId = nodeId;
        return this;
    }

    /**
     * Get the nodeUrl value.
     *
     * @return the nodeUrl value
     */
    public String nodeUrl() {
        return this.nodeUrl;
    }

    /**
     * Set the nodeUrl value.
     *
     * @param nodeUrl the nodeUrl value to set
     * @return the JobPreparationAndReleaseTaskExecutionInformation object itself.
     */
    public JobPreparationAndReleaseTaskExecutionInformation withNodeUrl(String nodeUrl) {
        this.nodeUrl = nodeUrl;
        return this;
    }

    /**
     * Get the jobPreparationTaskExecutionInfo value.
     *
     * @return the jobPreparationTaskExecutionInfo value
     */
    public JobPreparationTaskExecutionInformation jobPreparationTaskExecutionInfo() {
        return this.jobPreparationTaskExecutionInfo;
    }

    /**
     * Set the jobPreparationTaskExecutionInfo value.
     *
     * @param jobPreparationTaskExecutionInfo the jobPreparationTaskExecutionInfo value to set
     * @return the JobPreparationAndReleaseTaskExecutionInformation object itself.
     */
    public JobPreparationAndReleaseTaskExecutionInformation withJobPreparationTaskExecutionInfo(JobPreparationTaskExecutionInformation jobPreparationTaskExecutionInfo) {
        this.jobPreparationTaskExecutionInfo = jobPreparationTaskExecutionInfo;
        return this;
    }

    /**
     * Get this property is set only if the Job Release Task has run on the Compute Node.
     *
     * @return the jobReleaseTaskExecutionInfo value
     */
    public JobReleaseTaskExecutionInformation jobReleaseTaskExecutionInfo() {
        return this.jobReleaseTaskExecutionInfo;
    }

    /**
     * Set this property is set only if the Job Release Task has run on the Compute Node.
     *
     * @param jobReleaseTaskExecutionInfo the jobReleaseTaskExecutionInfo value to set
     * @return the JobPreparationAndReleaseTaskExecutionInformation object itself.
     */
    public JobPreparationAndReleaseTaskExecutionInformation withJobReleaseTaskExecutionInfo(JobReleaseTaskExecutionInformation jobReleaseTaskExecutionInfo) {
        this.jobReleaseTaskExecutionInfo = jobReleaseTaskExecutionInfo;
        return this;
    }

}