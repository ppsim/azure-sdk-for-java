// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.security.keyvault.certificates.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Represents a LifeTimeAction in {@link CertificatePolicy}
 */
public final class LifeTimeAction {

    /**
     * The type of the action. Possible values include: 'EmailContacts',
     * 'AutoRenew'.
     */
    private CertificatePolicyAction certificatePolicyAction;

    /**
     * Percentage of lifetime at which to trigger. Value should be between 1
     * and 99.
     */
    private Integer lifetimePercentage;

    /**
     * Days before expiry to attempt renewal. Value should be between 1 and
     * validity_in_months multiplied by 27. If validity_in_months is 36, then
     * value should be between 1 and 972 (36 * 27).
     */
    private Integer daysBeforeExpiry;

    LifeTimeAction() { }


    public LifeTimeAction(CertificatePolicyAction certificatePolicyAction) {
        this.certificatePolicyAction = certificatePolicyAction;
    }

    /**
     * Get the lifetimePercentage value.
     *
     * @return the lifetimePercentage value
     */
    public Integer getLifetimePercentage() {
        return this.lifetimePercentage;
    }

    /**
     * Set the lifetimePercentage value.
     *
     * @param lifetimePercentage The lifetimePercentage value to set
     * @return the LifeTimeAction object itself.
     */
    public LifeTimeAction setLifetimePercentage(Integer lifetimePercentage) {
        this.lifetimePercentage = lifetimePercentage;
        return this;
    }

    /**
     * Get the daysBeforeExpiry value.
     *
     * @return the daysBeforeExpiry value
     */
    public Integer getDaysBeforeExpiry() {
        return this.daysBeforeExpiry;
    }

    /**
     * Set the daysBeforeExpiry value.
     *
     * @param daysBeforeExpiry The daysBeforeExpiry value to set
     * @return the LifeTimeAction object itself.
     */
    public LifeTimeAction setDaysBeforeExpiry(Integer daysBeforeExpiry) {
        this.daysBeforeExpiry = daysBeforeExpiry;
        return this;
    }

    /**
     * Get the lifetimeActionType value.
     *
     * @return the lifetimeActionType value
     */
    public CertificatePolicyAction getActionType() {
        return this.certificatePolicyAction;
    }


    @JsonProperty(value = "action")
    private void unpackAction(Map<String, Object> action) {
        certificatePolicyAction = CertificatePolicyAction.fromString((String) action.get("action_type"));
    }

    @JsonProperty(value = "trigger")
    private void unpackTrigger(Map<String, Object> triggerProps) {
        lifetimePercentage = (Integer) triggerProps.get("lifetime_percentage");
        daysBeforeExpiry = (Integer) triggerProps.get("days_before_expiry");
    }
}
