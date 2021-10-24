package com.uio.java_tools.util;

import com.uio.java_tools.utils.CreateFileUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @author han xun
 * Date 2021/7/2 00:15
 * Description:
 */
@SpringBootTest
public class CreateFileUtilTest {

    @Test
    public void testFile() throws IOException {
        CreateFileUtil createFileUtil = new CreateFileUtil();
        String folder = createFileUtil.createFolder("C://java");
        createFileUtil.createFile(folder,"Student.java","public class Student {\n" +
                "\n" +
                "    private String name;\n" +
                "}\n");
        return;
    }
}
