package com.example.java_tools.service.utils;

import com.example.java_tools.utils.IData;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.List;

/**
 * @author uio
 * Date 2021/4/20 下午9:18
 * Description: 使用Velocity模版生成SQL语句（创表、增、删、改、查）
 */
@Service
public class VelocityTemplateForSQL {

    @Autowired
    ParseStrUtils parseStrUtils;

    /**
     * 使用velocity模版生成创建表的SQL语句
     * @param parameterType 参数类型
     * @param parameterName 参数名
     * @param tbName 表名
     * @return
     */
    public String createSQLTemplate(List<String> parameterType, List<String> parameterName,
                                    String tbName) {
        // 获取模板文件
        Template template = getTemplate(IData.templateForCreateSQLFile);

        // 设置变量
        VelocityContext ctx = new VelocityContext();
        ctx.put("tbName", tbName);
        ctx.put("paramNameList", parameterName);
        ctx.put("paramTypeList", parameterType);

        StringWriter sw = new StringWriter();

        template.merge(ctx,sw);
        return sw.toString();
    }

    /**
     * 创建插入数据语句
     * @param parameterName 参数名
     * @param tbName 表名
     * @return 插入sql语句
     */
    public String insertSQLTemplate(List<String> parameterName, String tbName) {
        Template template = getTemplate(IData.templateForInsertSQLFile);
        // 设置变量
        VelocityContext ctx = new VelocityContext();

        ctx.put("tbName", tbName);
        ctx.put("paramNameList", parameterName);

        StringWriter sw = new StringWriter();
        template.merge(ctx,sw);
        return sw.toString();
    }


    /**
     * 初始化模版
     * @param templateFilePath 模版文件路径
     * @return 模版
     */
    private Template getTemplate(String templateFilePath) {
        // 初始化模板引擎
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();

        // 返回模板文件
        return ve.getTemplate(templateFilePath);
    }


}
