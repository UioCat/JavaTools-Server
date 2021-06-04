package com.example.java_tools.service;

import com.example.java_tools.utils.BackMessage;
import com.example.java_tools.utils.json_msg.ParameterMessage;

/**
 * @author uio
 * Date 2021/5/20 上午9:09
 * Description: Mybatis xml文件生成服务类
 */
public interface MybatisConvertService {

    /**
     * 生成mybatis基础的框架数据
     * @param parameterMessage namespace
     * @return backMsg
     */
    BackMessage MybatisBasicsService(ParameterMessage parameterMessage);

    /**
     * 根据参数写出插入数据库的mybatis配置语句
     * @param parameterMessage parameter,tbName
     * @return backMsg
     */
    BackMessage MybatisInsertService(ParameterMessage parameterMessage);


    /**
     *根据参数写出更新数据库的mybatis配置语句
     * @param parameterMessage parameter,keyParameter,tbName
     * @return backMsg
     */
    BackMessage MybatisUpdateService(ParameterMessage parameterMessage);


    /**
     * 根据参数删除对应数据
     * @param parameterMessage keyParameter,tbName
     * @return bakcMsg
     */
    BackMessage MybatisDeleteService(ParameterMessage parameterMessage);

    /**
     * 根据参数写出对应的查询配置
     * @param parameterMessage keyParameter，parameter, tbName
     * @return backMsg
     */
    BackMessage MybatisSelectService(ParameterMessage parameterMessage);


}
