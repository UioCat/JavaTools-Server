package com.uio.java_tools.manager;

import java.util.List;

/**
 * @author uio
 * Date 2021/5/23 下午2:57
 * Description:
 */
public interface ParseStrManager {

    /**
     * 将含有大写字母的变量名 aB 改成 a_b
     * @param str 字符aB
     * @return a_b
     */
    String upperToLower(String str);


    /**
     * type转换为数据库建表需要的字符
     * @param type （Integer）
     * @return type int(32)
     */
    String typeConvertForMysql(String type);

    /**
     * 验证字符是否为变量类型
     * @return 字段为变量类型返回true，否则返回false
     */
    boolean verifyWord(String word);


}
