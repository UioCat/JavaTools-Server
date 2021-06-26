package com.uio.java_tools.controller;

import com.uio.java_tools.dto.ParseParameterDTO;
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
 * Date 2021/6/26 16:06
 * Description: 根据SQL生成文件
 */
@RestController
public class GeneratorBySQLController {

    @Autowired
    @Qualifier("generatorBySQLServiceImpl")
    private GeneratorService generatorServiceBySQL;

    /**
     * 根据SQL解析出表名以及字段属性
     * @param stringDataReq 创表字符
     * @return
     */
    @PostMapping("/parseSQL")
    public BackMessage<ParseParameterDTO> parseSQL(@RequestBody StringDataReq stringDataReq) {
        ParseParameterDTO parameterDTO = generatorServiceBySQL.parse(stringDataReq.getData());
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS, parameterDTO);
    }

    /**
     * 根据SQL生成文件
     * @return 生成压缩包的url
     */
    @PostMapping("/generatorFileBySQL")
    public BackMessage<String> generatorFileBySQL(@RequestBody List<GeneratorParameterReq> generatorParameterReqList) {
        return null;
    }

}
