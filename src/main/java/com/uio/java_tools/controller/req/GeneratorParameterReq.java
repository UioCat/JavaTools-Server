package com.uio.java_tools.controller.req;

import lombok.Data;

import java.util.List;

/**
 * @author han xun
 * Date 2021/6/26 17:25
 * Description:
 */
@Data
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
}
