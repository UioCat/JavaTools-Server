package com.uio.java_tools.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置类
 * 从配置文件中读取数据映射到map
 * 注意：必须实现set方法
 */
@Configuration
@ConfigurationProperties(prefix = "map")
@EnableConfigurationProperties(MapConfig.class)
public class MapConfig {

    /**
     * 从配置文件中读取的limitSizeMap开头的数据
     * 注意：名称必须与配置文件中保持一致
     */
    private Map<String, String> javaBeanTypeMap = new HashMap<>();

    public Map<String, String> getJavaBeanTypeMap() {
        return javaBeanTypeMap;
    }

    public void setJavaBeanTypeMap(Map<String, String> javaBeanTypeMap) {
        this.javaBeanTypeMap = javaBeanTypeMap;
    }
}
