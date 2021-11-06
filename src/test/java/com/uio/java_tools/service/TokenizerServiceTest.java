package com.uio.java_tools.service;

import com.uio.java_tools.dto.AnalysisDTO;
import com.uio.java_tools.enums.RegexEnum;
import com.uio.java_tools.service.impl.TokenizerJavaServiceImpl;
import com.uio.java_tools.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class TokenizerServiceTest {

    /**
     * 解析出的数据应有的数量
     */
    private static final int listSize = 9;

    /**
     * 待测试文本存储路径
     */
    private static String JAVA_FILE_PATH = "target/classes/static/testJava.txt";

    @Autowired
    private TokenizerJavaServiceImpl tokenizerJavaService;

    @Test
    public void parseJavaEntityCodeTest() {
        String testString = FileUtils.readTestString(JAVA_FILE_PATH);
        AnalysisDTO analysisDTO = tokenizerJavaService.analysisText(testString);
        log.info("tokenizerService.parseJavaEntityCode result:{}", analysisDTO);
    }

    @Test
    public void getCommentTest() {
        String parameter = "        /**\n" +
                "         * 编码\n" +
                "         */\n" +
                "        private String foo = \"123123\";";
        log.info(parameter);
        Pattern commentRegex = Pattern.compile(RegexEnum.TYPE_FIELD_REGEX.getRegexString(),Pattern.CASE_INSENSITIVE);
        Matcher commentMatcher = commentRegex.matcher(parameter);
        commentMatcher.find();
        String s = parameter.substring(commentMatcher.start(), commentMatcher.end());
        log.info(s);
        String[] split = s.split("[= ;]+");
        log.info(Arrays.toString(split));
    }
}
