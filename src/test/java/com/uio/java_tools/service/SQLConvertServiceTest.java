package com.uio.java_tools.service;

import com.uio.java_tools.service.impl.SQLConvertServiceImpl;
import com.uio.java_tools.utils.BackMessage;
import com.uio.java_tools.dto.ParameterDTO;
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
    ParameterDTO parameterDTO = new ParameterDTO();

    {
        parameterDTO.setParameter(new String[]{"String uid", "String username", "String password", "Long createTime", "Integer role"});
        parameterDTO.setKeyParameter(new String[]{"String uid", "String username"});
        parameterDTO.setTableName("tb_user");
    }

    @Test
    public void updateTest() {
        BackMessage backMessage = sqlConvertService.updateTableService(parameterDTO);
        System.out.println(backMessage.getInfo());
    }

    @Test
    public void selectTest(){
        BackMessage backMessage = sqlConvertService.selectMsg(parameterDTO);
        System.out.println(backMessage.getInfo());
    }

    @Test
    public void deleteTest(){
        BackMessage backMessage = sqlConvertService.deleteMsg(parameterDTO);
        System.out.println(backMessage.getInfo());
    }
}
