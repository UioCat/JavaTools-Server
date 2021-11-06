package com.uio.java_tools.service.impl;


import com.uio.java_tools.controller.req.CreateSqlReq;
import com.uio.java_tools.dto.AnalysisDTO;
import com.uio.java_tools.dto.Parameter;
import com.uio.java_tools.dto.ParameterDTO;
import com.uio.java_tools.manager.impl.ParseStrManagerImpl;
import com.uio.java_tools.manager.impl.VelocityTemplateForSQL;
import com.uio.java_tools.service.SQLConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SQLConvertServiceImpl implements SQLConvertService {

    @Autowired
    private ParseStrManagerImpl parse;

    @Autowired
    private VelocityTemplateForSQL velocityTemplateForSQL;

    /**
     *
     * 创建数据库命令
     * @param createSqlReq
     * @return 创建数据库命令
     */
    @Override
    public String createSqlService(CreateSqlReq createSqlReq) {

        for (Parameter parameter: createSqlReq.getParameterList()) {
            parameter.setField(parse.upperToLower(parameter.getField()));
        }

        return velocityTemplateForSQL.createSQLTemplate(createSqlReq.getParameterList(), createSqlReq.getTableName(), createSqlReq.getPrimaryKey());
    }


    /**
     *
     * 更新数据库表命令
     * @param parameterDTO parameter,keyParameter,tbName
     * @return 更新数据库命令
     */
    @Override
    public String updateTableService(ParameterDTO parameterDTO) {
        // 需求改的参数
        List<String> parameterType = new ArrayList<>();
        List<String> parameterName = new ArrayList<>();

        // 用于判断的参数
        List<String> keyParameterType = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        for (String parameter: parameterDTO.getKeyParameter()) {
            keyParameterType.add(parameter.split(" ")[0]);
            keyParameterName.add(parameter.split(" ")[1]);
        }
        for (String parameter: parameterDTO.getParameter()) {
            parameterType.add(parameter.split(" ")[0]);
            parameterName.add(parameter.split(" ")[1]);
        }

        String updateSQL = velocityTemplateForSQL.updateSQLTemplate(parameterType, parameterName,
                keyParameterType, keyParameterName, parameterDTO.getTableName());
        return updateSQL;
    }

    /**
     *
     * 插入数据库命令
     * @param parameterDTO parameter，tbName
     * @return 插入数据库命令
     */
    @Override
    public String insertMsgService(ParameterDTO parameterDTO) {

        List<String> parameterName = new ArrayList<>();

        for (String parameter: parameterDTO.getParameter()) {
            parameterName.add(parse.upperToLower(parameter.split(" ")[1]));

        }

        String insertSQL = velocityTemplateForSQL.insertSQLTemplate(parameterName, parameterDTO.getTableName());
        return insertSQL;
    }

    /**
     *
     * 生成删除信息命令
     * @param parameterDTO keyParameter,tbName
     * @return 删除信息命令
     */
    @Override
    public String deleteMsg(ParameterDTO parameterDTO) {

        List<String> keyParameterType = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        for (String keyParameter: parameterDTO.getKeyParameter()) {
            keyParameterType.add(keyParameter.split(" ")[0]);
            keyParameterName.add(keyParameter.split(" ")[1]);
        }

        String deleteSQL = velocityTemplateForSQL.deleteSQLTemplate(keyParameterType, keyParameterName, parameterDTO.getTableName());

        return deleteSQL;
    }

    /**
     *
     * 查询信息命令生成
     * @param parameterDTO parameter，keyParameter，tbName
     * @return 查询数据库信息命令
     */
    @Override
    public String selectMsg(ParameterDTO parameterDTO) {

        List<String> keyParameterType = new ArrayList<>();
        List<String> keyParameterName = new ArrayList<>();

        List<String> parameterName = new ArrayList<>();


        for (String keyParameter: parameterDTO.getKeyParameter()) {
            keyParameterType.add(keyParameter.split(" ")[0]);
            keyParameterName.add(keyParameter.split(" ")[1]);
        }

        for (String parameter: parameterDTO.getParameter()) {
            parameterName.add(parameter.split(" ")[1]);
        }

        String selectSQL = velocityTemplateForSQL.selectSQLTemplate(parameterName, keyParameterType, keyParameterName, parameterDTO.getTableName());

        return selectSQL;
    }

}
