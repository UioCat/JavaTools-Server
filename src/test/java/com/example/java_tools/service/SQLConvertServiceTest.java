package com.example.java_tools.service;

import com.example.java_tools.service.SQLConvertService;
import com.example.java_tools.service.impl.SQLConvertServiceImpl;
import com.example.java_tools.utils.BackMessage;
import com.example.java_tools.utils.json_msg.ParameterMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author VM
 * Date 15:54
 * Description:
 */
@SpringBootTest
class SQLConvertServiceTest {
    @Autowired
    SQLConvertServiceImpl sqlConvertService;
    ParameterMessage parameterMessage = new ParameterMessage();

    {
        parameterMessage.setParameter(new String[]{"String uid", "String username", "String password", "Long createTime", "Integer role"});
        parameterMessage.setKeyParameter(new String[]{"String uid", "String username"});
        parameterMessage.setTbName("tb_user");
    }

    @Test
    public void updateTest() {
        BackMessage backMessage = sqlConvertService.updateTableService(parameterMessage);
        System.out.println(backMessage.getInfo());
    }

    @Test
    public void selectTest(){
        BackMessage backMessage = sqlConvertService.selectMsg(parameterMessage);
        System.out.println(backMessage.getInfo());
    }

    @Test
    public void deleteTest(){
        BackMessage backMessage = sqlConvertService.deleteMsg(parameterMessage);
        System.out.println(backMessage.getInfo());
    }
}
