package com.example.java_tools.service.impl;


import com.example.java_tools.enums.BackEnum;
import com.example.java_tools.manager.impl.ParseStrManagerImpl;
import com.example.java_tools.manager.impl.SQLProduceService;
import com.example.java_tools.manager.impl.VelocityTemplateForSQL;
import com.example.java_tools.service.SQLConvertService;
import com.example.java_tools.utils.BackMessage;
import com.example.java_tools.utils.json_msg.ParameterMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SQLConvertServiceImpl implements SQLConvertService {

    @Autowired
    private ParseStrManagerImpl parse;

    @Autowired
    private SQLProduceService sqlProduceService;

    @Autowired
    private VelocityTemplateForSQL velocityTemplateForSQL;

    @Override
    public BackMessage<String> createSqlService(ParameterMessage parameterMessage) {

        List<String> parameterType = new ArrayList<>();
        List<String> parameterName = new ArrayList<>();

        for (String parameter : parameterMessage.getParameter()) {
            parameterType.add(parse.typeConvertForMysql(parameter.split(" ")[0]));
            parameterName.add(parse.upperToLower(parameter.split(" ")[1]));
        }

        String SQLCommand = velocityTemplateForSQL.createSQLTemplate(parameterType,parameterName,parameterMessage.getTbName());

        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,SQLCommand);
    }

    @Override
    public BackMessage<String> updateTableService(ParameterMessage parameterMessage) {

        /*
        需求改的参数
         */
        List<String> parameterType = new ArrayList<>();
        List<String> parameterName = new ArrayList<>();

        /*
        用于判断的参数
         */
        List<String> keyParameterType = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        for(String parameter : parameterMessage.getKeyParameter()){
            keyParameterType.add(parameter.split(" ")[0]);
            keyParameterName.add(parameter.split(" ")[1]);
        }
        for (String parameter : parameterMessage.getParameter()) {
            parameterType.add(parameter.split(" ")[0]);
            parameterName.add(parameter.split(" ")[1]);
        }

        String updateSQL = sqlProduceService.composeSqlUpdate(keyParameterType,keyParameterName,
                                                  parameterType,parameterName,
                                                  parameterMessage.getTbName());

        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,updateSQL);
    }

    @Override
    public BackMessage<String> insertMsgService(ParameterMessage parameterMessage){

        List<String> parameterName = new ArrayList<>();

        for(String parameter : parameterMessage.getParameter()){
            parameterName.add(parse.upperToLower(parameter.split(" ")[1]));
        }

        String insertSQL = velocityTemplateForSQL.insertSQLTemplate(parameterName, parameterMessage.getTbName());
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,insertSQL);
    }

    @Override
    public BackMessage<String> deleteMsg(ParameterMessage parameterMessage){

        List<String> keyParameterType = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        for(String keyParameter : parameterMessage.getKeyParameter()){
            keyParameterType.add(keyParameter.split(" ")[0]);
            keyParameterName.add(keyParameter.split(" ")[1]);
        }

        String deleteSQL = sqlProduceService.composeSQLDelete(keyParameterType,keyParameterName,parameterMessage.getTbName());

        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,deleteSQL);
    }

    @Override
    public BackMessage<String> selectMsg(ParameterMessage parameterMessage){

        List<String> keyParameterType = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        List<String> parameterName = new ArrayList<>();


        for(String keyParameter : parameterMessage.getKeyParameter()){
            keyParameterType.add(keyParameter.split(" ")[0]);
            keyParameterName.add(keyParameter.split(" ")[1]);
        }

        for(String parameter : parameterMessage.getParameter()){
            parameterName.add(parameter.split(" ")[1]);
        }

        String selectSQL = sqlProduceService.composeSQLSelect(parameterName,
                keyParameterType,keyParameterName,parameterMessage.getTbName());

        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,selectSQL);

    }

}
