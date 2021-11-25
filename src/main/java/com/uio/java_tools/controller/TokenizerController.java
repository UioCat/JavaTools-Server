package com.uio.java_tools.controller;

import com.uio.java_tools.common.BackMessage;
import com.uio.java_tools.dto.AnalysisDTO;
import com.uio.java_tools.controller.req.StringDataReq;
import com.uio.java_tools.enums.AnalysisTypeEnum;
import com.uio.java_tools.service.TokenizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * @author uio
 * Date 2021/2/23 23:42
 * Description: 文本解析控制类
 */
@RestController
public class TokenizerController {

    @Autowired
    private Map<String, TokenizerService> tokenizerServiceMap;

    private static final String TOKENIZER_PREFIX = "tokenizer_";

    /**
     * 文本识别接口
     * @param dateMessage String data
     * @return analysisDTO
     */
    @PostMapping(value = "/analysisText")
    public BackMessage<AnalysisDTO> analysisText(@RequestBody StringDataReq dateMessage) {

        AnalysisTypeEnum analysisTypeEnum = AnalysisTypeEnum.valueOf(dateMessage.getAnalysisType());
        TokenizerService tokenizerService = tokenizerServiceMap.get(TOKENIZER_PREFIX + analysisTypeEnum.getDesc());
        if (null != tokenizerService) {
            // 修改为解析成封装好的特定对象
            AnalysisDTO analysisDTO = tokenizerService.analysisText(dateMessage.getData());
            return BackMessage.success(analysisDTO);
        }
        return BackMessage.success(null);
    }
}
