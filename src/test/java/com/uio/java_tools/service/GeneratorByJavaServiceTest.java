/*
package com.uio.java_tools.service;

import com.uio.java_tools.utils.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

*/
/**
 * @author han xun
 * Date 2021/6/27 01:16
 * Description:
 *//*

@SpringBootTest
public class GeneratorByJavaServiceTest {

    @Autowired
    @Qualifier("generatorByJavaServiceImpl")
    private GeneratorService generatorService;

    */
/**
     * 解析出的数据应有的数量
     *//*

    private static final int listSize = 9;

    */
/**
     * 待测试文本存储路径
     *//*

    private static String filePath = "target/classes/static/testJava.txt";

    @Test
    public void parseJavaTest() {
        String testString = FileUtils.readTestString(filePath);
        JavaParseParameterDTO javaParseParameterDTO = generatorService.parse(testString);
        assertEquals(javaParseParameterDTO.getFieldList().size(), listSize);
        assertEquals(javaParseParameterDTO.getPackageName(), "com.example.java_tools");
        assertEquals(javaParseParameterDTO.getClassName(), "Entity");
    }


}
*/
