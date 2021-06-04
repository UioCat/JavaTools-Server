package com.example.java_tools.service;

import java.util.List;

/**
 * @author uio
 * Date 2021/5/20 上午9:14
 * Description:
 */
public interface TokenizerService {

    /**
     * 解析Java代码，将Java代码解析出字段的类型以及字段名
     * @param code Java代码（可以不全）
     * @return 字段类型 + 字段名
     */
    List<String> extractFieldFromJavaCode(String code);
}
