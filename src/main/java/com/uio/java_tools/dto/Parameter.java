package com.uio.java_tools.dto;

/**
 * @author VM
 * Date 2021/10/25 23:25
 * Description:
 */
public class Parameter {
    private String type;
    private String field;
    private String comment;
    private String defaultValue;

    public Parameter() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "type='" + type + '\'' +
                ", field='" + field + '\'' +
                ", comment='" + comment + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                '}';
    }
}
