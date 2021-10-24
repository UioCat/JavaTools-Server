package com.uio.java_tools.controller;

import com.uio.java_tools.dto.JavaParseParameterDTO;
import com.uio.java_tools.enums.BackEnum;
import com.uio.java_tools.resq.GeneratorParameterReq;
import com.uio.java_tools.resq.StringDataReq;
import com.uio.java_tools.service.GeneratorService;
import com.uio.java_tools.utils.BackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author han xun
 * Date 2021/6/26 20:22
 * Description: 根据Java生成文件
 */
@RestController
public class GeneratorByJavaController {

    @Autowired
    @Qualifier("generatorByJavaServiceImpl")
    private GeneratorService generatorServiceByJava;

    /**
     * 根据SQL解析出表名以及字段属性
     * @param stringDataReq 创表字符
     * @return
     */
    @PostMapping("/parseJava")
    public BackMessage<JavaParseParameterDTO> parseJava(@RequestBody StringDataReq stringDataReq) {
        JavaParseParameterDTO parameterDTO = (JavaParseParameterDTO) generatorServiceByJava.parse(stringDataReq.getData());
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS, parameterDTO);
    }

    /**
     * 根据SQL生成文件
     * @return 生成压缩包的url
     */
    @PostMapping("/generatorFileByJava")
    public BackMessage<String> generatorFileByJava(@RequestBody List<GeneratorParameterReq> generatorParameterReqList) {
        return null;
    }
}
