package com.example.java_tools.service.utils;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.List;

/**
 * @author uio
 * Date 2021/4/20 下午9:18
 * Description:
 */
@Service
public class VelocityTemplateForSQL {

    /**
     * 使用velocity模版生成创建表的SQL语句
     * @param parameterType
     * @param parameterName
     * @param tbName
     * @return
     */
    // todo 模版使用static + 单例管理
    public String createSQLTemplate(List<String> parameterType, List<String> parameterName,
                                    String tbName) {
        // 初始化模板引擎
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        // 获取模板文件
        Template t = ve.getTemplate("velocity_template/insert_sql.vm");
        // 设置变量
        VelocityContext ctx = new VelocityContext();
        ctx.put("tbName", tbName);
        ctx.put("paramNameList", parameterName);
        ctx.put("paramTypeList", parameterType);

        StringWriter sw = new StringWriter();
        t.merge(ctx,sw);
        return sw.toString();
    }
}
