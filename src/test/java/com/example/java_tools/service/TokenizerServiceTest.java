package com.example.java_tools.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
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

    @Test
    public void extractFieldFromJavaCodeTest() {
        String testString = readTestString();
        List<String> list = tokenizerService.extractFieldFromJavaCode(testString);
        System.out.println(list.size());
        assertEquals(list.size(), listSize);
    }

    private String readTestString() {
        try {
            File file = new File("target/classes/static/testEntity.txt");
            InputStream is = new FileInputStream(file);
            byte[] byteArray = new byte[(int) file.length()];
            is.read(byteArray);
            is.close();
            return new String(byteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
