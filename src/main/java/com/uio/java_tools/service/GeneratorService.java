package com.uio.java_tools.service;

import com.uio.java_tools.dto.JavaParseParameterDTO;
import com.uio.java_tools.dto.ParameterDTO;
import com.uio.java_tools.dto.ParseParameterDTO;

/**
 * @author han xun
 * Date 2021/6/26 16:23
 * Description: 生成文件服务
 */
public interface GeneratorService {


    /**
     * 解析输入的字符串
     * @param inputString
     * @return
     */
    ParseParameterDTO parse(String inputString);

    /**
     * 生成DAO文件
     */
    default void generatorDAO() {

    }

    /**
     * 生成XML文件
     */
    default void generatorXML() {

    }



}
