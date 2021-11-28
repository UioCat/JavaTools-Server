package com.uio.java_tools.controller;

import com.uio.java_tools.service.MybatisConvertService;
import com.uio.java_tools.common.BackMessage;
import com.uio.java_tools.dto.ParameterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MybatisConvertController {

    @Autowired
    private MybatisConvertService mybatisConvertService;

    /**
     * mybatis基础信息创建
     *
     * @param parameterDTO namespace
     * @return
     */
    @RequestMapping("/mybatisBasics")
    public BackMessage<String> mybatisBatisController(@RequestBody ParameterDTO parameterDTO) {
        return BackMessage.success(mybatisConvertService.mybatisBasicsService(parameterDTO));
    }

    /**
     * mybatis插入数据 创建
     *
     * @param parameterDTO parameter tbName
     * @return
     */
    @RequestMapping("/mybatisInsert")
    public BackMessage<String> mybatisInsertController(@RequestBody ParameterDTO parameterDTO) {
        return BackMessage.success(mybatisConvertService.mybatisInsertService(parameterDTO));
    }

    /**
     * mybatis 删除数据 创建
     *
     * @param parameterDTO keyParameter tbName
     * @return
     */
    @RequestMapping("/mybatisDelete")
    public BackMessage<String> mybatisDeleteController(@RequestBody ParameterDTO parameterDTO) {
        return BackMessage.success(mybatisConvertService.mybatisDeleteService(parameterDTO));
    }

    /**
     * mybatis 修改数据 创建
     *
     * @param parameterDTO parameter,keyParameter,tbName
     * @return
     */
    @RequestMapping("/mybatisUpdate")
    public BackMessage<String> mybatisUpdate(@RequestBody ParameterDTO parameterDTO) {
        return BackMessage.success(mybatisConvertService.mybatisUpdateService(parameterDTO));
    }

    @RequestMapping("/mybatisSelect")
    public BackMessage<String> mybatisSelect(@RequestBody ParameterDTO parameterDTO) {
        return BackMessage.success(mybatisConvertService.mybatisSelectService(parameterDTO));
    }

}
