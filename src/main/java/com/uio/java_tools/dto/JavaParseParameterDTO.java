package com.uio.java_tools.dto;

/**
 * @author han xun
 * Date 2021/6/26 16:19
 * Description:
 */
public class JavaParseParameterDTO extends ParseParameterDTO{

    /**
     * 包名
     */
    private String packageName;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
