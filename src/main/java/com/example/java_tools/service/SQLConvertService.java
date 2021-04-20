package com.example.java_tools.service;


import com.example.java_tools.enums.BackEnum;
import com.example.java_tools.service.utils.ParseStrUtils;
import com.example.java_tools.service.utils.SQLProduceService;
import com.example.java_tools.utils.BackMessage;
import com.example.java_tools.utils.json_msg.ParameterMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SQLConvertService {

    @Autowired
    ParseStrUtils parse;

    @Autowired
    SQLProduceService sqlProduceService;

    /**
     * 根据参数写出创表命令
     * @param parameterMessage parameter，tbName
     * @return 创表命令
     */
    public BackMessage createSqlService(ParameterMessage parameterMessage) {

        List<String> parameterType = new ArrayList<>();
        List<String> parameterName = new ArrayList<>();

        for (String parameter : parameterMessage.getParameter()) {
            parameterType.add(parse.typeConvertForMysql(parameter.split(" ")[0]));
            parameterName.add(parse.upperToLower(parameter.split(" ")[1]));
        }

        String SQLCommand = sqlProduceService.composeSqlCommand(parameterType,parameterName,parameterMessage.getTbName());
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,SQLCommand);
    }


    /**
     * 更新数据库表命令
     * @param parameterMessage parameter,keyParameter,tbName
     * @return
     */
    public BackMessage updateTableService(ParameterMessage parameterMessage) {

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

    /**
     * 插入数据库命令
     * @param parameterMessage parameter，tbName
     * @return 参入数据库命令
     */
    public BackMessage insertMsgService(ParameterMessage parameterMessage){

        List<String> parameterType = new ArrayList<>();
        List<String> parameterName = new ArrayList<>();

        for(String parameter : parameterMessage.getParameter()){
            parameterType.add(parameter.split(" ")[0]);
            parameterName.add(parameter.split(" ")[1]);
        }

        String insertSQL = sqlProduceService.composeSQLInsert(parameterType,parameterName,parameterMessage.getTbName());
        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,insertSQL);
    }

    /**
     * 生成删除信息命令
     * @param parameterMessage keyParameter,tbName
     * @return 删除信息命令
     */
    public BackMessage deleteMsg(ParameterMessage parameterMessage){

        List<String> keyParameterType = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        for(String keyParameter : parameterMessage.getKeyParameter()){
            keyParameterType.add(keyParameter.split(" ")[0]);
            keyParameterName.add(keyParameter.split(" ")[1]);
        }

        String deleteSQL = sqlProduceService.composeSQLDelete(keyParameterType,keyParameterName,parameterMessage.getTbName());

        return new BackMessage<>(BackEnum.REQUEST_SUCCESS,deleteSQL);
    }

    /**
     * 查询信息命令生成
     * @param parameterMessage parameter，keyParameter，tbName
     * @return 查询数据库信息命令
     */
    public BackMessage selectMsg(ParameterMessage parameterMessage){

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
