package com.example.java_tools.controller;

import com.example.java_tools.service.MybatisConvertService;
import com.example.java_tools.utils.BackMessage;
import com.example.java_tools.utils.json_msg.ParameterMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"*"}, allowCredentials = "true")
@RestController
public class MybatisConvertController {

    @Autowired
    private MybatisConvertService mybatisConvertService;

    /**
     * mybatis基础信息创建
     * @param parameterMessage namespace
     * @return
     */
    @RequestMapping("/mybatisBasics")
    public BackMessage<String> mybatisBatisController(@RequestBody ParameterMessage parameterMessage){
        return mybatisConvertService.MybatisBasicsService(parameterMessage);
    }

    /**
     * mybatis插入数据 创建
     * @param parameterMessage parameter tbName
     * @return
     */
    @RequestMapping("/mybatisInsert")
    public BackMessage<String> mybatisInsertController(@RequestBody ParameterMessage parameterMessage){
        return mybatisConvertService.MybatisInsertService(parameterMessage);
    }

    /**
     * mybatis 删除数据 创建
     * @param parameterMessage keyParameter tbName
     * @return
     */
    @RequestMapping("/mybatisDelete")
    public BackMessage<String> mybatisDeleteController(@RequestBody ParameterMessage parameterMessage){
        return mybatisConvertService.MybatisDeleteService(parameterMessage);
    }

    /**
     * mybatis 修改数据 创建
     * @param parameterMessage parameter,keyParameter,tbName
     * @return
     */
    @RequestMapping("/mybatisUpdate")
    public BackMessage mybatisUpdate(@RequestBody ParameterMessage parameterMessage){
        return mybatisConvertService.MybatisUpdateService(parameterMessage);
    }

    @RequestMapping("/mybatisSelect")
    public BackMessage mybatisSelect(@RequestBody ParameterMessage parameterMessage){
        return mybatisConvertService.MybatisSelectService(parameterMessage);
    }

}
