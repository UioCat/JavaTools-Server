/*
package com.uio.java_tools.service.impl;

import com.uio.java_tools.dto.JavaParseParameterDTO;
import com.uio.java_tools.manager.ParseStrManager;
import com.uio.java_tools.service.GeneratorService;
import com.uio.java_tools.service.TokenizerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

*/
/**
 * @author han xun
 * Date 2021/6/26 16:30
 * Description: 根据Java生成文件
 *//*

@Service
@Slf4j
public class GeneratorByJavaServiceImpl implements GeneratorService {

    @Autowired
    private ParseStrManager parseStrManager;
    @Autowired
    private TokenizerService tokenizerService;

    @Override
    public JavaParseParameterDTO parse(String code) {

        List<String> filedList = tokenizerService.extractFieldFromJavaCode(code);
        String className = tokenizerService.getClassName(code);
        String packageName = tokenizerService.getPackageName(code);

        JavaParseParameterDTO javaParseParameterDTO = new JavaParseParameterDTO();
        javaParseParameterDTO.setPackageName(packageName);
        javaParseParameterDTO.setFieldList(filedList);
        javaParseParameterDTO.setClassName(className);

        return javaParseParameterDTO;
    }

}
*/
