package com.uio.java_tools.manager.impl;

import com.uio.java_tools.constant.GlobalMap;
import com.uio.java_tools.manager.ParseStrManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * 解析字符串的工具类
 */
@Service
@Slf4j
public class ParseStrManagerImpl implements ParseStrManager {

    private final static String TABLE_PREFIX = "tb_";

    @Override
    public boolean verifyWord(String word) {
        Map<String, String> sqlTypeMap = GlobalMap.initSqlTypeMap;
        return sqlTypeMap.get(word) != null;
    }

    @Override
    public String classNameToTableName(String className) {
        // 如果有DO则去除
        className = className.replace("DO", "");
        return TABLE_PREFIX + this.upperToLower(className);
    }

    @Override
    public String upperToLower(String str) {

        char[] ch = str.toCharArray();//A-Z 65-90,a-z 97-122
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {//大写字母
                ch[i] = (char)(ch[i] + 32);
                if (i == 0) {
                    stringBuilder.append(ch[i]);
                } else {
                    stringBuilder.append("_").append(ch[i]);
                }
            } else {
                stringBuilder.append(ch[i]);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String typeConvertForMysql(String type) {
        Map<String, String> sqlTypeMap = GlobalMap.initSqlTypeMap;
        String sqlType = sqlTypeMap.get(type);
        return StringUtils.isNotBlank(sqlType) ? sqlType : type;
    }
}
