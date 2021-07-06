package com.uio.java_tools.service.impl;

import com.alibaba.fastjson.JSON;
import com.uio.java_tools.config.MapConfig;
import com.uio.java_tools.constant.GlobalMap;
import com.uio.java_tools.dto.ParseParameterDTO;
import com.uio.java_tools.service.GeneratorService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author han xun
 * Date 2021/6/26 16:30
 * Description: 根据SQL生成文件
 */
@Service
public class GeneratorBySQLServiceImpl implements GeneratorService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MapConfig mapConfig;



    @Override
    public ParseParameterDTO parse(String inputString) {
        ParseParameterDTO parseParameterDTO = new ParseParameterDTO();
        Map<String, String> javaTypeMap = GlobalMap.initJavaTypeMap();
        //获取sql类型对应的java类型
        int start = inputString.indexOf("(");
        int end = inputString.lastIndexOf(")");
        //解析表名，类名
        String head = inputString.substring(0, start);
        String[] heads = StringUtils.split(head.trim(), " ");
        parseParameterDTO.setTableName(heads[2]);
        parseParameterDTO.setClassName(parsingClassName(heads[2]));

        //表内容
        String content = inputString.substring(start + 1, end);
        //分割sql字段
        String[] sqlFields = StringUtils.split(content, ",");
        //获取字段名，并将sql类型转化为java类型
        List<String> fieldList = new ArrayList<>();
        for (String item : sqlFields){
            String[] words = StringUtils.split(item.trim(), " ");
            //字段包含长度
            String sqlType = "";
            if (words[1].contains("(")){
                sqlType = words[1].substring(0,words[1].indexOf("(")).toUpperCase();
            }else {
                sqlType = words[1].toUpperCase();
            }
            String javaType = javaTypeMap.get(sqlType);
            String field = words[0].toLowerCase();
            fieldList.add(javaType + " " + field);
        }
        parseParameterDTO.setFieldList(fieldList);
        return parseParameterDTO;
    }

    /**
     * 获取sql字段对应的java字段map
     * @return
     */
    public Map<String, String> mapDataInit(){
        Map<String, String> javaBeanTypeMap = mapConfig.getJavaBeanTypeMap();
        if (javaBeanTypeMap == null || javaBeanTypeMap.size() <= 0) {
            logger.warn("javaBeanTypeMap读取失败");
        }
        logger.info("javaBeanTypeMap读取成功，数据如下：{}", JSON.toJSONString(javaBeanTypeMap));
        return javaBeanTypeMap;
    }

    /**
     * 将表名转化为类名
     * @param tableName
     * @return
     */
    public String parsingClassName(String tableName){
        //解析类名
        String[] s = StringUtils.split(tableName, "_");
        StringBuilder className = new StringBuilder();
        for (int i = 1; i < s.length; i++){
            className.append(s[i].substring(0, 1).toUpperCase()).append(s[i].substring(1));
        }
        return className.toString();
    }

}
