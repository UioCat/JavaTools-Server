package com.example.java_tools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.java_tools.mapper")
@SpringBootApplication
public class JavaToolsApplication{

    public static void main(String[] args) {
        SpringApplication.run(JavaToolsApplication.class, args);
    }
}
