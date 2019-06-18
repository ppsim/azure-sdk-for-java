/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.databox;

import java.util.Map;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * DataBox Disk Job Details.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "jobDetailsType")
@JsonTypeName("DataBoxDisk")
public class DataBoxDiskJobDetails extends JobDetails {
    /**
     * User preference on what size disks are needed for the job. The map is
     * from the disk size in TB to the count. Eg. {2,5} means 5 disks of 2 TB
     * size. Key is string but will be checked against an int.
     */
    @JsonProperty(value = "preferredDisks")
    private Map<String, Integer> preferredDisks;

    /**
     * Copy progress per disk.
     */
    @JsonProperty(value = "copyProgress", access = JsonProperty.Access.WRITE_ONLY)
    private List<DataBoxDiskCopyProgress> copyProgress;

    /**
     * Contains the map of disk serial number to the disk size being used for
     * the job. Is returned only after the disks are shipped to the customer.
     */
    @JsonProperty(value = "disksAndSizeDetails", access = JsonProperty.Access.WRITE_ONLY)
    private Map<String, Integer> disksAndSizeDetails;

    /**
     * User entered passkey for DataBox Disk job.
     */
    @JsonProperty(value = "passkey")
    private String passkey;

    /**
     * Get user preference on what size disks are needed for the job. The map is from the disk size in TB to the count. Eg. {2,5} means 5 disks of 2 TB size. Key is string but will be checked against an int.
     *
     * @return the preferredDisks value
     */
    public Map<String, Integer> preferredDisks() {
        return this.preferredDisks;
    }

    /**
     * Set user preference on what size disks are needed for the job. The map is from the disk size in TB to the count. Eg. {2,5} means 5 disks of 2 TB size. Key is string but will be checked against an int.
     *
     * @param preferredDisks the preferredDisks value to set
     * @return the DataBoxDiskJobDetails object itself.
     */
    public DataBoxDiskJobDetails withPreferredDisks(Map<String, Integer> preferredDisks) {
        this.preferredDisks = preferredDisks;
        return this;
    }

    /**
     * Get copy progress per disk.
     *
     * @return the copyProgress value
     */
    public List<DataBoxDiskCopyProgress> copyProgress() {
        return this.copyProgress;
    }

    /**
     * Get contains the map of disk serial number to the disk size being used for the job. Is returned only after the disks are shipped to the customer.
     *
     * @return the disksAndSizeDetails value
     */
    public Map<String, Integer> disksAndSizeDetails() {
        return this.disksAndSizeDetails;
    }

    /**
     * Get user entered passkey for DataBox Disk job.
     *
     * @return the passkey value
     */
    public String passkey() {
        return this.passkey;
    }

    /**
     * Set user entered passkey for DataBox Disk job.
     *
     * @param passkey the passkey value to set
     * @return the DataBoxDiskJobDetails object itself.
     */
    public DataBoxDiskJobDetails withPasskey(String passkey) {
        this.passkey = passkey;
        return this;
    }

}