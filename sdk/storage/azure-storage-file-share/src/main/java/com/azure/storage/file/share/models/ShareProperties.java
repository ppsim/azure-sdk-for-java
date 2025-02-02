// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.file.share.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.implementation.DateTimeRfc1123;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.time.OffsetDateTime;
import java.util.Map;

/**
 * Properties of a share.
 */
@JacksonXmlRootElement(localName = "ShareProperties")
@Fluent
public final class ShareProperties {
    /*
     * The lastModified property.
     */
    @JsonProperty(value = "Last-Modified", required = true)
    private DateTimeRfc1123 lastModified;

    /*
     * The eTag property.
     */
    @JsonProperty(value = "Etag", required = true)
    private String eTag;

    /*
     * The quota property.
     */
    @JsonProperty(value = "Quota", required = true)
    private int quota;

    /*
     * The metadata property.
     */
    @JsonProperty(value = "Metadata")
    private Map<String, String> metadata;

    /**
     * Get the lastModified property: The lastModified property.
     *
     * @return the lastModified value.
     */
    public OffsetDateTime getLastModified() {
        if (this.lastModified == null) {
            return null;
        }
        return this.lastModified.getDateTime();
    }

    /**
     * Set the lastModified property: The lastModified property.
     *
     * @param lastModified the lastModified value to set.
     * @return the ShareProperties object itself.
     */
    public ShareProperties setLastModified(OffsetDateTime lastModified) {
        if (lastModified == null) {
            this.lastModified = null;
        } else {
            this.lastModified = new DateTimeRfc1123(lastModified);
        }
        return this;
    }

    /**
     * Get the eTag property: The eTag property.
     *
     * @return the eTag value.
     */
    public String getETag() {
        return this.eTag;
    }

    /**
     * Set the eTag property: The eTag property.
     *
     * @param eTag the eTag value to set.
     * @return the ShareProperties object itself.
     */
    public ShareProperties setETag(String eTag) {
        this.eTag = eTag;
        return this;
    }

    /**
     * Get the quota property: The quota property.
     *
     * @return the quota value.
     */
    public int getQuota() {
        return this.quota;
    }

    /**
     * Set the quota property: The quota property.
     *
     * @param quota the quota value to set.
     * @return the ShareProperties object itself.
     */
    public ShareProperties setQuota(int quota) {
        this.quota = quota;
        return this;
    }

    /**
     * Get the metadata property: The metadata property.
     *
     * @return the metadata value.
     */
    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    /**
     * Set the metadata property: The metadata property.
     *
     * @param metadata the metadata value to set.
     * @return the ShareProperties object itself.
     */
    public ShareProperties setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }
}
