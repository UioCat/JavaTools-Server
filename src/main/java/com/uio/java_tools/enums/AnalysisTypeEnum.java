package com.uio.java_tools.enums;

/**
 * @author han xun
 * Date 2021/11/6 13:50
 * Description:
 */
public enum AnalysisTypeEnum {

    /**
     * Java语法解析
     */
    SYNTAX_JAVA("java"),

    /**
     * MySQL语法解析
     */
    SYNTAX_MYSQL("mysql"),

    ;

    AnalysisTypeEnum(String desc) {
        this.desc = desc;
    }
    String desc;

    public String getDesc() {
        return desc;
    }
}
