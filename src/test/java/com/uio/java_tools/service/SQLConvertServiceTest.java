package com.uio.java_tools.service;

import com.alibaba.fastjson.JSON;
import com.uio.java_tools.controller.req.CreateSqlReq;
import com.uio.java_tools.controller.req.SqlParameter;
import com.uio.java_tools.dto.AnalysisDTO;
import com.uio.java_tools.dto.Parameter;
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
import org.springframework.util.Assert;

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
    private VelocityTemplateForSQL velocityTemplateForSQL;

    ParameterDTO parameterDTO = new ParameterDTO();

    @BeforeEach
    private void init() {
        parameterDTO.setParameter(new String[]{"String uid", "String username", "String password", "Long createTime", "Integer role"});
        parameterDTO.setKeyParameter(new String[]{"String uid", "String username"});
        parameterDTO.setTableName("tb_user");
    }

    /**
     * Java测试文件路径
     */
    private final static String FILE_PATH_JAVA = "target/classes/static/testJava.txt";
    private final static String FILE2_PATH_JAVA = "target/classes/static/testJava2.txt";

    /**
     * 解析Java字符串单测
     */
    @Test
    public void analysisJavaStrTest() {
        // 测试1
        String testString = FileUtils.readTestString(FILE_PATH_JAVA);
        AnalysisDTO analysisDTO = tokenizerJavaService.analysisText(testString);
        log.info("analysisDTO1:{}", JSON.toJSONString(analysisDTO));
        Assert.isTrue(10 == analysisDTO.getParameters().size(), "参数解析错误");
        log.info("tokenizerJavaService.analysisText1 字段解析成功");
        Assert.isTrue("tb_entity".equals(analysisDTO.getTableName()), "表名解析错误");
        log.info("tokenizerJavaService.analysisText1 表名解析成功");
        Assert.isTrue("com.example.java_tools.entity".equals(analysisDTO.getPackageName()), "包名解析错误");
        log.info("tokenizerJavaService.analysisText1 包名解析正确");
        // 测试2
        testString = FileUtils.readTestString(FILE2_PATH_JAVA);
        analysisDTO = tokenizerJavaService.analysisText(testString);
        log.info("analysisDTO2:{}", JSON.toJSONString(analysisDTO));
        Assert.isTrue(6 == analysisDTO.getParameters().size(), "参数解析错误");
        log.info("tokenizerJavaService.analysisText2 字段解析成功");
        Assert.isTrue("tb_user".equals(analysisDTO.getTableName()), "表名解析错误");
        log.info("tokenizerJavaService.analysisText2 表名解析成功");
        Assert.isTrue("com.example.java_tools".equals(analysisDTO.getPackageName()), "包名解析错误");
        log.info("tokenizerJavaService.analysisText2 包名解析正确");
    }

    /**
     * 生成创表命令单测
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
            sqlParameterList.add(sqlParameter);
        }

        CreateSqlReq createSqlReq = new CreateSqlReq();
        createSqlReq.setParameterList(sqlParameterList);
        createSqlReq.setTableName(analysisDTO.getTableName());
        createSqlReq.setPrimaryKey(analysisDTO.getPrimaryKey());
        String sqlStr = sqlConvertService.createSqlService(createSqlReq);
        log.info(sqlStr);
    }

    /**
     * 插入sql生成测试
     */
    @Test
    public void insertTest() {
        log.info(sqlConvertService.insertMsgService(parameterDTO));
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
}
