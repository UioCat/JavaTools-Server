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
    TYPE_FIELD_REGEX("(public |private |protected )*(integer|string|boolean|double|float|int|byte|short|long|char|character|date) (\\w|=| |\")*;"),
    /**
     * 解析方法正则表达式
     */
    METHOD_REGEX("(public |private |protected )*\\w* \\w*\\([\\w, ]*\\)"),
    /**
     * parameter解析正则表达式
     */
    PARAMETER_REGEX("/[\\w\\* ].*?;|(\\w|=| |\")*;");


    private String regexString;

    RegexEnum(String regexString) {
        this.regexString = regexString;
    }

    public String getRegexString() {
        return regexString;
    }
}
