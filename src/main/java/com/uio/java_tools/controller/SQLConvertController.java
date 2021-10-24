package com.uio.java_tools.controller;

import com.uio.java_tools.service.SQLConvertService;
import com.uio.java_tools.utils.BackMessage;
import com.uio.java_tools.dto.ParameterDTO;
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
     * @param parameterDTO parameter，tbName
     * @return 创表命令 String
     */
    @PostMapping("/createSQL")
    public BackMessage<String> createSqlCommandController(@RequestBody ParameterDTO parameterDTO){
        
        logger.info("parameterMessage = " + parameterDTO.toString());
        return sqlService.createSqlService(parameterDTO);
    }

    /**
     * 更新数据库表命令
     * @param parameterDTO parameter,keyParameter,tbName
     * @return 更新数据库表命令 String
     */
    @PostMapping("/updateTable")
    public BackMessage<String> updateTableController(@RequestBody ParameterDTO parameterDTO){

        logger.info("parameterMessage = " + parameterDTO.toString());
        return sqlService.updateTableService(parameterDTO);
    }

    /**
     * 插入数据库数据命令Controller
     * @param parameterDTO parameter，tbName
     * @return 插入数据命令
     */
    @PostMapping("/insertMsg")
    public BackMessage<String> insertMsgController(@RequestBody ParameterDTO parameterDTO) {

        logger.info("parameterMessage = " + parameterDTO.toString());
        return sqlService.insertMsgService(parameterDTO);
    }

    /**
     * 生成删除信息命令
     * @param parameterDTO keyParameter,tbName
     * @return 删除信息命令
     */
    @PostMapping("/deleteMsg")
    public BackMessage<String> deleteMsgController(@RequestBody ParameterDTO parameterDTO){

        logger.info("parameterMessage = " + parameterDTO.toString());
        BackMessage<String> backMessage = sqlService.deleteMsg(parameterDTO);
        return backMessage;
    }

    /**
     * 生成查询信息命令
     * @param parameterDTO parameter，keyParameter，tbName
     * @return
     */
    @PostMapping("/selectTable")
    public BackMessage<String> selectTableController(@RequestBody ParameterDTO parameterDTO){

        logger.info("parameterMessage = " + parameterDTO.toString());
        return sqlService.selectMsg(parameterDTO);
    }

}
