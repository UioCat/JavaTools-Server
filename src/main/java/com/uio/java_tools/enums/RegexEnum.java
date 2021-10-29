package com.uio.java_tools.enums;

/**
 * @author VM
 * Date 2021/10/28 22:12
 * Description:
 */
public enum RegexEnum {
    /**
     * field解析正则表达式
     */
    TYPE_FIELD_REGEX("(integer|string|boolean|double|float|int|byte|short|long|char|character) (\\w|=| |\")*;"),
    /**
     * 类型解析正则表达式
     */
    TYPE_REGEX("integer|string|boolean|double|float|int|byte|short|long|char|character"),
    /**
     * 注释解析正则表达式
     */
    COMMENT_REGEX("[\\t ]*(/\\*[\\w\\W]*?\\*/|//.*)"),
    /**
     * parameter解析正则表达式
     */
    PARAMETER_REGEX("([\\t ]*(/\\*[\\w\\W]*?\\*/|//.*))*[\\r\\n].*(private )*(integer|string|boolean|double|float|int|byte|short|long|char|character) (\\w|=| |\")*;");


    private String regexString;

    RegexEnum(String regexString) {
        this.regexString = regexString;
    }

    public String getRegexString() {
        return regexString;
    }
}
