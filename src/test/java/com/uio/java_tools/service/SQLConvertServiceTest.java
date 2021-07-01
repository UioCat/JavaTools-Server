package com.uio.java_tools.service;

import com.uio.java_tools.manager.impl.ParseStrManagerImpl;
import com.uio.java_tools.manager.impl.VelocityTemplateForSQL;
import com.uio.java_tools.service.impl.SQLConvertServiceImpl;
import com.uio.java_tools.utils.BackMessage;
import com.uio.java_tools.dto.ParameterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

/**
 * @author VM
 * Date 15:54
 * Description:
 */
@SpringBootTest
class SQLConvertServiceTest {
    // 被测试Service
    @Autowired
    SQLConvertServiceImpl sqlConvertService;

    // mock对象
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

    /**
     * 创建表sql生成测试
     */
    @Test
    public void createTest() {
        // mock测试打桩
        Mockito.when(parse.typeConvertForMysql(Mockito.anyString())).thenReturn("123");
        Mockito.when(parse.upperToLower(Mockito.anyString())).thenReturn("123");
        Mockito.when(velocityTemplateForSQL.createSQLTemplate(Mockito.anyList(), Mockito.anyList(), Mockito.anyString())).
                thenReturn("创建表sql");

        // 反射注入mock对象
        try {
            Field parseField = SQLConvertServiceImpl.class.getDeclaredField("parse");
            Field velocityField = SQLConvertServiceImpl.class.getDeclaredField("velocityTemplateForSQL");
            parseField.setAccessible(true);
            velocityField.setAccessible(true);
            parseField.set(sqlConvertService,parse);
            velocityField.set(sqlConvertService,velocityTemplateForSQL);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // mock测试
        BackMessage<String> backMessage = sqlConvertService.createSqlService(parameterDTO);
        Assertions.assertEquals(200,backMessage.getCode());
        System.out.println(backMessage.getInfo());
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
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // mock测试
        BackMessage backMessage = sqlConvertService.updateTableService(parameterDTO);
        Assertions.assertEquals(200, backMessage.getCode());
        System.out.println(backMessage.getInfo());
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

        // mock测试
        BackMessage backMessage = sqlConvertService.selectMsg(parameterDTO);
        Assertions.assertEquals(200, backMessage.getCode());
        System.out.println(backMessage.getInfo());
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
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // mock测试
        BackMessage backMessage = sqlConvertService.deleteMsg(parameterDTO);
        Assertions.assertEquals(200, backMessage.getCode());
        System.out.println(backMessage.getInfo());
    }

    /**
     * 插入sql生成测试
     */
    @Test
    public void insertTest(){
        // mock测试打桩
        Mockito.when(parse.upperToLower(Mockito.anyString())).thenReturn("123");
        Mockito.when(velocityTemplateForSQL.insertSQLTemplate(Mockito.anyList(),Mockito.anyString())).thenReturn("插入sql");

        // 反射注入mock对象
        try {
            Field velocityField = SQLConvertServiceImpl.class.getDeclaredField("velocityTemplateForSQL");
            Field parseField = SQLConvertServiceImpl.class.getDeclaredField("parse");
            velocityField.setAccessible(true);
            parseField.setAccessible(true);
            velocityField.set(sqlConvertService,velocityTemplateForSQL);
            parseField.set(sqlConvertService,parse);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // mock测试
        BackMessage<String> backMessage = sqlConvertService.insertMsgService(parameterDTO);
        Assertions.assertEquals(200,backMessage.getCode());
        System.out.println(backMessage.getInfo());
    }
}
