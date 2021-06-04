package com.example.java_tools.controller;

import com.example.java_tools.enums.BackEnum;
import com.example.java_tools.service.impl.TokenizerServiceImpl;
import com.example.java_tools.utils.BackMessage;
import com.example.java_tools.utils.json_msg.StringDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author uio
 * Date 2021/2/23 23:42
 * Description: 文本解析控制类
 */
@RestController
public class TokenizerController {

    @Autowired
    private TokenizerServiceImpl tokenizerService;

    /**
     * 文本识别接口
     * @param dateMessage String data
     * @return 识别好的List<String>
     */
    @PostMapping(value = "/wordIdentify")
    public BackMessage tokenizer(@RequestBody StringDataMessage dateMessage) {
        List<String> fieldList =  tokenizerService.extractFieldFromJavaCode(dateMessage.getData());
        return new BackMessage<List>(BackEnum.REQUEST_SUCCESS, fieldList);
    }
}
