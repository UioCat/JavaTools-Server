package com.example.java_tools.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 解析字符串的工具类
 */
@Service
public class ParseStrUtils {

    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 将含有大写字母的变量名 aB 改成 a_b
     * @param str 字符aB
     * @return a_b
     */
    public String upperToLower(String str){

        char[] ch = str.toCharArray();//A-Z 65-90,a-z 97-122
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0;i < ch.length; i++){
            if(ch[i] >= 'A' && ch[i] <= 'Z'){//大写字母
                ch[i] = (char) (ch[i]+32);
                if(i == 0){
                    stringBuilder.append(ch[i]);
                }else {
                    stringBuilder.append("_" + ch[i]);
                }
            }else {
                stringBuilder.append(ch[i]);
            }
        }
        return stringBuilder.toString();
    }


    /**
     * type转换为数据库建表需要的字符
     * @param type （Integer）
     * @return type int(32)
     */
    public String typeConvertForMysql(String type){

        switch (type){
            case "Integer":{
                type = "int(32)";
                break;
            }
            case "String":{
                type = "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL";
                break;
            }
            case "Boolean":{
                type = "bit(1) NOT NULL DEFAULT b'0'";
                break;
            }
            case "Double":{
                type = "double DEFAULT NULL";
                break;
            }
            case "Float":{
                type = "float DEFAULT NULL";
                break;
            }
            // todo 加上int,Date,BigDecimal
        }
        return type;
    }


    /**
     * 输入字符串 返回 字符串中的参数
     * @param data java entity类
     * @return List<String> Integer id
     */
    // TODO: 2020/7/4 用多线程进行优化
    public Collection<String> parseParameter(String data) {

        Collection<String> collection = new LinkedHashSet<>();

        char[] array = data.toCharArray();
        StringBuffer stringBuffer;
        int index = 0;
        Boolean judge = true;

        for (int i = 0; i < array.length; i++){
            switch (array[i]){
                case 'I':{  //Integer

                    if(array[i + 1] == 'n' && array[i + 2] == 't'
                    && array[i + 3] == 'e' && array[i + 4] == 'g'
                    && array[i + 5] == 'e' && array[i + 6] =='r'
                    && array[i + 7] == ' '){
                        stringBuffer = new StringBuffer();
                        stringBuffer.append("Integer ");
                        index = 0;
                        while(array[i + index + 8] != ';'){
                            if(illegalityJudge(array[i + index + 8])){
                                stringBuffer.append(array[i + index + 8]);
                                index ++;
                            }else {
                                judge = false;
                                break;
                            }
                        }
                        if(judge) {
                            i = i + index + 8;

                            collection.add(stringBuffer.toString());
                        }else {
                            judge = true;
                        }
                    }
                    break;
                }
                case 'S':{//String

                    if(array[i + 1] == 't' && array[i + 2] == 'r'
                            && array[i + 3] == 'i' && array[i + 4] == 'n'
                            && array[i + 5] == 'g' && array[i + 6] == ' '){
                        stringBuffer = new StringBuffer();
                        stringBuffer.append("String ");
                        index = 0;
                        while(array[i + index + 7] != ';'){
                            if(illegalityJudge(array[i + index + 7])){
                                stringBuffer.append(array[i + index + 7]);
                                index ++;
                            }else {
                                judge = false;
                                break;
                            }
                        }
                        if(judge) {
                            i = i + index + 7;
                            collection.add(stringBuffer.toString());
                        }else {
                            judge = true;
                        }
                    }
                    break;
                }
                case 'B':{//Boolean,BigDecimal
                    if(array[i + 1] == 'o' && array[i + 2] == 'o'
                    && array[i + 3] == 'l' && array[i + 4] == 'e'
                    && array[i + 5] == 'a' && array[i + 6] == 'n'
                    && array[i + 7] ==' '){
                        stringBuffer = new StringBuffer();
                        stringBuffer.append("Boolean ");
                        index = 0;
                        while(array[i + index + 8] != ';'){
                            if(illegalityJudge(array[i + index + 8])){
                                stringBuffer.append(array[i + index + 8]);
                                index ++;
                            }else {
                                judge = false;
                                break;
                            }
                        }
                        if(judge) {
                            i = i + index + 8;

                            collection.add(stringBuffer.toString());
                        } else {
                            judge = true;
                        }
                    } else if(array[i + 1] == 'i' && array[i + 2] == 'g'
                    && array[i + 3] == 'D' && array[i + 4] == 'e'
                    && array[i + 5] == 'c' && array[i + 6] == 'i'
                    && array[i + 7] == 'm' && array[i + 8] == 'a'
                    && array[i + 9] == 'l' && array[i + 10] == ' '){
                        stringBuffer = new StringBuffer();
                        stringBuffer.append("BigDecimal ");
                        index = 0;
                        while(array[i + index + 10] != ';') {
                            if(illegalityJudge(array[i + index + 10])) {
                                stringBuffer.append(array[i + index + 10]);
                                index ++;
                            } else {
                                judge = false;
                                break;
                            }
                        }
                        if(judge) {
                            i = i + index + 10;

                            collection.add(stringBuffer.toString());
                        } else {
                            judge = true;
                        }
                    }
                    break;
                }
                case 'F':{ //Float
                    if(array[i + 1] == 'l' && array[i + 2] == 'o'
                            && array[i + 3] == 'a' && array[i + 4] == 't'
                            && array[i + 5] ==' '){
                        stringBuffer = new StringBuffer();
                        stringBuffer.append("Float ");
                        index = 0;
                        while(array[i + index + 6] != ';') {
                            if(illegalityJudge(array[i + index + 6])){
                                stringBuffer.append(array[i + index + 6]);
                                index ++;
                            }else {
                                judge = false;
                                break;
                            }
                        }
                        if(judge) {
                            i = i + index + 6;
                            collection.add(stringBuffer.toString());
                        }else {
                            judge = true;
                        }
                    }
                    break;
                }
                case 'D':{ //Double,Date
                    if(array[i + 1] == 'o' && array[i + 2] == 'u'
                            && array[i + 3] == 'b' && array[i + 4] == 'l'
                            && array[i + 5] =='e' && array[i + 6] == ' '){
                        stringBuffer = new StringBuffer();
                        stringBuffer.append("Double ");
                        index = 0;
                        while(array[i + index + 7] != ';'){
                            if(illegalityJudge(array[i + index + 7])){
                                stringBuffer.append(array[i + index + 7]);
                                index ++;
                            }else {
                                judge = false;
                                break;
                            }
                        }
                        if(judge) {
                            i = i + index + 7;
                            collection.add(stringBuffer.toString());
                        }else {
                            judge = true;
                        }
                    } else if (array[i + 1] == 'a' && array[i + 2] == 't'
                            && array[i + 3] == 'e' && array[i + 4] == ' ') {
                        stringBuffer = new StringBuffer();
                        stringBuffer.append("Date ");
                        index = 0;
                        while(array[i + index + 5] != ';') {
                            if(illegalityJudge(array[i + index + 5])) {
                                stringBuffer.append(array[i + index + 5]);
                                index ++;
                            } else {
                                judge = false;
                                break;
                            }
                        }
                        if(judge) {
                            i = i + index + 5;
                            collection.add(stringBuffer.toString());
                        } else {
                            judge = true;
                        }
                    }
                    break;
                }
                case 'i': {
                    if(array[i + 1] == 'n' && array[i + 2] == 't'
                            && array[i + 3] == ' ') {
                        stringBuffer = new StringBuffer();
                        stringBuffer.append("int ");
                        index = 0;
                        while (array[i + index + 4] != ';') {
                            if (illegalityJudge(array[i + index + 4])) {
                                stringBuffer.append(array[i + index + 7]);
                                index++;
                            } else {
                                judge = false;
                                break;
                            }
                        }
                        if (judge) {
                            i = i + index + 4;
                            collection.add(stringBuffer.toString());
                        } else {
                            judge = true;
                        }
                    }
                }
            }
        }

        return collection;
    }

    public Boolean illegalityJudge(char ch){
        if(ch != '\n'
                && ch != '\r'
                && ch != '\t'
                && ch != ' '
                && ch != '('
                && ch != ')'
                && ch != '\\'){
            return true;
        }else {
            return false;
        }
    }

}
