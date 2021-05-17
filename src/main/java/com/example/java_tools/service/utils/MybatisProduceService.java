package com.example.java_tools.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MybatisProduceService {

    @Autowired
    ParseStrUtils utils;

    /**
     * 生成mybatis基础的框架数据
     * @param namespace com.xx.xx.xx.xxDao
     * @return
     */
    public String mybatisBasics(String namespace){
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<!DOCTYPE mapper\n" +
                "        PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\n" +
                "        \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n" +
                "\n" +
                "<mapper namespace=\"");
        stringBuffer.append(namespace);
        stringBuffer.append("\">\n");
        stringBuffer.append("\n");
        stringBuffer.append("</mapper>");
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    /**
     * 生成mybatis插入数据配置
     * @param parameterName
     * @param tbName
     * @return String
     */
    public String mybatisInsert(List<String> parameterName,String tbName){

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<insert id=\"insertMsg\">\n");
        stringBuffer.append("\tINSERT INTO ");
        stringBuffer.append(tbName);
        stringBuffer.append(" (");

        for(int i = 0; i < parameterName.size(); i++){
            stringBuffer.append(utils.upperToLower(parameterName.get(i)));
            if(parameterName.size() -1 == i || parameterName.size() ==1 ){
                stringBuffer.append(")");
            }else {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("\n\tVALUES (");
        for(int i = 0; i < parameterName.size(); i++){
            stringBuffer.append("#{");
            stringBuffer.append(parameterName.get(i));
            stringBuffer.append("}");
            if(parameterName.size() -1 == i || parameterName.size() ==1 ){
                stringBuffer.append(")");
            }else {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("\n</insert>\n");
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    /**
     * 生成mybatis更新数据配置
     * @param keyParameterName
     * @param parameterName
     * @param tbName
     * @return String
     */
    public String mybatisUpdate(List<String> keyParameterName,List<String> parameterName,String tbName){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<update id=\"updateMsg\">\n" +
                "\tUPDATE ");
        stringBuilder.append(tbName);
        stringBuilder.append("\n\t");
        stringBuilder.append("<set>\n\t\t");
        for(int i = 0; i < parameterName.size(); i++) {
            stringBuilder.append("<if test=\"");
            stringBuilder.append(parameterName.get(i));
            stringBuilder.append("!=null\">");
            stringBuilder.append(utils.upperToLower(parameterName.get(i)));
            stringBuilder.append("=#{");
            stringBuilder.append(parameterName.get(i));
            stringBuilder.append("}");
            if(parameterName.size() - 1 == i || parameterName.size() == 1){
                stringBuilder.append("</if>\n\t");
            }else {
                stringBuilder.append(",</if>\n\t");
            }
        }
        stringBuilder.append("</set>\n");

        for(int i = 0; i < keyParameterName.size(); i++){
            if(i == 0) {
                stringBuilder.append("\tWHERE ");
            }else {
                stringBuilder.append("\tAND ");
            }
            stringBuilder.append(utils.upperToLower(keyParameterName.get(i)));
            stringBuilder.append("=#{");
            stringBuilder.append(keyParameterName.get(i));
            stringBuilder.append("}\n");
        }
        stringBuilder.append("</update>");
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    /**
     * 生成mybatis删除数据配置
     * @param keyParameterName
     * @param tbName
     * @return String
     */
    public String mybatisDelete(List<String> keyParameterName,String tbName){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<delete id=\"deleteMsg\">\n\t");
        stringBuilder.append("DELETE FROM ");
        stringBuilder.append(tbName);
        stringBuilder.append("\n");
        for(int i = 0; i < keyParameterName.size(); i++) {
            if(i == 0){
                stringBuilder.append("\tWHERE ");
            }else {
                stringBuilder.append("\tAND ");
            }
            stringBuilder.append(utils.upperToLower(keyParameterName.get(i)));
            stringBuilder.append("=#{");
            stringBuilder.append(keyParameterName.get(i));
            stringBuilder.append("}\n");
        }
        stringBuilder.append("</delete>");
        System.out.println(stringBuilder.toString());

        return stringBuilder.toString();
    }

    public String mybatisSelect(List<String> keyParameterName,List<String> parameterName,String tbName){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<select id=\"queryMsg\">\n\t");
        stringBuilder.append("SELECT ");

        for(int i = 0; i < parameterName.size(); i++){
            if(parameterName.size() - 1 == i || parameterName.size() == 1){
                stringBuilder.append(utils.upperToLower(parameterName.get(i)));
            }else {
                stringBuilder.append(utils.upperToLower(parameterName.get(i)));
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("\n\tFROM ");
        stringBuilder.append(tbName);
        stringBuilder.append("\n");

        for(int i = 0; i < keyParameterName.size(); i++){
            if(i == 0) {
                stringBuilder.append("\tWHERE ");
            }else {
                stringBuilder.append("\tAND ");
            }
            stringBuilder.append(utils.upperToLower(keyParameterName.get(i)));
            stringBuilder.append("=#{");
            stringBuilder.append(keyParameterName.get(i));
            stringBuilder.append("}\n");
        }
        stringBuilder.append("</select>");
        System.out.println(stringBuilder.toString());

        return stringBuilder.toString();
    }

}
