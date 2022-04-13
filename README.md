# JavaTools
自制的Java自动生成简单增删改查代码小工具

本仓库仅包含服务端代码
客户端代码链接
curl'https://github.com/UioCat/JavaTools-Web'


## 1.0.0

#### 功能：
1. 解析SQL创表文件，并附有对应的生成代码接口
2. 解析Java类文件，并附有对应的生成代码接口 
   1. 解析Java数据类型、SQL数据类型、小驼峰字段名、下划线命名法字段名 
   2. 解析生成表名、主键 
   3. 解析注解
   4. 解析默认值
3. 可生成SQL创表文件
   1. 支持主键生成
   2. 支持唯一键选择
   3. 支持comment注释
   4. 支持默认值或NULL加入
4. 可生成Mybatis XML代码
下版本后期优化点
5. 根据输入值来生产SQL CRUD
6. Mybatis整合jar包导入使用
7. 集合javaDemo实现项目级生成
## 接口文档
https://www.yuque.com/hanxun-ekb3e/qsrlfu/xw3rga