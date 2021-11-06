package com.uio.java_tools.controller.req;

import lombok.Data;

@Data
public class StringDataReq {

    /**
     * 输入字符串
     */
    private String data;

    /**
     * 解析数据类型
     * @see com.uio.java_tools.enums.AnalysisTypeEnum
     */
    private String analysisType;
}
