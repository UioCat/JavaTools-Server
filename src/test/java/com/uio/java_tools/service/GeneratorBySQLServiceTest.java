package com.uio.java_tools.service;

import com.alibaba.fastjson.JSON;
import com.uio.java_tools.dto.ParseParameterDTO;
import com.uio.java_tools.service.impl.GeneratorBySQLServiceImpl;
import com.uio.java_tools.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

/**
 * @author han xun
 * Date 2021/7/3 12:07
 * Description:
 */
@SpringBootTest
public class GeneratorBySQLServiceTest {

    private final static String testFile = "target/classes/static/testSQL.txt";

    @Autowired
    private GeneratorBySQLServiceImpl generatorBySQLService;

    @Test
    public void parseTest() {
        ParseParameterDTO parseParameterDTO = generatorBySQLService.
                parse(Objects.requireNonNull(TestUtils.readTestString(testFile)));
        System.out.println(JSON.toJSONString(parseParameterDTO));
    }

}
