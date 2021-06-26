package com.uio.java_tools.resq;

import java.util.List;

/**
 * @author han xun
 * Date 2021/6/26 17:25
 * Description:
 */
public class GeneratorParameterReq {

    /**
     * 参数列表
     */
    private List<String> fieldList;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 项目名 ex:com.uio.java_tools
     */
    private String packageName;

    /**
     * 类名
     */
    private String className;

    private List<GeneratorMybatisParameter> generatorMybatisParameterList;


    @Override
    public String toString() {
        return "GeneratorParameterReq{" +
                "fieldList=" + fieldList +
                ", tableName='" + tableName + '\'' +
                ", packageName='" + packageName + '\'' +
                ", className='" + className + '\'' +
                ", generatorMybatisParameterList=" + generatorMybatisParameterList +
                '}';
    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<GeneratorMybatisParameter> getGeneratorMybatisParameterList() {
        return generatorMybatisParameterList;
    }

    public void setGeneratorMybatisParameterList(List<GeneratorMybatisParameter> generatorMybatisParameterList) {
        this.generatorMybatisParameterList = generatorMybatisParameterList;
    }

}
