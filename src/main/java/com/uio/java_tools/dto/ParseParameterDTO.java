package com.uio.java_tools.dto;

import java.util.List;

/**
 * @author han xun
 * Date 2021/6/26 16:17
 * Description:
 */
public class ParseParameterDTO {

    /**
     * 字段列表
     */
    private List<String> fieldList;

    /**
     * 类名
     */
    private String className;

    /**
     * 表名
     */
    private String tableName;

    public List<String> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "ParseParameterDTO{" +
                "fieldList=" + fieldList +
                ", className='" + className + '\'' +
                ", tableName='" + tableName + '\'' +
                '}';
    }
}
