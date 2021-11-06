package com.uio.java_tools.controller;

import com.uio.java_tools.common.BackMessage;
import com.uio.java_tools.controller.req.CreateSqlReq;
import com.uio.java_tools.dto.AnalysisDTO;
import com.uio.java_tools.service.SQLConvertService;
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
     * @param createSqlReq
     * @return 创表命令 String
     */
    @PostMapping("/createSQL")
    public BackMessage<String> createSQL(@RequestBody CreateSqlReq createSqlReq){
        
        return BackMessage.success(sqlService.createSqlService(createSqlReq));
    }

    /**
     * 更新数据库表命令
     * @param parameterDTO parameter,keyParameter,tbName
     * @return 更新数据库表命令 String
     */
    @PostMapping("/updateTable")
    public BackMessage<String> updateTable(@RequestBody ParameterDTO parameterDTO){

        return BackMessage.success(sqlService.updateTableService(parameterDTO));
    }

    /**
     * 插入数据库数据命令Controller
     * @param parameterDTO parameter，tbName
     * @return 插入数据命令
     */
    @PostMapping("/insertMsg")
    public BackMessage<String> insertMsg(@RequestBody ParameterDTO parameterDTO) {

        return BackMessage.success(sqlService.insertMsgService(parameterDTO));
    }

    /**
     * 生成删除信息命令
     * @param parameterDTO keyParameter,tbName
     * @return 删除信息命令
     */
    @PostMapping("/deleteMsg")
    public BackMessage<String> deleteMsg(@RequestBody ParameterDTO parameterDTO){

        logger.info("parameterMessage = " + parameterDTO.toString());
        return BackMessage.success(sqlService.deleteMsg(parameterDTO));
    }

    /**
     * 生成查询信息命令
     * @param parameterDTO parameter，keyParameter，tbName
     * @return
     */
    @PostMapping("/selectTable")
    public BackMessage<String> selectTable(@RequestBody ParameterDTO parameterDTO){

        return BackMessage.success(sqlService.selectMsg(parameterDTO));
    }

}
