package com.example.java_tools.controller;

import com.example.java_tools.service.SQLConvertService;
import com.example.java_tools.utils.BackMessage;
import com.example.java_tools.utils.json_msg.ParameterMessage;
import com.example.java_tools.utils.json_msg.StringDataMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = {"*"}, allowCredentials = "true")
@RestController
public class SQLConvertController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SQLConvertService sqlService;


    /**
     * 创表命令
     * @param parameterMessage parameter，tbName
     * @return 创表命令 String
     */
    @PostMapping("/createSQL")
    public BackMessage createSqlCommandController(@RequestBody ParameterMessage parameterMessage){

        logger.info("parameterMessage = " + parameterMessage.toString());

        BackMessage backMessage = sqlService.createSqlService(parameterMessage);

        return backMessage;
    }

    /**
     * 更新数据库表命令
     * @param parameterMessage parameter,keyParameter,tbName
     * @return 更新数据库表命令 String
     */
    @PostMapping("/updateTable")
    public BackMessage updateTableController(@RequestBody ParameterMessage parameterMessage){

        logger.info("parameterMessage = " + parameterMessage.toString());

        BackMessage backMessage = sqlService.updateTableService(parameterMessage);

        return backMessage;
    }

    /**
     * 插入数据库数据命令Controller
     * @param parameterMessage parameter，tbName
     * @return 插入数据命令
     */
    @PostMapping("/insertMsg")
    public BackMessage insertMsgController(@RequestBody ParameterMessage parameterMessage) {

        logger.info("parameterMessage = " + parameterMessage.toString());

        BackMessage backMessage = sqlService.insertMsgService(parameterMessage);

        return backMessage;
    }

    /**
     * 生成删除信息命令
     * @param parameterMessage keyParameter,tbName
     * @return 删除信息命令
     */
    @PostMapping("/deleteMsg")
    public BackMessage deleteMsgController(@RequestBody ParameterMessage parameterMessage){

        logger.info("parameterMessage = " + parameterMessage.toString());

        BackMessage backMessage = sqlService.deleteMsg(parameterMessage);

        return backMessage;
    }

    /**
     * 生成查询信息命令
     * @param parameterMessage parameter，keyParameter，tbName
     * @return
     */
    @PostMapping("/selectTable")
    public BackMessage selectTableController(@RequestBody ParameterMessage parameterMessage){

        logger.info("parameterMessage = " + parameterMessage.toString());

        BackMessage backMessage = sqlService.selectMsg(parameterMessage);

        return backMessage;
    }

}
