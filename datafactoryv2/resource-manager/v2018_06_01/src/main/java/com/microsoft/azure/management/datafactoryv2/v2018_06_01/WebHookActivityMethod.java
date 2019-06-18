/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactoryv2.v2018_06_01;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for WebHookActivityMethod.
 */
public final class WebHookActivityMethod extends ExpandableStringEnum<WebHookActivityMethod> {
    /** Static value POST for WebHookActivityMethod. */
    public static final WebHookActivityMethod POST = fromString("POST");

    /**
     * Creates or finds a WebHookActivityMethod from its string representation.
     * @param name a name to look for
     * @return the corresponding WebHookActivityMethod
     */
    @JsonCreator
    public static WebHookActivityMethod fromString(String name) {
        return fromString(name, WebHookActivityMethod.class);
    }

    /**
     * @return known WebHookActivityMethod values
     */
    public static Collection<WebHookActivityMethod> values() {
        return values(WebHookActivityMethod.class);
    }
}