package com.example.java_tools.utils;

/**
 * @author uio
 * Date 2021/4/20 10:59
 * Description:
 */
public interface IData {

    /**
     * 验证字符方法所用到的字符串
     */
    String[] scope = {
            "Integer", "int",
            "Double", "double",
            "Float", "float",
            "Boolean", "boolean",
            "String",
            "BigDecimal",
            "Long", "long",
            "Date"
    };

    /**
     * 用于生成MySQL 插入语句的模版
     */
    String templateForInsertSQL = "";



}
