/*
package com.uio.java_tools.service;

import com.alibaba.fastjson.JSON;
import com.uio.java_tools.dto.ParseParameterDTO;
import com.uio.java_tools.service.impl.GeneratorBySQLServiceImpl;
import com.uio.java_tools.utils.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

*/
/**
 * @author han xun
 * Date 2021/7/3 12:07
 * Description:
 *//*

@SpringBootTest
public class GeneratorBySQLServiceTest {

    private final static String testFile = "target/classes/static/testSQL.txt";

    @Autowired
    private GeneratorBySQLServiceImpl generatorBySQLService;

    @Test
    public void parseTest() {
        ParseParameterDTO parseParameterDTO = generatorBySQLService.
                parse(Objects.requireNonNull(FileUtils.readTestString(testFile)));
        System.out.println(JSON.toJSONString(parseParameterDTO));
    }

    @Test
    public void test() {
        ParseParameterDTO parse = generatorBySQLService.parse("CREATE TABLE tb_config( id int(32),username varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,password varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,level varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL);");
        System.out.println(parse.toString());
    }

}
*/
