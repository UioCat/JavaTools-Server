package com.example.java_tools.service;

import com.example.java_tools.enums.BackEnum;
import com.example.java_tools.service.utils.MybatisProduceService;
import com.example.java_tools.utils.BackMessage;
import com.example.java_tools.utils.json_msg.ParameterMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// todo 抽离接口，面向接口编程
@Service
public class MybatisConvertService {

    @Autowired
    MybatisProduceService mybatisProduceService;

    /**
     * 生成mybatis基础的框架数据
     * @param parameterMessage namespace
     * @return backMsg
     */
    public BackMessage MybatisBasicsService(ParameterMessage parameterMessage) {
        String basicsCommand = mybatisProduceService.mybatisBasics(parameterMessage.getNamespace());
        return new BackMessage(BackEnum.REQUEST_SUCCESS,basicsCommand);
    }

    /**
     * 根据参数写出插入数据库的mybatis配置语句
     * @param parameterMessage parameter,tbName
     * @return backMsg
     */
    public BackMessage MybatisInsertService(ParameterMessage parameterMessage) {

        List<String> parameterName = new ArrayList<>();

        for(String parameter : parameterMessage.getParameter()){
            parameterName.add(parameter.split(" ")[1]);
        }

        String insertCommand = mybatisProduceService.mybatisInsert(parameterName,parameterMessage.getTbName());
        return new BackMessage(BackEnum.REQUEST_SUCCESS,insertCommand);
    }

    /**
     *根据参数写出更新数据库的mybatis配置语句
     * @param parameterMessage parameter,keyParameter,tbName
     * @return backMsg
     */
    public BackMessage MybatisUpdateService(ParameterMessage parameterMessage) {

        List<String> parameterName = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        for(String keyParameter : parameterMessage.getKeyParameter()){
            keyParameterName.add(keyParameter.split(" ")[1]);
        }
        for(String parameter : parameterMessage.getParameter()){
            parameterName.add(parameter.split(" ")[1]);
        }

        String updateCommand = mybatisProduceService.mybatisUpdate(keyParameterName,parameterName,parameterMessage.getTbName());
        return new BackMessage(BackEnum.REQUEST_SUCCESS,updateCommand);
    }

    /**
     * 根据参数删除对应数据
     * @param parameterMessage keyParameter,tbName
     * @return bakcMsg
     */
    public BackMessage MybatisDeleteService(ParameterMessage parameterMessage) {

        List<String> keyParameterName = new ArrayList<>();

        for(String keyParameter : parameterMessage.getKeyParameter()){
            keyParameterName.add(keyParameter.split(" ")[1]);
        }

        String deleteCommand = mybatisProduceService.mybatisDelete(keyParameterName,parameterMessage.getTbName());
        return new BackMessage(BackEnum.REQUEST_SUCCESS,deleteCommand);
    }

    /**
     * 根据参数写出对应的查询配置
     * @param parameterMessage keyParameter，parameter,tbName
     * @return backMsg
     */
    public BackMessage MybatisSelectService(ParameterMessage parameterMessage) {

        List<String> parameterName = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        for(String keyParameter : parameterMessage.getKeyParameter()){
            keyParameterName.add(keyParameter.split(" ")[1]);
        }
        for(String parameter : parameterMessage.getParameter()){
            parameterName.add(parameter.split(" ")[1]);
        }
        String selectCommand = mybatisProduceService.mybatisSelect(keyParameterName,parameterName,parameterMessage.getTbName());

        return new BackMessage(BackEnum.REQUEST_SUCCESS,selectCommand);
    }
}
