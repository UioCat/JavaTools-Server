package com.example.java_tools.manager;

import java.util.List;

/**
 * @author uio
 * Date 2021/5/23 下午2:38
 * Description:
 */

public interface MybatisProduceManager {

    /**
     * 生成mybatis基础的框架数据
     * @param namespace com.xx.xx.xx.xxDao
     * @return
     */
    String mybatisBasics(String namespace);


    /**
     * 生成mybatis插入数据配置
     * @param parameterName
     * @param tbName
     * @return String
     */
    String mybatisInsert(List<String> parameterName, String tbName);



    /**
     * 生成mybatis更新数据配置
     * @param keyParameterName
     * @param parameterName
     * @param tbName
     * @return String
     */
    String mybatisUpdate(List<String> keyParameterName,List<String> parameterName,String tbName);


    /**
     * 生成mybatis删除数据配置
     * @param keyParameterName
     * @param tbName
     * @return String
     */
    String mybatisDelete(List<String> keyParameterName,String tbName);


    /**
     * 生成mybatis查询数据配置
     * @param keyParameterName
     * @param parameterName
     * @param tbName
     * @return
     */
    String mybatisSelect(List<String> keyParameterName,List<String> parameterName,String tbName);
}
