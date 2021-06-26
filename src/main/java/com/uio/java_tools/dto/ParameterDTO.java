package com.uio.java_tools.dto;

import java.util.Arrays;

public class ParameterDTO {

    private String[] parameter;
    private String[] keyParameter;
    private String tableName;
    private String namespace;

    public ParameterDTO() {
    }

    @Override
    public String toString() {
        return "ParameterMessage{" +
                "parameter=" + Arrays.toString(parameter) +
                ", keyParameter=" + Arrays.toString(keyParameter) +
                ", tbName='" + tableName + '\'' +
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

    public String[] getParameter() {
        return parameter;
    }

    public void setParameter(String[] parameter) {
        this.parameter = parameter;
    }

    public ParameterDTO(String[] parameter) {
        this.parameter = parameter;
    }

    public String[] getKeyParameter() {
        return keyParameter;
    }

    public void setKeyParameter(String[] keyParameter) {
        this.keyParameter = keyParameter;
    }

}