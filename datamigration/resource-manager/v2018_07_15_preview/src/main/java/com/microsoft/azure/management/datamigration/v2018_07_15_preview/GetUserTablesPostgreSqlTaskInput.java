/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datamigration.v2018_07_15_preview;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Input for the task that gets the list of tables for a provided list of
 * PostgreSQL databases.
 */
public class GetUserTablesPostgreSqlTaskInput {
    /**
     * Information for connecting to PostgreSQL source.
     */
    @JsonProperty(value = "connectionInfo", required = true)
    private PostgreSqlConnectionInfo connectionInfo;

    /**
     * List of PostgreSQL databases for which to collect tables.
     */
    @JsonProperty(value = "selectedDatabases", required = true)
    private List<String> selectedDatabases;

    /**
     * Get information for connecting to PostgreSQL source.
     *
     * @return the connectionInfo value
     */
    public PostgreSqlConnectionInfo connectionInfo() {
        return this.connectionInfo;
    }

    /**
     * Set information for connecting to PostgreSQL source.
     *
     * @param connectionInfo the connectionInfo value to set
     * @return the GetUserTablesPostgreSqlTaskInput object itself.
     */
    public GetUserTablesPostgreSqlTaskInput withConnectionInfo(PostgreSqlConnectionInfo connectionInfo) {
        this.connectionInfo = connectionInfo;
        return this;
    }

    /**
     * Get list of PostgreSQL databases for which to collect tables.
     *
     * @return the selectedDatabases value
     */
    public List<String> selectedDatabases() {
        return this.selectedDatabases;
    }

    /**
     * Set list of PostgreSQL databases for which to collect tables.
     *
     * @param selectedDatabases the selectedDatabases value to set
     * @return the GetUserTablesPostgreSqlTaskInput object itself.
     */
    public GetUserTablesPostgreSqlTaskInput withSelectedDatabases(List<String> selectedDatabases) {
        this.selectedDatabases = selectedDatabases;
        return this;
    }

}
