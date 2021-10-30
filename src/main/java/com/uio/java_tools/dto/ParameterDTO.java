package com.uio.java_tools.dto;

import lombok.Data;

import java.util.Arrays;

@Data
public class ParameterDTO {

    /**
     * 参数列表
     */
    private String[] parameter;
    /**
     * 关键参数列表
     */
    private String[] keyParameter;
    /**
     * 表名
     */
    private String tableName;
    /**
     * namespace
     */
    private String namespace;
}