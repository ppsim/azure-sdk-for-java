/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.anomalydetector.models;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The ChangePointDetectOnTimestampRequest model.
 */
public class ChangePointDetectOnTimestampRequest {
    /**
     * The timestamp of a data point.
     */
    @JsonProperty(value = "timestamp", required = true)
    private DateTime timestamp;

    /**
     * Optional argument, periodic value of a time series. If the value is null
     * or does not present, the API will determine the period automatically.
     */
    @JsonProperty(value = "period")
    private Integer periodProperty;

    /**
     * Optional argument, advanced model parameter, a default stableTrendWindow
     * will be used in detection.
     */
    @JsonProperty(value = "stableTrendWindow")
    private Integer stableTrendWindow;

    /**
     * Optional argument, advanced model parameter, between 0.0-1.0, the lower
     * the value is, the larger the trend error will be which means less change
     * point will be accepted.
     */
    @JsonProperty(value = "threshold")
    private Double threshold;

    /**
     * Get the timestamp of a data point.
     *
     * @return the timestamp value
     */
    public DateTime timestamp() {
        return this.timestamp;
    }

    /**
     * Set the timestamp of a data point.
     *
     * @param timestamp the timestamp value to set
     * @return the ChangePointDetectOnTimestampRequest object itself.
     */
    public ChangePointDetectOnTimestampRequest withTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get optional argument, periodic value of a time series. If the value is null or does not present, the API will determine the period automatically.
     *
     * @return the periodProperty value
     */
    public Integer periodProperty() {
        return this.periodProperty;
    }

    /**
     * Set optional argument, periodic value of a time series. If the value is null or does not present, the API will determine the period automatically.
     *
     * @param periodProperty the periodProperty value to set
     * @return the ChangePointDetectOnTimestampRequest object itself.
     */
    public ChangePointDetectOnTimestampRequest withPeriodProperty(Integer periodProperty) {
        this.periodProperty = periodProperty;
        return this;
    }

    /**
     * Get optional argument, advanced model parameter, a default stableTrendWindow will be used in detection.
     *
     * @return the stableTrendWindow value
     */
    public Integer stableTrendWindow() {
        return this.stableTrendWindow;
    }

    /**
     * Set optional argument, advanced model parameter, a default stableTrendWindow will be used in detection.
     *
     * @param stableTrendWindow the stableTrendWindow value to set
     * @return the ChangePointDetectOnTimestampRequest object itself.
     */
    public ChangePointDetectOnTimestampRequest withStableTrendWindow(Integer stableTrendWindow) {
        this.stableTrendWindow = stableTrendWindow;
        return this;
    }

    /**
     * Get optional argument, advanced model parameter, between 0.0-1.0, the lower the value is, the larger the trend error will be which means less change point will be accepted.
     *
     * @return the threshold value
     */
    public Double threshold() {
        return this.threshold;
    }

    /**
     * Set optional argument, advanced model parameter, between 0.0-1.0, the lower the value is, the larger the trend error will be which means less change point will be accepted.
     *
     * @param threshold the threshold value to set
     * @return the ChangePointDetectOnTimestampRequest object itself.
     */
    public ChangePointDetectOnTimestampRequest withThreshold(Double threshold) {
        this.threshold = threshold;
        return this;
    }

}