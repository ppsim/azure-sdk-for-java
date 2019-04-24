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
 * Post body schema for CreateKb operation.
 */
public class CreateKbDTO {
    /**
     * Friendly name for the knowledgebase.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * List of Q-A (QnADTO) to be added to the knowledgebase. Q-A Ids are
     * assigned by the service and should be omitted.
     */
    @JsonProperty(value = "qnaList")
    private List<QnADTO> qnaList;

    /**
     * List of URLs to be used for extracting Q-A.
     */
    @JsonProperty(value = "urls")
    private List<String> urls;

    /**
     * List of files from which to Extract Q-A.
     */
    @JsonProperty(value = "files")
    private List<FileDTO> files;

    /**
     * Get friendly name for the knowledgebase.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set friendly name for the knowledgebase.
     *
     * @param name the name value to set
     * @return the CreateKbDTO object itself.
     */
    public CreateKbDTO withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get list of Q-A (QnADTO) to be added to the knowledgebase. Q-A Ids are assigned by the service and should be omitted.
     *
     * @return the qnaList value
     */
    public List<QnADTO> qnaList() {
        return this.qnaList;
    }

    /**
     * Set list of Q-A (QnADTO) to be added to the knowledgebase. Q-A Ids are assigned by the service and should be omitted.
     *
     * @param qnaList the qnaList value to set
     * @return the CreateKbDTO object itself.
     */
    public CreateKbDTO withQnaList(List<QnADTO> qnaList) {
        this.qnaList = qnaList;
        return this;
    }

    /**
     * Get list of URLs to be used for extracting Q-A.
     *
     * @return the urls value
     */
    public List<String> urls() {
        return this.urls;
    }

    /**
     * Set list of URLs to be used for extracting Q-A.
     *
     * @param urls the urls value to set
     * @return the CreateKbDTO object itself.
     */
    public CreateKbDTO withUrls(List<String> urls) {
        this.urls = urls;
        return this;
    }

    /**
     * Get list of files from which to Extract Q-A.
     *
     * @return the files value
     */
    public List<FileDTO> files() {
        return this.files;
    }

    /**
     * Set list of files from which to Extract Q-A.
     *
     * @param files the files value to set
     * @return the CreateKbDTO object itself.
     */
    public CreateKbDTO withFiles(List<FileDTO> files) {
        this.files = files;
        return this;
    }

}