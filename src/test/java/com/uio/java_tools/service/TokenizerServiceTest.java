package com.uio.java_tools.service;

import com.uio.java_tools.enums.RegexEnum;
import com.uio.java_tools.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void getCommentTest() {
        String parameter = "        /**\n" +
                "         * 编码\n" +
                "         */\n" +
                "        private String foo = \"123123\";";
        System.out.println(parameter);
        Pattern commentRegex = Pattern.compile(RegexEnum.TYPE_FIELD_REGEX.getRegexString(),Pattern.CASE_INSENSITIVE);
        Matcher commentMatcher = commentRegex.matcher(parameter);
        commentMatcher.find();
        String s = parameter.substring(commentMatcher.start(), commentMatcher.end());
        System.out.println(s);
        String[] split = s.split("[= ;]+");
        System.out.println(Arrays.toString(split));
    }
}
