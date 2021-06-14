package com.example.java_tools.service.impl;

import com.example.java_tools.service.TokenizerService;
import com.example.java_tools.utils.IData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uio
 * Date 2021/2/23 03:23
 * Description: 分词器
 */
@Service
public class TokenizerServiceImpl implements TokenizerService {

    @Override
    public List<String> extractFieldFromJavaCode(String code) {
        List<String> result = null;
        result = parseJavaCode(code.split(" |\\n|\\r"));
        return result;
    }

    /**
     * 解析每一句话，提取出字段类型以及字段名
     * @param words 拆分单词
     * @return 字段类型 + 字段名 （ex：String name）
     */
    private List<String> parseJavaCode(String[] words) {

        List<String> result = new ArrayList<>();

        int hierarchy = 0; // 层级，用来判断是否为类变量，当层级大于等于2时，不加入到result内
        int flag = 0; // flag为0表示寻找类型关键词,flag为1表示寻找字段名，flag为2表示判断是否符合类型 + 变量名的格式
        StringBuilder field = null;
        for(int i = 0; i < words.length; i++) {

            // 层级判断和处理
            if(words[i].equals("{")) {
                hierarchy++;
            } else if(words[i].equals("}")) {
                hierarchy--;
            } else if(hierarchy >= 2) {
                // 层级大于等于2，不处理内容
                continue;
            }

            if(flag == 0 && verifyWord(words[i])) {
                // 找到变量类型关键词
                field = new StringBuilder();
                field.append(words[i]);
                field.append(" ");
                flag++;
            } else if(flag == 1) {
                field.append(words[i]); // 加入变量名
                flag++;
                if(words[i].contains(";") || words[i].equals("=")) {
                    result.add(field.toString().replace(";", ""));  //如果包含";"则去除
                }
                flag = 0;
            }
            /*
            else if(flag == 2 && (words[i - 1].contains(";") || words[i].equals("="))) {
                flag = 0;
                result.add(field.toString().replace(";", ""));  //如果包含";"则去除
            }
            // 原解决方案，但会忽略掉最后一组数据，顾修改
             */
        }

        return result;
    }

    /**
     * 验证字符是否为变量类型
     * @return 字段为变量类型返回true，否则返回false
     */
    private boolean verifyWord(String word) {
        for(String type : IData.scope) {
            if(word.equals(type)) {
                return true;
            }
        }
        return false;
    }
}
