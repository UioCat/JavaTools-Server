package com.uio.java_tools.service;

import com.alibaba.fastjson.JSON;
import com.uio.java_tools.controller.req.CreateSqlReq;
import com.uio.java_tools.controller.req.SqlParameter;
import com.uio.java_tools.dto.AnalysisDTO;
import com.uio.java_tools.dto.Parameter;
import com.uio.java_tools.manager.impl.ParseStrManagerImpl;
import com.uio.java_tools.manager.impl.VelocityTemplateForSQL;
import com.uio.java_tools.service.impl.SQLConvertServiceImpl;
import com.uio.java_tools.dto.ParameterDTO;
import com.uio.java_tools.service.impl.TokenizerJavaServiceImpl;
import com.uio.java_tools.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author VM
 * Date 15:54
 * Description:
 */
@SpringBootTest
@Slf4j
class SQLConvertServiceTest {

    @Autowired
    private SQLConvertServiceImpl sqlConvertService;
    @Autowired
    private TokenizerJavaServiceImpl tokenizerJavaService;

    @Mock
    private ParseStrManagerImpl parse;
    @Mock
    private VelocityTemplateForSQL velocityTemplateForSQL;

    ParameterDTO parameterDTO = new ParameterDTO();

    @BeforeEach
    private void createMessage() {
        parameterDTO.setParameter(new String[]{"String uid", "String username", "String password", "Long createTime", "Integer role"});
        parameterDTO.setKeyParameter(new String[]{"String uid", "String username"});
        parameterDTO.setTableName("tb_user");
    }

    private final static String FILE_PATH_JAVA = "target/classes/static/testJava.txt";

    /**
     * 解析Java并生成创表命令单测
     */
    @Test
    public void createSqlService() {
        String testString = FileUtils.readTestString(FILE_PATH_JAVA);
        AnalysisDTO analysisDTO = tokenizerJavaService.analysisText(testString);
        log.info("tokenizerService.parseJavaEntityCode result:{}", analysisDTO);

        List<SqlParameter> sqlParameterList = new ArrayList<>(analysisDTO.getParameters().size());
        for (Parameter parameter : analysisDTO.getParameters()) {
            SqlParameter sqlParameter = new SqlParameter();
            sqlParameter.setType(parameter.getType());
            sqlParameter.setDatatype(parameter.getDatatype());
            sqlParameter.setField(parameter.getField());
            sqlParameter.setComment(parameter.getComment());
            sqlParameter.setDefaultValue(parameter.getDefaultValue());
            sqlParameter.setUniqueKey(true);
        }

        CreateSqlReq createSqlReq = new CreateSqlReq();
        createSqlReq.setParameterList(sqlParameterList);
        createSqlReq.setTableName(analysisDTO.getTableName());
        createSqlReq.setPrimaryKey(analysisDTO.getPrimaryKey());
        sqlConvertService.createSqlService(createSqlReq);
    }

    /**
     * 创建表sql生成测试
     */
    @Test
    public void createTest() {
        // mock测试打桩
        Mockito.when(parse.typeConvertForMysql(Mockito.anyString())).thenReturn("123");
        Mockito.when(parse.upperToLower(Mockito.anyString())).thenReturn("123");

        // 反射注入mock对象
        try {
            Field parseField = SQLConvertServiceImpl.class.getDeclaredField("parse");
            Field velocityField = SQLConvertServiceImpl.class.getDeclaredField("velocityTemplateForSQL");
            parseField.setAccessible(true);
            velocityField.setAccessible(true);
            parseField.set(sqlConvertService, parse);
            velocityField.set(sqlConvertService, velocityTemplateForSQL);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // mock测试
    }

    /**
     * 更新sql生成测试
     */
    @Test
    public void updateTest() {
        // mock测试打桩
        Mockito.when(velocityTemplateForSQL.updateSQLTemplate(Mockito.anyList(), Mockito.anyList(),
                Mockito.anyList(), Mockito.anyList(), Mockito.anyString())).
                thenReturn("更新sql");
        // 反射注入mock对象
        try {
            Field f = SQLConvertServiceImpl.class.getDeclaredField("velocityTemplateForSQL");
            f.setAccessible(true);
            f.set(sqlConvertService, velocityTemplateForSQL);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            log.warn("updateTest exception, ", e);
        }

        // mock测试
        String s = sqlConvertService.updateTableService(parameterDTO);
        log.info(JSON.toJSONString(s));
    }

    /**
     * 查找sql生成测试
     */
    @Test
    public void selectTest() {
        // mock测试打桩
        Mockito.when(velocityTemplateForSQL.selectSQLTemplate(Mockito.anyList(), Mockito.anyList(),
                Mockito.anyList(), Mockito.anyString())).
                thenReturn("查找sql");
        // 反射注入mock对象
        try {
            Field f = SQLConvertServiceImpl.class.getDeclaredField("velocityTemplateForSQL");
            f.setAccessible(true);
            f.set(sqlConvertService, velocityTemplateForSQL);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        log.info(JSON.toJSONString(sqlConvertService.selectMsg(parameterDTO)));
    }

    /**
     * 删除sql生成测试
     */
    @Test
    public void deleteTest() {
        // mock测试打桩
        Mockito.when(velocityTemplateForSQL.deleteSQLTemplate(Mockito.anyList(), Mockito.anyList(), Mockito.anyString())).
                thenReturn("删除sql");

        // 反射注入mock对象
        try {
            Field f = SQLConvertServiceImpl.class.getDeclaredField("velocityTemplateForSQL");
            f.setAccessible(true);
            f.set(sqlConvertService, velocityTemplateForSQL);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            log.warn("deleteTest exception, ", e);
        }

        log.info(JSON.toJSONString(sqlConvertService.deleteMsg(parameterDTO)));
    }

    /**
     * 插入sql生成测试
     */
    @Test
    public void insertTest() {
        // mock测试打桩
        Mockito.when(parse.upperToLower(Mockito.anyString())).thenReturn("123");
        Mockito.when(velocityTemplateForSQL.insertSQLTemplate(Mockito.anyList(), Mockito.anyString())).thenReturn("插入sql");

        // 反射注入mock对象
        try {
            Field velocityField = SQLConvertServiceImpl.class.getDeclaredField("velocityTemplateForSQL");
            Field parseField = SQLConvertServiceImpl.class.getDeclaredField("parse");
            velocityField.setAccessible(true);
            parseField.setAccessible(true);
            velocityField.set(sqlConvertService, velocityTemplateForSQL);
            parseField.set(sqlConvertService, parse);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            log.warn("insertTest exception, ", e);
        }

        log.info(sqlConvertService.insertMsgService(parameterDTO));
    }
}
