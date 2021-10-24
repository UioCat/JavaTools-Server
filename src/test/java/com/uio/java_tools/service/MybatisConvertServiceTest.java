package com.uio.java_tools.service;

import com.uio.java_tools.manager.impl.MybatisProduceManagerImpl;
import com.uio.java_tools.service.MybatisConvertService;
import com.uio.java_tools.service.impl.MybatisConvertServiceImpl;
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
 * Date 2021/6/27 12:36
 * Description:
 */
@SpringBootTest
public class MybatisConvertServiceTest {
    /**
     * 需要测试MybatisProduceManager时，直接将mock打桩和注入注释掉即可测试
     */

    // 待测试对象
    @Autowired
    private MybatisConvertService mybatisConvertService;
    // mock对象
    @Mock
    private MybatisProduceManagerImpl mybatisProduceManager;

    // 测试参数
    ParameterDTO parameterDTO = new ParameterDTO();

    @BeforeEach
    private void createMessage() {
        parameterDTO.setParameter(new String[]{"String uid", "String username", "String password", "Long createTime", "Integer role"});
        parameterDTO.setKeyParameter(new String[]{"String uid", "String username"});
        parameterDTO.setTableName("tb_user");
        parameterDTO.setNamespace("com.example.java_tools");
    }

    /**
     * 基础mapper文件生成服务测试
     */
    @Test
    public void MybatisBasicsServiceTest() {
        Mockito.when(mybatisProduceManager.mybatisBasics(Mockito.anyString())).thenReturn("基础mapper");

        try {
            Field f = MybatisConvertServiceImpl.class.getDeclaredField("mybatisProduceService");
            f.setAccessible(true);
            f.set(mybatisConvertService, mybatisProduceManager);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // namespace为空值时，返回值为空值
        BackMessage<String> backMessage = mybatisConvertService.MybatisBasicsService(parameterDTO);
        Assertions.assertNotNull(backMessage.getInfo());
        System.out.println(backMessage.getInfo());
    }

    /**
     * 插入语句mapper生成服务测试
     */
    @Test
    public void MybatisInsertServiceTest() {

        Mockito.when(mybatisProduceManager.mybatisInsert(Mockito.anyList(), Mockito.anyString())).thenReturn("插入mapper");

        try {
            Field f = MybatisConvertServiceImpl.class.getDeclaredField("mybatisProduceService");
            f.setAccessible(true);
            f.set(mybatisConvertService, mybatisProduceManager);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        BackMessage<String> backMessage = mybatisConvertService.MybatisInsertService(parameterDTO);
        Assertions.assertNotNull(backMessage.getInfo());
        System.out.println(backMessage.getInfo());

    }

    /**
     * 更新mapper生成服务测试
     */
    @Test
    public void MybatisUpdateServiceTest() {
        Mockito.when(mybatisProduceManager.mybatisUpdate(Mockito.anyList(), Mockito.anyList(), Mockito.anyString())).thenReturn("更新mapper");

        try {
            Field f = MybatisConvertServiceImpl.class.getDeclaredField("mybatisProduceService");
            f.setAccessible(true);
            f.set(mybatisConvertService, mybatisProduceManager);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        BackMessage<String> backMessage = mybatisConvertService.MybatisUpdateService(parameterDTO);
        Assertions.assertNotNull(backMessage.getInfo());
        System.out.println(backMessage.getInfo());
    }

    /**
     * 删除mapper生成测试
     */
    @Test
    public void MybatisDeleteServiceTest() {
        Mockito.when(mybatisProduceManager.mybatisDelete(Mockito.anyList(), Mockito.anyString())).thenReturn("删除mapper");

        try {
            Field f = MybatisConvertServiceImpl.class.getDeclaredField("mybatisProduceService");
            f.setAccessible(true);
            f.set(mybatisConvertService, mybatisProduceManager);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        BackMessage<String> backMessage = mybatisConvertService.MybatisDeleteService(parameterDTO);
        Assertions.assertNotNull(backMessage.getInfo());
        System.out.println(backMessage.getInfo());
    }

    /**
     * 查询mapper生成服务测试
     */
    @Test
    public void MybatisSelectServiceTest() {
        Mockito.when(mybatisProduceManager.mybatisSelect(Mockito.anyList(), Mockito.anyList(), Mockito.anyString())).thenReturn("查询mapper");

        try {
            Field f = MybatisConvertServiceImpl.class.getDeclaredField("mybatisProduceService");
            f.setAccessible(true);
            f.set(mybatisConvertService, mybatisProduceManager);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        BackMessage<String> backMessage = mybatisConvertService.MybatisSelectService(parameterDTO);
        Assertions.assertNotNull(backMessage.getInfo());
        System.out.println(backMessage.getInfo());
    }
}
