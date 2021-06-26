package com.uio.java_tools.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author han xun
 * Date 2021/6/27 01:19
 * Description:
 */
public class Utils {

    public static String readTestString(String filePath) {
        try {
            File file = new File(filePath);
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
