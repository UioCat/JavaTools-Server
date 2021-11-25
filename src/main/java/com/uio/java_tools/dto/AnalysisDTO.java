package com.uio.java_tools.dto;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author VM
 */
@Data
public class AnalysisDTO {
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
     * 包名
     */
    private String packageName;
}