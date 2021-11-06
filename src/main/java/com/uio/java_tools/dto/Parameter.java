package com.uio.java_tools.dto;

import lombok.Data;

/**
 * @author VM
 * Date 2021/10/25 23:25
 * Description:
 */
@Data
public class Parameter {

    /**
     * Java数据类型
     */
    private String type;
    /**
     * MySQL数据类型
     */
    private String datatype;
    /**
     * 字段名
     */
    private String field;
    /**
     * 注释
     */
    private String comment;
    /**
     * 默认值
     */
    private String defaultValue;
}
