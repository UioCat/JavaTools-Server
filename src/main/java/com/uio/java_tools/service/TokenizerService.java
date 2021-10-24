package com.uio.java_tools.service;

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

    /**
     * 解析Java代码获得包名
     * @param code
     * @return
     */
    String getPackageName(String code);

    /**
     * 解析Java代码获得类名
     * @param code
     * @return
     */
    String getClassName(String code);
}
