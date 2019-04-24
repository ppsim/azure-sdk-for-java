/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.knowledge.qnamaker.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response schema for CreateKb operation.
 */
public class KnowledgebaseDTO {
    /**
     * Unique id that identifies a knowledgebase.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * URL host name at which the knowledgebase is hosted.
     */
    @JsonProperty(value = "hostName")
    private String hostName;

    /**
     * Time stamp at which the knowledgebase was last accessed (UTC).
     */
    @JsonProperty(value = "lastAccessedTimestamp")
    private String lastAccessedTimestamp;

    /**
     * Time stamp at which the knowledgebase was last modified (UTC).
     */
    @JsonProperty(value = "lastChangedTimestamp")
    private String lastChangedTimestamp;

    /**
     * Time stamp at which the knowledgebase was last published (UTC).
     */
    @JsonProperty(value = "lastPublishedTimestamp")
    private String lastPublishedTimestamp;

    /**
     * Friendly name of the knowledgebase.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * User who created / owns the knowledgebase.
     */
    @JsonProperty(value = "userId")
    private String userId;

    /**
     * URL sources from which Q-A were extracted and added to the
     * knowledgebase.
     */
    @JsonProperty(value = "urls")
    private List<String> urls;

    /**
     * Custom sources from which Q-A were extracted or explicitly added to the
     * knowledgebase.
     */
    @JsonProperty(value = "sources")
    private List<String> sources;

    /**
     * Get unique id that identifies a knowledgebase.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set unique id that identifies a knowledgebase.
     *
     * @param id the id value to set
     * @return the KnowledgebaseDTO object itself.
     */
    public KnowledgebaseDTO withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get uRL host name at which the knowledgebase is hosted.
     *
     * @return the hostName value
     */
    public String hostName() {
        return this.hostName;
    }

    /**
     * Set uRL host name at which the knowledgebase is hosted.
     *
     * @param hostName the hostName value to set
     * @return the KnowledgebaseDTO object itself.
     */
    public KnowledgebaseDTO withHostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    /**
     * Get time stamp at which the knowledgebase was last accessed (UTC).
     *
     * @return the lastAccessedTimestamp value
     */
    public String lastAccessedTimestamp() {
        return this.lastAccessedTimestamp;
    }

    /**
     * Set time stamp at which the knowledgebase was last accessed (UTC).
     *
     * @param lastAccessedTimestamp the lastAccessedTimestamp value to set
     * @return the KnowledgebaseDTO object itself.
     */
    public KnowledgebaseDTO withLastAccessedTimestamp(String lastAccessedTimestamp) {
        this.lastAccessedTimestamp = lastAccessedTimestamp;
        return this;
    }

    /**
     * Get time stamp at which the knowledgebase was last modified (UTC).
     *
     * @return the lastChangedTimestamp value
     */
    public String lastChangedTimestamp() {
        return this.lastChangedTimestamp;
    }

    /**
     * Set time stamp at which the knowledgebase was last modified (UTC).
     *
     * @param lastChangedTimestamp the lastChangedTimestamp value to set
     * @return the KnowledgebaseDTO object itself.
     */
    public KnowledgebaseDTO withLastChangedTimestamp(String lastChangedTimestamp) {
        this.lastChangedTimestamp = lastChangedTimestamp;
        return this;
    }

    /**
     * Get time stamp at which the knowledgebase was last published (UTC).
     *
     * @return the lastPublishedTimestamp value
     */
    public String lastPublishedTimestamp() {
        return this.lastPublishedTimestamp;
    }

    /**
     * Set time stamp at which the knowledgebase was last published (UTC).
     *
     * @param lastPublishedTimestamp the lastPublishedTimestamp value to set
     * @return the KnowledgebaseDTO object itself.
     */
    public KnowledgebaseDTO withLastPublishedTimestamp(String lastPublishedTimestamp) {
        this.lastPublishedTimestamp = lastPublishedTimestamp;
        return this;
    }

    /**
     * Get friendly name of the knowledgebase.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set friendly name of the knowledgebase.
     *
     * @param name the name value to set
     * @return the KnowledgebaseDTO object itself.
     */
    public KnowledgebaseDTO withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get user who created / owns the knowledgebase.
     *
     * @return the userId value
     */
    public String userId() {
        return this.userId;
    }

    /**
     * Set user who created / owns the knowledgebase.
     *
     * @param userId the userId value to set
     * @return the KnowledgebaseDTO object itself.
     */
    public KnowledgebaseDTO withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Get uRL sources from which Q-A were extracted and added to the knowledgebase.
     *
     * @return the urls value
     */
    public List<String> urls() {
        return this.urls;
    }

    /**
     * Set uRL sources from which Q-A were extracted and added to the knowledgebase.
     *
     * @param urls the urls value to set
     * @return the KnowledgebaseDTO object itself.
     */
    public KnowledgebaseDTO withUrls(List<String> urls) {
        this.urls = urls;
        return this;
    }

    /**
     * Get custom sources from which Q-A were extracted or explicitly added to the knowledgebase.
     *
     * @return the sources value
     */
    public List<String> sources() {
        return this.sources;
    }

    /**
     * Set custom sources from which Q-A were extracted or explicitly added to the knowledgebase.
     *
     * @param sources the sources value to set
     * @return the KnowledgebaseDTO object itself.
     */
    public KnowledgebaseDTO withSources(List<String> sources) {
        this.sources = sources;
        return this;
    }

}