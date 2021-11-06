/*
package com.uio.java_tools.service.impl;

import com.uio.java_tools.dto.AnalysisDTO;
import com.uio.java_tools.dto.Parameter;
import com.uio.java_tools.common.BackEnum;
import com.uio.java_tools.common.CustomException;
import com.uio.java_tools.manager.ParseStrManager;
import com.uio.java_tools.service.TokenizerService;
import com.uio.java_tools.utils.RegexPrecompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

*/
/**
 * @author uio
 * Date 2021/2/23 03:23
 * Description: 分词器
 *//*

@Service
public class TokenizerServiceImpl {

    @Autowired
    private ParseStrManager parseStrManager;

    public List<String> extractFieldFromJavaCode(String code) {
        // 根据 空格，\n,\r来进行分割
        String[] words = splitCode(code);

        // 用于存放返回结果，该数据包含 类型+字段名 ex：String name
        List<String> result = new ArrayList<>();

        int hierarchy = 0; // 层级，用来判断是否为类变量，当层级大于等于2时，不加入到result内
        int flag = 0; // flag为0表示寻找类型关键词,flag为1表示寻找字段名，flag为2表示判断是否符合类型 + 变量名的格式
        StringBuilder field = null;
        for (int i = 0; i < words.length; i++) {

            // 层级判断和处理
            if (words[i].equals("{")) {
                hierarchy++;
            } else if (words[i].equals("}")) {
                hierarchy--;
            } else if (hierarchy >= 2) {
                // 层级大于等于2，不处理内容
                continue;
            }

            if (flag == 0 && parseStrManager.verifyWord(words[i])) {
                // 找到变量类型关键词
                field = new StringBuilder();
                field.append(words[i]);
                field.append(" ");
                flag++;
            } else if (flag == 1) {
                field.append(words[i]); // 加入变量名
                if (words[i].contains(";")) {
                    // todo 重新考虑 = 的情况
                    // 如果没有;则表明不合法或为注释，则忽略
                    result.add(field.toString().replace(";", ""));  //如果包含";"则去除
                }
                flag = 0;
            }
            */
/*
            else if(flag == 2 && (words[i - 1].contains(";") || words[i].equals("="))) {
                flag = 0;
                result.add(field.toString().replace(";", ""));  //如果包含";"则去除
            }
            // 原解决方案，但会忽略掉最后一组数据，待修改
             *//*

        }
        return result;
    }



    public String getClassName(String code) {
        // todo 方法待改进
        String[] words = splitCode(code);
        for (int i = 0; i < words.length; i++) {
            if ("public".equals(words[i])) {
                if (i + 2 < words.length) {
                    return words[i + 2];
                }
            }
        }
        return "";
    }









}
*/
