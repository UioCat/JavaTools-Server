package com.uio.java_tools.enums;

/**
 * @author han xun
 * Date 2021/6/4 22:23
 * Description: 类型转换枚举 int -> int(32)
 * 使用枚举来进行类型转换，更优雅
 */
public enum TypeEnum {

    INTEGER("Integer", "int(32)"),
    INT("int", "int(32)"),
    STRING("String", "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL"),
    BOOLEAN_U("Boolean", "bit(1) DEFAULT NULL"),
    BOOLEAN_L("boolean", "bit(1) NOT DEFAULT NULL"),
    DOUBLE_U("Double", "double DEFAULT NULL"),
    DOUBLE_L("double", "double"),
    CHARACTER("Character", "char(1) DEFAULT NULL"),
    CHAR("char", "char(1) NOT DEFAULT NULL"),
    FLOAT_U("Float", "float DEFAULT NULL"),
    FLOAT_L("float", "float NOT DEFAULT NULL"),
    LONG_U("Long", "bigint DEFAULT NULL"),
    LONG_L("long", "bigint NOT DEFAULT NULL"),
    DATE("Date", "date DEFAULT NULL"),
    BYTE_U("Byte", "char(1) NOT DEFAULT NULL"),
    BYTE_L("byte", "char(1) NOT DEFAULT NULL"),
    BIGDECIMAL("BigDecimal", "decimal(10,2)"),

    ;

    /**
     * 参数类型，关键字
     */
    private String type;

    /**
     * 生成sql语句
     */
    private String convertSql;

    TypeEnum(String type, String convertSql) {
        this.type = type;
        this.convertSql = convertSql;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConvertSql() {
        return convertSql;
    }

    public void setConvertSql(String convertSql) {
        this.convertSql = convertSql;
    }
}
