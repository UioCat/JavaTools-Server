package com.uio.java_tools.service.impl;

import com.uio.java_tools.enums.BackEnum;
import com.uio.java_tools.service.MybatisConvertService;
import com.uio.java_tools.manager.impl.MybatisProduceManagerImpl;
import com.uio.java_tools.utils.BackMessage;
import com.uio.java_tools.dto.ParameterDTO;
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
    public BackMessage<String> MybatisBasicsService(ParameterDTO parameterDTO) {
        String basicsCommand = mybatisProduceService.mybatisBasics(parameterDTO.getNamespace());
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,basicsCommand);
    }

    @Override
    public BackMessage<String> MybatisInsertService(ParameterDTO parameterDTO) {

        List<String> parameterName = new ArrayList<>();

        parameterName = Arrays.stream(parameterDTO.getParameter()).
                map(parameter -> parameter.split(" ")[1]).collect(Collectors.toList());

//        for(String parameter : parameterMessage.getParameter()){
//            parameterName.add(parameter.split(" ")[1]);
//        }

        String insertCommand = mybatisProduceService.mybatisInsert(parameterName, parameterDTO.getTableName());
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,insertCommand);
    }

    @Override
    public BackMessage<String> MybatisUpdateService(ParameterDTO parameterDTO) {

        List<String> parameterName = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        for(String keyParameter : parameterDTO.getKeyParameter()){
            keyParameterName.add(keyParameter.split(" ")[1]);
        }
        for(String parameter : parameterDTO.getParameter()){
            parameterName.add(parameter.split(" ")[1]);
        }

        String updateCommand = mybatisProduceService.mybatisUpdate(keyParameterName,parameterName, parameterDTO.getTableName());
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,updateCommand);
    }

    @Override
    public BackMessage<String> MybatisDeleteService(ParameterDTO parameterDTO) {

        List<String> keyParameterName = new ArrayList<>();

        for(String keyParameter : parameterDTO.getKeyParameter()){
            keyParameterName.add(keyParameter.split(" ")[1]);
        }

        String deleteCommand = mybatisProduceService.mybatisDelete(keyParameterName, parameterDTO.getTableName());
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,deleteCommand);
    }

    @Override
    public BackMessage<String> MybatisSelectService(ParameterDTO parameterDTO) {

        List<String> parameterName = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        for(String keyParameter : parameterDTO.getKeyParameter()){
            keyParameterName.add(keyParameter.split(" ")[1]);
        }
        for(String parameter : parameterDTO.getParameter()){
            parameterName.add(parameter.split(" ")[1]);
        }
        String selectCommand = mybatisProduceService.mybatisSelect(keyParameterName,parameterName, parameterDTO.getTableName());

        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,selectCommand);
    }
}
