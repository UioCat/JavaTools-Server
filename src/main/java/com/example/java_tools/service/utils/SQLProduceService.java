package com.example.java_tools.service.utils;


import com.example.java_tools.enums.BackEnum;
import com.example.java_tools.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建SQL各种命令
 */
@Service
public class SQLProduceService {

    @Autowired
    ParseStrUtils utils;

    /**
     * 输入参数类型list，参数名list，返回sql创建命令
     * @param parameterType 参数类型List 已转换成数据库的类型
     * @param parameterName 参数名List 已转换成数据库变量名格式
     * @param tbName 建表名称
     * @return 创表命令
     */
    public String composeSqlCommand(List<String> parameterType, List<String> parameterName,
                                    String tbName){

        StringBuilder stringBuilder = new StringBuilder();
        //判断数据是否错误
        if(parameterName.size() != parameterType.size()){
            throw new CustomException(BackEnum.ERROR);
        }

        stringBuilder.append("CREATE TABLE ");
        stringBuilder.append(tbName);
        stringBuilder.append("( ");

        for(int i = 0; i < parameterType.size(); i++){
            stringBuilder.append(parameterName.get(i));
            stringBuilder.append(" ");
            stringBuilder.append(parameterType.get(i));

            if(i != parameterType.size() - 1){
                stringBuilder.append(",");
            }else {
                stringBuilder.append(");");
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 输入参数类型，参数名list，返回sql更新表
     * @param keyParameterType 参数类型 没有转换成数据库类型
     * @param keyParameterName 参数名称 没转换成数据库变量名格式
     * @param parameterType where判断的参数类型 没有转换成数据库类型
     * @param parameterName where判断的参数名 没转换成数据库变量名格式
     * @param tbName 表名
     * @return 更新表sql命令
     */
    public String composeSqlUpdate(List<String> keyParameterType, List<String> keyParameterName,
                                   List<String> parameterType, List<String> parameterName,
                                   String tbName){

        StringBuilder stringBuilder = new StringBuilder();
        //判断数据是否错误
        if(parameterName.size() != parameterType.size() || keyParameterName.size() != keyParameterType.size()){
            throw new CustomException(BackEnum.ERROR);
        }


        stringBuilder.append("UPDATE ");
        stringBuilder.append(tbName);
        stringBuilder.append(" SET ");

        for(int i = 0; i < parameterType.size(); i++){

            stringBuilder.append(utils.upperToLower(parameterName.get(i)));
            stringBuilder.append("=");

            if(parameterType.get(i).equals("String") ){
                stringBuilder.append("'");
                stringBuilder.append(parameterName.get(i));
                stringBuilder.append("'");
            }else {
                stringBuilder.append(parameterName.get(i));
            }

            if((parameterType.size() -1 == i) || (parameterType.size() == 1)) {
                //当 parameterType size == 1 或 i == size-1
                stringBuilder.append(" ");
            }else {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("WHERE ");

        for (int i = 0; i < keyParameterType.size(); i++){

            stringBuilder.append(keyParameterName.get(i));
            stringBuilder.append("=");
            if(keyParameterType.get(i).equals("String") ){
                stringBuilder.append("'");
                stringBuilder.append(keyParameterName.get(i));
                stringBuilder.append("'");
            }else {
                stringBuilder.append(parameterName.get(i));
            }
        }
        stringBuilder.append(";");
        return stringBuilder.toString();
    }

    /**
     * 输入参数类型 参数名List ，返回SQL 插入数据命令
     * @param parameterType 参数类型，没有转换的
     * @param parameterName 参数名，没有转换的
     * @param tbName 表名
     * @return 插入数据命令
     */
    public String composeSQLInsert(List<String> parameterType, List<String> parameterName,
                                   String tbName){

        StringBuilder stringBuilder = new StringBuilder();
        //判断数据是否错误
        if(parameterName.size() != parameterType.size()){
            throw new CustomException(BackEnum.ERROR);
        }

        stringBuilder.append("INSERT INTO ");
        stringBuilder.append(tbName);
        stringBuilder.append(" (");

        for(int i = 0; i < parameterType.size(); i++){

            stringBuilder.append(utils.upperToLower(parameterName.get(i)));
            if(parameterType.size() -1 == i || parameterName.size() ==1 ){
                stringBuilder.append(")");
            }else {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" values (");

        for(int i = 0; i < parameterType.size(); i++){

            if(parameterType.get(i).equals("String")) {
                stringBuilder.append("'");
                stringBuilder.append(parameterName.get(i));
                stringBuilder.append("'");
            }else {
                stringBuilder.append(parameterName.get(i));
            }

            if(parameterType.size() -1 == i || parameterName.size() ==1 ){
                stringBuilder.append(");");
            }else {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 输入参数类型 参数名List 返回SQL，删除信息命令
     * @param keyParameterType 参数类型，没有转换
     * @param keyParameterName 参数名 没有转换
     * @param tbName 表名
     * @return 删除信息命令
     */
    public String composeSQLDelete(List<String> keyParameterType, List<String> keyParameterName,
                                   String tbName){

        StringBuilder stringBuilder = new StringBuilder();

        if(keyParameterType.size() != keyParameterName.size()){
            throw new CustomException(BackEnum.ERROR);
        }

        //DELETE FROM tb_config where port='802' AND equipment2='#2-设备';
        stringBuilder.append("DELETE FROM ");
        stringBuilder.append(tbName);
        stringBuilder.append(" WHERE ");

        for(int i = 0; i < keyParameterType.size(); i++){

            stringBuilder.append(utils.upperToLower(keyParameterName.get(i)));
            stringBuilder.append("=");

            if(keyParameterType.get(i).equals("String")){
                stringBuilder.append("'");
                stringBuilder.append(keyParameterName.get(i));
                stringBuilder.append("'");
            }else {
                stringBuilder.append(keyParameterName.get(i));
            }

            if(keyParameterType.size() == 1
                    || keyParameterType.size() -1 ==i){
                stringBuilder.append(";");
            }else {
                stringBuilder.append(" AND ");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 查询数据库信息命令生成
     * @param parameterName 带查询的参数名
     * @param keyParameterType where判断的参数类型
     * @param keyParameterName where判断的参数名
     * @param tbName 表明
     * @return 查询数据库命令
     */
    public String composeSQLSelect(List<String> parameterName,
                                   List<String> keyParameterType, List<String> keyParameterName,
                                   String tbName){

        StringBuilder stringBuilder = new StringBuilder();

        if(keyParameterType.size() != keyParameterName.size()){
            throw new CustomException(BackEnum.ERROR);
        }

        stringBuilder.append("SELECT ");

        for (int i = 0; i < parameterName.size(); i++){

            stringBuilder.append(utils.upperToLower(parameterName.get(i)));
            if(parameterName.size() == 1 || parameterName.size() -1 == i){
                stringBuilder.append(" ");
            }else {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("FROM ");
        stringBuilder.append(tbName);
        stringBuilder.append(" WHERE ");

        for(int i = 0; i < keyParameterType.size(); i++){

            stringBuilder.append(utils.upperToLower(keyParameterName.get(i)));
            stringBuilder.append("=");

            if(keyParameterType.get(i).equals("String")){
                stringBuilder.append("'");
                stringBuilder.append(keyParameterName.get(i));
                stringBuilder.append("'");
            }else {
                stringBuilder.append(keyParameterName.get(i));
            }

            if(keyParameterType.size() == 1 || keyParameterType.size() -1 ==i){
                stringBuilder.append(";");
            }else {
                stringBuilder.append(" AND ");
            }
        }
        return stringBuilder.toString();
    }


}
