package com.example.java_tools.service.impl;

import com.example.java_tools.enums.BackEnum;
import com.example.java_tools.service.MybatisConvertService;
import com.example.java_tools.manager.impl.MybatisProduceManagerImpl;
import com.example.java_tools.utils.BackMessage;
import com.example.java_tools.utils.json_msg.ParameterMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MybatisConvertServiceImpl implements MybatisConvertService {

    @Autowired
    private MybatisProduceManagerImpl mybatisProduceService;

    // todo 将实现类的for循环改成stream，更优雅

    @Override
    public BackMessage<String> MybatisBasicsService(ParameterMessage parameterMessage) {
        String basicsCommand = mybatisProduceService.mybatisBasics(parameterMessage.getNamespace());
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,basicsCommand);
    }

    @Override
    public BackMessage<String> MybatisInsertService(ParameterMessage parameterMessage) {

        List<String> parameterName = new ArrayList<>();

        parameterName = Arrays.stream(parameterMessage.getParameter()).
                map(parameter -> parameter.split(" ")[1]).collect(Collectors.toList());

//        for(String parameter : parameterMessage.getParameter()){
//            parameterName.add(parameter.split(" ")[1]);
//        }

        String insertCommand = mybatisProduceService.mybatisInsert(parameterName, parameterMessage.getTbName());
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,insertCommand);
    }

    @Override
    public BackMessage<String> MybatisUpdateService(ParameterMessage parameterMessage) {

        List<String> parameterName = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        for(String keyParameter : parameterMessage.getKeyParameter()){
            keyParameterName.add(keyParameter.split(" ")[1]);
        }
        for(String parameter : parameterMessage.getParameter()){
            parameterName.add(parameter.split(" ")[1]);
        }

        String updateCommand = mybatisProduceService.mybatisUpdate(keyParameterName,parameterName,parameterMessage.getTbName());
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,updateCommand);
    }

    @Override
    public BackMessage<String> MybatisDeleteService(ParameterMessage parameterMessage) {

        List<String> keyParameterName = new ArrayList<>();

        for(String keyParameter : parameterMessage.getKeyParameter()){
            keyParameterName.add(keyParameter.split(" ")[1]);
        }

        String deleteCommand = mybatisProduceService.mybatisDelete(keyParameterName,parameterMessage.getTbName());
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,deleteCommand);
    }

    @Override
    public BackMessage<String> MybatisSelectService(ParameterMessage parameterMessage) {

        List<String> parameterName = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        for(String keyParameter : parameterMessage.getKeyParameter()){
            keyParameterName.add(keyParameter.split(" ")[1]);
        }
        for(String parameter : parameterMessage.getParameter()){
            parameterName.add(parameter.split(" ")[1]);
        }
        String selectCommand = mybatisProduceService.mybatisSelect(keyParameterName,parameterName,parameterMessage.getTbName());

        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,selectCommand);
    }
}
