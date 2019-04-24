/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.knowledge.qnamaker.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines headers for Update operation.
 */
public class KnowledgebaseUpdateHeaders {
    /**
     * Relative URI to the target location of the asynchronous operation.
     * Client should poll this resource to get status of the operation.
     */
    @JsonProperty(value = "Location")
    private String location;

    /**
     * Get relative URI to the target location of the asynchronous operation. Client should poll this resource to get status of the operation.
     *
     * @return the location value
     */
    public String location() {
        return this.location;
    }

    /**
     * Set relative URI to the target location of the asynchronous operation. Client should poll this resource to get status of the operation.
     *
     * @param location the location value to set
     * @return the KnowledgebaseUpdateHeaders object itself.
     */
    public KnowledgebaseUpdateHeaders withLocation(String location) {
        this.location = location;
        return this;
    }

}