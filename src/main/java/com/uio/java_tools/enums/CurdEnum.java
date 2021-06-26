package com.uio.java_tools.enums;


/**
 * @author han xun
 * Date 2021/6/26 17:37
 * Description: 增删改查枚举
 */
public enum CurdEnum {

    INSERT("INSERT"),
    DELETE("DELETE"),
    UPDATE("UPDATE"),
    SELECT("SELECT")
    ;

    private String type;

    CurdEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
