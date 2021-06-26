package com.uio.java_tools.resq;

import com.uio.java_tools.enums.CurdEnum;

import java.util.List;

/**
 * @author han xun
 * Date 2021/6/26 17:32
 * Description:
 */
public class GeneratorMybatisParameter {

    /**
     * 生成类型
     * @see CurdEnum
     */
    private String type;

    /**
     * 参数列表
     */
    private List<String> parameterList;

    /**
     * 关键参数列表
     */
    private List<String> keyParameterList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<String> parameterList) {
        this.parameterList = parameterList;
    }

    public List<String> getKeyParameterList() {
        return keyParameterList;
    }

    public void setKeyParameterList(List<String> keyParameterList) {
        this.keyParameterList = keyParameterList;
    }
}
