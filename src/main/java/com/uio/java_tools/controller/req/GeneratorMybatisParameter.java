package com.uio.java_tools.controller.req;

import com.uio.java_tools.enums.CurdEnum;
import lombok.Data;

import java.util.List;

/**
 * @author han xun
 * Date 2021/6/26 17:32
 * Description:
 */
@Data
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
}
