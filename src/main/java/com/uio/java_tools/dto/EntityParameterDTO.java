package com.uio.java_tools.dto;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author VM
 */
@Data
public class EntityParameterDTO {
    /**
     * 参数列表
     */
    private List<Parameter> parameters;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 主键
     */
    private String primaryKey;
    /**
     * namespace
     */
    private String namespace;
}