package com.uio.java_tools.service;

import com.uio.java_tools.utils.BackMessage;
import com.uio.java_tools.dto.ParameterDTO;

/**
 * @author uio
 * Date 2021/5/20 上午9:09
 * Description: Mybatis xml文件生成服务类
 */
public interface MybatisConvertService {

    /**
     * 生成mybatis基础的框架数据
     * @param parameterDTO namespace
     * @return backMsg
     */
    BackMessage<String> MybatisBasicsService(ParameterDTO parameterDTO);

    /**
     * 根据参数写出插入数据库的mybatis配置语句
     * @param parameterDTO parameter,tbName
     * @return backMsg
     */
    BackMessage<String> MybatisInsertService(ParameterDTO parameterDTO);


    /**
     *根据参数写出更新数据库的mybatis配置语句
     * @param parameterDTO parameter,keyParameter,tbName
     * @return backMsg
     */
    BackMessage<String> MybatisUpdateService(ParameterDTO parameterDTO);


    /**
     * 根据参数删除对应数据
     * @param parameterDTO keyParameter,tbName
     * @return backMsg
     */
    BackMessage<String> MybatisDeleteService(ParameterDTO parameterDTO);

    /**
     * 根据参数写出对应的查询配置
     * @param parameterDTO keyParameter，parameter, tbName
     * @return backMsg
     */
    BackMessage<String> MybatisSelectService(ParameterDTO parameterDTO);


}
