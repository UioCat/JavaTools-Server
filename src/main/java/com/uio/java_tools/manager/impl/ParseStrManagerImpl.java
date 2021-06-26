package com.uio.java_tools.manager.impl;

import com.uio.java_tools.enums.TypeEnum;
import com.uio.java_tools.manager.ParseStrManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 解析字符串的工具类
 */
@Service
public class ParseStrManagerImpl implements ParseStrManager {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean verifyWord(String word) {
        TypeEnum[] typeEnums = TypeEnum.values();
        for(TypeEnum type : typeEnums) {
            if(word.equals(type.getType())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String upperToLower(String str){

        char[] ch = str.toCharArray();//A-Z 65-90,a-z 97-122
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0;i < ch.length; i++){
            if(ch[i] >= 'A' && ch[i] <= 'Z'){//大写字母
                ch[i] = (char) (ch[i]+32);
                if(i == 0){
                    stringBuilder.append(ch[i]);
                }else {
                    stringBuilder.append("_").append(ch[i]);
                }
            }else {
                stringBuilder.append(ch[i]);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String typeConvertForMysql(String type) {
        TypeEnum[] typeEnums = TypeEnum.values();
        for (TypeEnum typeEnum : typeEnums) {
            if(type.equals(typeEnum.getType())) {
                return typeEnum.getConvertSql();
            }
        }
        return type;
    }
}
