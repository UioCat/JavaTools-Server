package com.uio.java_tools.service.impl;

import com.uio.java_tools.service.MybatisConvertService;
import com.uio.java_tools.manager.impl.MybatisProduceManagerImpl;
import com.uio.java_tools.dto.ParameterDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MybatisConvertServiceImpl implements MybatisConvertService {

    @Autowired
    private MybatisProduceManagerImpl mybatisProduceService;

    @Override
    public String mybatisBasicsService(ParameterDTO parameterDTO) {
        String basicsCommand = mybatisProduceService.mybatisBasics(parameterDTO.getNamespace());
        return basicsCommand;
    }

    @Override
    public String mybatisInsertService(ParameterDTO parameterDTO) {

        List<String> parameterName = new ArrayList<>();

        parameterName = Arrays.stream(parameterDTO.getParameter()).
                map(parameter -> parameter.split(" ")[1]).collect(Collectors.toList());

        return mybatisProduceService.mybatisInsert(parameterName, parameterDTO.getTableName());
    }

    @Override
    public String mybatisUpdateService(ParameterDTO parameterDTO) {

        List<String> parameterName = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        for(String keyParameter : parameterDTO.getKeyParameter()){
            keyParameterName.add(keyParameter.split(" ")[1]);
        }
        for(String parameter : parameterDTO.getParameter()){
            parameterName.add(parameter.split(" ")[1]);
        }

        String updateCommand = mybatisProduceService.mybatisUpdate(keyParameterName,parameterName, parameterDTO.getTableName());
        return updateCommand;
    }

    @Override
    public String mybatisDeleteService(ParameterDTO parameterDTO) {

        List<String> keyParameterName = new ArrayList<>();

        for(String keyParameter : parameterDTO.getKeyParameter()){
            keyParameterName.add(keyParameter.split(" ")[1]);
        }

        return mybatisProduceService.mybatisDelete(keyParameterName, parameterDTO.getTableName());
    }

    @Override
    public String mybatisSelectService(ParameterDTO parameterDTO) {

        List<String> parameterName = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        for(String keyParameter : parameterDTO.getKeyParameter()){
            keyParameterName.add(keyParameter.split(" ")[1]);
        }
        for(String parameter : parameterDTO.getParameter()){
            parameterName.add(parameter.split(" ")[1]);
        }

        return mybatisProduceService.mybatisSelect(keyParameterName,parameterName, parameterDTO.getTableName());
    }
}
