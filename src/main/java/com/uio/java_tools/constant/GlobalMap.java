package com.uio.java_tools.constant;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alfred
 * @Description: 全局map
 * @time 2021/7/6 13:45
 */
public class GlobalMap {

    public static Map<String,String> initJavaTypeMap(){
        HashMap<String,String> javaTypeMap = new HashMap<>();
        javaTypeMap.put("CHAR", "String");
        javaTypeMap.put("VARCHAR", "String");
        javaTypeMap.put("LONGVARCHAR", "String");
        javaTypeMap.put("NUMERIC", "java.math.BigDecimal");
        javaTypeMap.put("DECIMAL", "java.math.BigDecimal");
        javaTypeMap.put("BIT", "boolean");
        javaTypeMap.put("BOOLEAN", "boolean");
        javaTypeMap.put("TINYINT", "byte");
        javaTypeMap.put("SMALLINT", "short");
        javaTypeMap.put("INTEGER", "INTEGER");
        javaTypeMap.put("BIGINT", "long");
        javaTypeMap.put("REAL", "float");
        javaTypeMap.put("FLOAT", "double");
        javaTypeMap.put("DOUBLE", "double");
        javaTypeMap.put("BINARY", "byte[]");
        javaTypeMap.put("VARBINARY", "byte[]");
        javaTypeMap.put("DATE", "java.sql.Date");
        javaTypeMap.put("TIME", "java.sql.Time");
        javaTypeMap.put("TIMESTAMP", "java.sql.Timestamp");
        javaTypeMap.put("CLOB", "Clob");
        javaTypeMap.put("BLOB", "Blob");
        javaTypeMap.put("ARRAY", "Array");
        javaTypeMap.put("DISTINCT", "mapping of underlying type");
        javaTypeMap.put("STRUCT", "Struct");
        javaTypeMap.put("REF", "Ref");
        javaTypeMap.put("DATALINK", "java.net.URL[color=red][/color]");
        javaTypeMap.put("INT", "int");
        return javaTypeMap;
    }

    public static Map<String,String> initSqlTypeMap(){
        HashMap<String,String> sqlTypeMap = new HashMap<>();
        sqlTypeMap.put("Integer", "int(32)");
        sqlTypeMap.put("int", "int(32)");
        sqlTypeMap.put("String", "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL");
        sqlTypeMap.put("Boolean", "bit(1) DEFAULT NULL");
        sqlTypeMap.put("boolean", "bit(1) NOT DEFAULT NULL");
        sqlTypeMap.put("Double", "double DEFAULT NULL");
        sqlTypeMap.put("double", "double");
        sqlTypeMap.put("Character", "char(1) DEFAULT NULL");
        sqlTypeMap.put("char", "char(1) NOT DEFAULT NULL");
        sqlTypeMap.put("Float", "float DEFAULT NULL");
        sqlTypeMap.put("float", "float NOT DEFAULT NULL");
        sqlTypeMap.put("Long", "bigint DEFAULT NULL");
        sqlTypeMap.put("long", "bigint NOT DEFAULT NULL");
        sqlTypeMap.put("Date", "date DEFAULT NULL");
        sqlTypeMap.put("Byte", "char(1) NOT DEFAULT NULL");
        sqlTypeMap.put("byte", "char(1) NOT DEFAULT NULL");
        sqlTypeMap.put("BigDecimal", "decimal(10,2)");
        return sqlTypeMap;
    }
}
