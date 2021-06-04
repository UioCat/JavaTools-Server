package com.example.java_tools.controller;

import com.example.java_tools.service.SQLConvertService;
import com.example.java_tools.utils.BackMessage;
import com.example.java_tools.utils.json_msg.ParameterMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class SQLConvertController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SQLConvertService sqlService;

    /**
     * 创表命令
     * @param parameterMessage parameter，tbName
     * @return 创表命令 String
     */
    @PostMapping("/createSQL")
    public BackMessage<String> createSqlCommandController(@RequestBody ParameterMessage parameterMessage){
        
        logger.info("parameterMessage = " + parameterMessage.toString());
        return sqlService.createSqlService(parameterMessage);
    }

    /**
     * 更新数据库表命令
     * @param parameterMessage parameter,keyParameter,tbName
     * @return 更新数据库表命令 String
     */
    @PostMapping("/updateTable")
    public BackMessage<String> updateTableController(@RequestBody ParameterMessage parameterMessage){

        logger.info("parameterMessage = " + parameterMessage.toString());
        return sqlService.updateTableService(parameterMessage);
    }

    /**
     * 插入数据库数据命令Controller
     * @param parameterMessage parameter，tbName
     * @return 插入数据命令
     */
    @PostMapping("/insertMsg")
    public BackMessage<String> insertMsgController(@RequestBody ParameterMessage parameterMessage) {

        logger.info("parameterMessage = " + parameterMessage.toString());
        return sqlService.insertMsgService(parameterMessage);
    }

    /**
     * 生成删除信息命令
     * @param parameterMessage keyParameter,tbName
     * @return 删除信息命令
     */
    @PostMapping("/deleteMsg")
    public BackMessage<String> deleteMsgController(@RequestBody ParameterMessage parameterMessage){

        logger.info("parameterMessage = " + parameterMessage.toString());
        BackMessage<String> backMessage = sqlService.deleteMsg(parameterMessage);
        return backMessage;
    }

    /**
     * 生成查询信息命令
     * @param parameterMessage parameter，keyParameter，tbName
     * @return
     */
    @PostMapping("/selectTable")
    public BackMessage<String> selectTableController(@RequestBody ParameterMessage parameterMessage){

        logger.info("parameterMessage = " + parameterMessage.toString());
        return sqlService.selectMsg(parameterMessage);
    }

}
