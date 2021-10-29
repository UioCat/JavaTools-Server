package com.uio.java_tools.dto;

import java.util.Arrays;
import java.util.List;

/**
 * @author VM
 */
public class EntityParameterDTO {

    private List<Parameter> parameters;
    private String tableName;
    private String primaryKey;
    private String namespace;

    public EntityParameterDTO() {
    }

    @Override
    public String toString() {
        return "ParameterDTO1{" +
                "parameters=" + parameters.toString() +
                ", tableName='" + tableName + '\'' +
                ", primaryKey='" + primaryKey + '\'' +
                ", namespace='" + namespace + '\'' +
                '}';
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

}