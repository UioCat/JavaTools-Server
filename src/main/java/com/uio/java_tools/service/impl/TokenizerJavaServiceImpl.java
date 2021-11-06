package com.uio.java_tools.service.impl;

import com.uio.java_tools.common.BackEnum;
import com.uio.java_tools.common.CustomException;
import com.uio.java_tools.dto.AnalysisDTO;
import com.uio.java_tools.dto.Parameter;
import com.uio.java_tools.manager.ParseStrManager;
import com.uio.java_tools.service.TokenizerService;
import com.uio.java_tools.utils.RegexPrecompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author han xun
 * Date 2021/11/6 13:39
 * Description:
 */
@Service("tokenizer_java")
public class TokenizerJavaServiceImpl implements TokenizerService {

    @Autowired
    private ParseStrManager parseStrManager;

    /**
     * 解析Java文本
     * @param text Java实体类文本（可不全）
     * @return
     */
    @Override
    public AnalysisDTO analysisText(String text) {
        AnalysisDTO result = new AnalysisDTO();
        // 1. 解析字段类型、名称、备注，采用正则进行循环
        List<Parameter> parameters = this.getParameters(text);
        result.setParameters(parameters);
        // 2. 解析id主键
        String primaryKey = getPrimaryKey(parameters);
        result.setPrimaryKey(primaryKey);
        // 3. 解析表名
        String className = getClassName(text);
        result.setTableName(className);
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

    private String[] splitCode(String code) {
        return code.split("[ \\n\\r]");
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
}
