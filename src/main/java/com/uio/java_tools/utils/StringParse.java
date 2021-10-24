package com.uio.java_tools.utils;

import java.util.ArrayList;
import java.util.List;

public class StringParse {

    //讲初始输入字符串转化成 包含type，name两个数组的 List
    public List<String[]> parseStr(String str){

        String[] lineArray = str.split(";\n|;");//去掉 \n; 以及 ;
        String line;

        String array[];
        String[] typeArray = new String[lineArray.length];
        String[] nameArray = new String[lineArray.length];
        for(int i=0; i<lineArray.length; i++) {
            line = deleteHeadSpace(lineArray[i]); //去掉最前的空格
            array = line.split(" ");//根据空格分开word
            typeArray[i] = array[array.length - 2];//将倒数第二个word放入类型数组
            nameArray[i] = array[array.length - 1];//将最后一个word放入变量名数组
        }
        List<String[]> wordArrayList= new ArrayList<String[]>();
        wordArrayList.add(typeArray);
        wordArrayList.add(nameArray);//将类型数组和变量名数组加入到List中，并返回

        return wordArrayList;
    }

    //删除头部的空格
    private String deleteHeadSpace(String str){

        StringBuilder stringBuilder = new StringBuilder();
        Boolean flag = false;
        for (char ch:str.toCharArray()) {
            if(ch != 32){
                flag = true;
            }
            if(flag){
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }


}