package com.uio.java_tools.service;

import com.uio.java_tools.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author han xun
 * Date 2021/6/5 00:17
 * Description: 分词解析器
 */
@SpringBootTest
public class TokenizerServiceTest {

    @Autowired
    private TokenizerService tokenizerService;

    /**
     * 解析出的数据应有的数量
     */
    private static final int listSize = 9;

    /**
     * 待测试文本存储路径
     */
    private static String filePath = "target/classes/static/testJava.txt";

    @Test
    public void extractFieldFromJavaCodeTest() {

        String testString = TestUtils.readTestString(filePath);
        List<String> list = tokenizerService.extractFieldFromJavaCode(testString);
        System.out.println(list.size());
        assertEquals(list.size(), listSize);
    }


}
