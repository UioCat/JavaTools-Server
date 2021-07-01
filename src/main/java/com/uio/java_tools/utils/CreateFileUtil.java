package com.uio.java_tools.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Alfred
 * @Description: 自动创建文件
 * @time 2021/7/1 17:45
 */
public class CreateFileUtil {

    //创建文件夹
    public String createFolder(String filePath) {
        File dir = new File(filePath);
        // 一、检查放置文件的文件夹路径是否存在，不存在则创建
        boolean flag = false;
        if (!dir.exists()){
            flag = dir.mkdirs();// mkdirs创建多级目录
        }
        //返回当前目录
        return dir.getAbsolutePath();
    }

    //创建文件
    public void createFile(String filePath, String fileName, String content) throws IOException{
        File checkFile = new File(filePath + "/" + fileName);
        FileWriter writer = null;
        try {
            // 二、检查目标文件是否存在，不存在则创建
            if (!checkFile.exists()) {
                checkFile.createNewFile();// 创建目标文件
            }
            // 三、向目标文件中写入内容
            // FileWriter(File file, boolean append)，append为true时为追加模式，false或缺省则为覆盖模式
            writer = new FileWriter(checkFile, true);
            writer.append(content);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer)
                writer.close();
        }
    }
}
