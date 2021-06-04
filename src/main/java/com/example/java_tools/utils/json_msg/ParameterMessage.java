package com.example.java_tools.utils.json_msg;

import java.util.Arrays;

public class ParameterMessage {

    private String[] parameter;
    private String[] keyParameter;
    private String tbName;
    private String namespace;

    public ParameterMessage() {
    }

    @Override
    public String toString() {
        return "ParameterMessage{" +
                "parameter=" + Arrays.toString(parameter) +
                ", keyParameter=" + Arrays.toString(keyParameter) +
                ", tbName='" + tbName + '\'' +
                ", namespace='" + namespace + '\'' +
                '}';
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }

    public String[] getParameter() {
        return parameter;
    }

    public void setParameter(String[] parameter) {
        this.parameter = parameter;
    }

    public ParameterMessage(String[] parameter) {
        this.parameter = parameter;
    }

    public String[] getKeyParameter() {
        return keyParameter;
    }

    public void setKeyParameter(String[] keyParameter) {
        this.keyParameter = keyParameter;
    }

}