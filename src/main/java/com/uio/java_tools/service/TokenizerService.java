package com.uio.java_tools.service;

import com.uio.java_tools.dto.AnalysisDTO;


/**
 * @author uio
 * Date 2021/5/20 上午9:14
 * Description:
 */
public interface TokenizerService {

    /**
     * 解析文本为标准数据
     * @param text Java实体类（可不全）、SQL创表文件
     * @return
     */
    AnalysisDTO analysisText(String text);

    /**
     * 解析Java代码获得类名
     * @param code
     * @return
     */
    String getClassName(String code);
}
