package com.example.java_tools.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 解析字符串的工具类
 */
@Service
public class ParseStrUtils {

    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 将含有大写字母的变量名 aB 改成 a_b
     * @param str 字符aB
     * @return a_b
     */
    public String upperToLower(String str){

        char[] ch = str.toCharArray();//A-Z 65-90,a-z 97-122
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0;i < ch.length; i++){
            if(ch[i] >= 'A' && ch[i] <= 'Z'){//大写字母
                ch[i] = (char) (ch[i]+32);
                if(i == 0){
                    stringBuilder.append(ch[i]);
                }else {
                    stringBuilder.append("_").append(ch[i]);
                }
            }else {
                stringBuilder.append(ch[i]);
            }
        }
        return stringBuilder.toString();
    }


    /**
     * type转换为数据库建表需要的字符
     * @param type （Integer）
     * @return type int(32)
     */
    public String typeConvertForMysql(String type){

        switch (type){
            case "Integer":
            case "int": {
                type = "int(32)";
                break;
            }
            case "String":{
                type = "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL";
                break;
            }
            case "Boolean": {
                type = "bit(1) DEFAULT NULL";
                break;
            }
            case "boolean": {
                type = "bit(1) NOT NULL DEFAULT b'0'";
                break;
            }
            case "Double": {
                type = "double DEFAULT NULL";
                break;
            }
            case "double": {
                type = "double";
                break;
            }
            case "Float": {
                type = "float DEFAULT NULL";
                break;
            }
            case "float": {
                type = "float";
                break;
            }
            case "Long": {
                type = "bigint DEFAULT NULL";
                break;
            }
            case "long": {
                type = "bigint";
                break;
            }
            case "BigDecimal": {
                type = "decimal(10,2) DEFAULT '0.0000'";
                break;
            }
            case "Date": {
                type = "datetime DEFAULT NULL";
                break;
            }
        }
        return type;
    }
}
