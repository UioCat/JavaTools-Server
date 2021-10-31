package com.uio.java_tools.service.impl;

import com.uio.java_tools.dto.EntityParameterDTO;
import com.uio.java_tools.dto.Parameter;
import com.uio.java_tools.common.BackEnum;
import com.uio.java_tools.enums.RegexEnum;
import com.uio.java_tools.common.CustomException;
import com.uio.java_tools.manager.ParseStrManager;
import com.uio.java_tools.service.TokenizerService;
import com.uio.java_tools.utils.RegexPrecompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author uio
 * Date 2021/2/23 03:23
 * Description: 分词器
 */
@Service
public class TokenizerServiceImpl implements TokenizerService {

    @Autowired
    private ParseStrManager parseStrManager;

    @Override
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
            /*
            else if(flag == 2 && (words[i - 1].contains(";") || words[i].equals("="))) {
                flag = 0;
                result.add(field.toString().replace(";", ""));  //如果包含";"则去除
            }
            // 原解决方案，但会忽略掉最后一组数据，待修改
             */
        }
        return result;
    }

    @Override
    public String getPackageName(String code) {
        // todo 暂时使用改方案，等整体稳定后，何如extractFieldFromJavaCode方法内
        String[] words = splitCode(code);
        if (words.length >= 2) {
            if (words[0].equals("package")) {
                StringBuilder stringBuilder = new StringBuilder();
                String allPackageName = words[1];
                String[] hierarchy = allPackageName.split("\\.");

                stringBuilder.append(hierarchy[0]);

                for (int i = 1; i < hierarchy.length; i++) {
                    if (i == hierarchy.length - 1) {
                        break;
                    } else {
                        stringBuilder.append(".");
                        stringBuilder.append(hierarchy[i]);
                    }
                }
                return stringBuilder.toString();
            }
        }
        return "";
    }

    @Override
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


    private String[] splitCode(String code) {
        return code.split("[ \\n\\r]");
    }

    @Override
    public EntityParameterDTO parseJavaEntityCode(String code) {
        EntityParameterDTO result = new EntityParameterDTO();
        // 1. 解析字段类型、名称、备注，采用正则进行循环
        List<Parameter> parameters = getParameters(code);
        result.setParameters(parameters);
        // 2. 解析id主键
        String primaryKey = getPrimaryKey(parameters);
        result.setPrimaryKey(primaryKey);
        // 3. 解析表名
        String className = getClassName(code);
        result.setTableName(className);

        return result;
    }

    private String getPrimaryKey(List<Parameter> parameters) {
        String result = null;
        String regex = "\\w*id\\w*";
        for (Parameter parameter: parameters) {
            if (Pattern.matches(regex, parameter.getField())) {
                result = parameter.getField();
            }
        }
        return result;
    }

    private List<Parameter> getParameters(String code) {
        List<Parameter> result = new ArrayList<>();
        //去除所有的换行
        String codeInOneLine = code.replaceAll("\\r\\n", " ");
        // 预处理，提取出字段所在位置
        Matcher methodMatcher = RegexPrecompile.METHOD_PATTERN.matcher(codeInOneLine);
        int start = 0;
        int end = codeInOneLine.length();
        if (codeInOneLine.contains("class ")) {
            start = codeInOneLine.indexOf("class ");
        }
        if (methodMatcher.find()) {
            end = methodMatcher.start();
        }
        String entity = codeInOneLine.substring(start, end);
        Matcher paramMatcher = RegexPrecompile.PARAM_REGEX.matcher(entity);

        List<String> parameters = new ArrayList<>();
        while (paramMatcher.find()) {
            String parameter = entity.substring(paramMatcher.start(), paramMatcher.end());
            if (parameter.contains("static") || parameter.contains("final")) {
                continue;
            }
            parameters.add(parameter);
        }

        for (String parameter: parameters) {
            Parameter param = new Parameter();

            // 解析参数类型和参数名，并以此分割comment
            Matcher typeAndFieldMatcher = RegexPrecompile.TYPE_AND_FILED_REGEX.matcher(parameter);
            if (typeAndFieldMatcher.find()) {
                start = typeAndFieldMatcher.start();
                end = typeAndFieldMatcher.end();
                // 获取comment并存储
                String comment = parameter.substring(0, start);
                String s = comment.replaceAll("[\\*/ ]", "");
                if (!s.isEmpty()) {
                    param.setComment(s);
                }
                String attribute = parameter.substring(start, end);
                String typeAndField = attribute.replaceAll("private|protected|public", "").trim();
                String[] strings = typeAndField.split("[ =;]+");
                if (strings.length == 2) {
                    param.setType(strings[0]);
                    param.setDatatype(parseStrManager.typeConvertForMysql(strings[0]));
                    param.setField(strings[1]);
                } else if (strings.length == 3) {
                    param.setType(strings[0]);
                    param.setDatatype(parseStrManager.typeConvertForMysql(strings[0]));
                    param.setField(strings[1]);
                    param.setDefaultValue(strings[2]);
                } else {
                    throw new CustomException(BackEnum.PARAM_ERROR);
                }

            } else {
                throw new CustomException(BackEnum.PARAM_ERROR);
            }
            result.add(param);
        }

        return result;
    }
}
