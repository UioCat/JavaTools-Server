package com.uio.java_tools.controller;

import com.uio.java_tools.enums.BackEnum;
import com.uio.java_tools.service.impl.TokenizerServiceImpl;
import com.uio.java_tools.utils.BackMessage;
import com.uio.java_tools.resq.StringDataReq;
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

    // todo 更新接口解析实现
    /**
     * 文本识别接口
     * @param dateMessage String data
     * @return 识别好的List<String>
     */
    @PostMapping(value = "/wordIdentify")
    public BackMessage<List<String>> tokenizer(@RequestBody StringDataReq dateMessage) {
        // 1. 修改为解析成封装好的特定对象，键接口返回值
        // 2. 新建返回值对象，封装字段名、类型和备注对象为成员，参照接口文档
        List<String> fieldList =  tokenizerService.extractFieldFromJavaCode(dateMessage.getData());
        return new BackMessage<List<String>>(BackEnum.REQUEST_SUCCESS, fieldList);
    }
}
