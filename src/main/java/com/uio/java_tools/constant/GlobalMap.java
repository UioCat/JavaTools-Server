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

    public static final HashMap<String, String> initJavaTypeMap = new HashMap<String, String>(){{
        put("CHAR", "String");
        put("VARCHAR", "String");
        put("LONGVARCHAR", "String");
        put("NUMERIC", "java.math.BigDecimal");
        put("DECIMAL", "java.math.BigDecimal");
        put("BIT", "boolean");
        put("BOOLEAN", "boolean");
        put("TINYINT", "byte");
        put("SMALLINT", "short");
        put("INTEGER", "INTEGER");
        put("BIGINT", "long");
        put("REAL", "float");
        put("FLOAT", "double");
        put("DOUBLE", "double");
        put("BINARY", "byte[]");
        put("VARBINARY", "byte[]");
        put("DATE", "java.sql.Date");
        put("TIME", "java.sql.Time");
        put("TIMESTAMP", "java.sql.Timestamp");
        put("CLOB", "Clob");
        put("BLOB", "Blob");
        put("ARRAY", "Array");
        put("DISTINCT", "mapping of underlying type");
        put("STRUCT", "Struct");
        put("REF", "Ref");
        put("DATALINK", "java.net.URL[color=red][/color]");
        put("INT", "int");
    }};

    public static final HashMap<String, String> initSqlTypeMap = new HashMap<String, String>() {{
        put("Integer", "int(32)");
        put("int", "int(32)");
        put("String", "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci");
        put("Boolean", "bit(1)");
        put("boolean", "bit(1)");
        put("Double", "double");
        put("double", "double");
        put("Character", "char(1)");
        put("char", "char(1)");
        put("Float", "float");
        put("float", "float");
        put("Long", "bigint");
        put("long", "bigint");
        put("Date", "date");
        put("Byte", "char(1)");
        put("byte", "char(1)");
        put("BigDecimal", "decimal(10,2)");
    }};
}
