# Uio-Tools 工具

version：**v1.2**

## 接口文档

- 测试用例：

    ```
    package com.example.java_tools;
    
    public class User {
    
            /**
             * 编码
             */
            private String foo = "123123";
            /*
               姓名
             */
            private String name;
            /**
             * 性别
             */
            private Integer sex;
            //城市
            private Boolean urban;
            // 余额
            private Double balance;
            private Float money;
    
        public User(String foo, String name, Integer sex, Boolean urban, Double balance, Float money) {
            this.foo = foo;
            this.name = name;
            this.sex = sex;
            this.urban = urban;
            this.balance = balance;
            this.money = money;
        }
    
        public String getName() {
        	return name;
        }
    
        public void setName(String name) {
    	    this.name = name;
        }
    }
    ```

### 基础 URL：`https://www.uiofield.top`

### 根路径：`/tools`

### 文本解析接口 parse

**v1.2 更新**
该接口为 MySQL 和 MyBatis 共用

- 路径：

    ```
    /tools/wordIdentify
    ```

- 发送：

    ```
    {
      "data": "package com.example.java_tools;
    
      public class User {
    
          private String foo = 123123;
          private String name;
          private Integer sex;
          private Boolean urban;
          private Double balance;
          private Float money;
    
          public User(String foo, String name, Integer sex, Boolean urban, Double balance, Float money) {
              this.foo = foo;
              this.name = name;
              this.sex = sex;
              this.urban = urban;
              this.balance = balance;
              this.money = money;
          }
    
          public String getName() {
              return name;
          }
    
          public void setName(String name) {
              this.name = name;
          }
      }"
    }
    ```

- 返回：

    ```json
    {
        "code": 200,
        "message": "请求成功",
        "info": {
            "parameters": [
                {
                    "type": "String",
                    "datatype": null,
                    "field": "foo",
                    "comment": "编码",
                    "defaultValue": "\"123123\"",
                    "unique": false
                },
                {
                    "type": "String",
                    "datatype": null,
                    "field": "name",
                    "comment": "姓名",
                    "defaultValue": null,
                    "unique": false
                },
                {
                    "type": "Integer",
                    "datatype": null,
                    "field": "sex",
                    "comment": "性别",
                    "defaultValue": null,
                    "unique": false
                },
                {
                    "type": "Boolean",
                    "datatype": null,
                    "field": "urban",
                    "comment": "城市",
                    "defaultValue": null,
                    "unique": false
                },
                {
                    "type": "Double",
                    "datatype": null,
                    "field": "balance",
                    "comment": "余额",
                    "defaultValue": null,
                    "unique": false
                },
                {
                    "type": "Float",
                    "datatype": null,
                    "field": "money",
                    "comment": null,
                    "defaultValue": null,
                    "unique": false
                }
            ],
            "tableName": "tb_User",
            "primaryKey": null,
            "namespace": null
        }
    }
    ```

### MySQL

#### 生成创表命令接口 create

**v1.2 更新**

- 路径：

    ```
    /tools/createSQL
    ```

- 发送：

    ```json
    {
        "parameters":[
            {
                "type": "Integer",
                "field": "id",
                "comment": "用户id",
                "defaultValue": "123123"
            },
            {
                "type": "String",
                "field": "username",
                "comment": "用户名",
                "unique": true
            },
            {
                "type": "String",
                "field": "password",
                "comment": "用户密码"
            },
            {
                "type": "String",
                "field": "level",
                "comment": "用户权限"
            },
            {
                "type": "String",
                "field": "uniqueName",
                "comment": "用户唯一名"
            }
        ],
        "primaryKey": "id",
        "tbName": "tb_config"
      }
    ```

- 返回：

    ```json
    {
        "code": 200,
        "message": "请求成功",
        "info": "CREATE TABLE ${tbName}(\r\n    `id` int(32) DEFAULT 123123 comment `用户id`,\r\n    `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT null comment `用户名` UNIQUE,\r\n    `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT null comment `用户密码`,\r\n    `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT null comment `用户权限`,\r\n    `unique_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT null comment `用户唯一名`    , PRIMARY KEY(`id`)\r\n);"
    }
    ```

#### 生成更新表命令接口 update

- 路径：

    ```
    /tools/updateTable
    
    ```

- 发送：

    ```
    {
      "parameter": ["String username", "String password", "String level"],
      "keyParameter": ["Integer id"],
      "tbName": "tb_config"
    }
    ```

- 返回：

    ```
    {
      "code": 12,
      "message": "请求成功",
      "info": "UPDATE tb_config SET username='username',password='password',level='level' WHERE id=username;"
    }
    ```

#### 生成插入表命令 insert

- 路径：

    ```
    /tools/insertMsg
    ```

- 发送：

    ```
    {
        "parameter": ["String username", "String password", "String level"],
        "tbName": "tb_config"
    }
    ```

- 返回：

    ```
    {
        "code": 12,
        "message": "请求成功",
        "info": "INSERT INTO tb_config (username,password,level) values ('username','password','level');"
    }
    ```

#### delete

- 路径：`/tools/deleteMsg`

- 发送：

    ```
    {
        "keyParameter": ["Integer id"],
        "tbName": "tb_announce"
    }
    ```

- 返回：

    ```
    {
        "code": 12,
        "message": "请求成功",
        "info": "DELETE FROM tb_announce WHERE id=id;"
    }
    ```

#### query

- 路径：`/tools/selectTable`

- 发送：

    ```
    {
        "parameter": ["String username", "String password", "String level"],
        "keyParameter": ["Integer id"],
        "tbName": "tb_config"
    }
    ```

- 返回：

    ```
    {
        "code": 12,
        "message": "请求成功",
        "info": "SELECT username,password,level FROM tb_config WHERE id=id;"
    }
    ```

### MyBatis

#### create

- 路径：`/tools/mybatisBasics`

- 发送：

    ```
    {
        "namespace":"com.example.manage_platform.dao.AnnounceDao"
    }
    ```

- 返回：

    ```
    {
        "code": 12,
        "message": "请求成功",
        "info": "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<!DOCTYPE mapper\n PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\n\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n\n<mappernamespace=\"com.example.manage_platform.dao.AnnounceDao\">\n\n</mapper>"
    }
    ```

#### update

- 路径：`/tools/mybatisUpdate`

- 发送：

    ```
    {
        "parameter": ["Integer title", "String content", "String dayDate", "String fileArray"],
        "keyParameter": ["Integer id"],
        "tbName": "tb_announce"
    }
    ```

- 返回：

    ```
    {
        "code": 12,
        "message": "请求成功",
        "info": "<update id=\"updateMsg\">\n\tUPDATE tb_announce\n\t<set>\n\t\t<if test=\"title!=null\">title=#{title},</if>\n\t<if test=\"content!=null\">content=#{content},</if>\n\t<if test=\"dayDate!=null\">day_date=#{dayDate},</if>\n\t<if test=\"fileArray!=null\">file_array=#{fileArray}</if>\n\t</set>\n\tWHERE id=#{id}\n</update>"
    }
    ```

#### insert

- 路径：`/tools/mybatisInsert`

- 发送：

    ```
    {
        "parameter": ["Integer title", "String content", "String dayDate", "String fileArray"],
        "tbName": "tb_announce"
    }
    ```

- 返回：

    ```
    {
        "code": 12,
        "message": "请求成功",
        "info": "<insert id=\"insertMsg\">\n\tINSERT INTO tb_announce (title,content,day_date,file_array)\n\tVALUES (#{title},#{content},#{dayDate},#{fileArray})\n</insert>\n"
    }
    ```

#### delete

- 路径：`/tools/mybatisDelete`

- 发送：

    ```
    {
        "keyParameter": ["Integer id"],
        "tbName": "tb_announce"
    }
    ```

- 返回：

    ```
    {
        "code": 12,
        "message": "请求成功",
        "info": "<delete id=\"deleteMsg\">\n\tDELETE FROM tb_announce\n\tWHERE id=#{id}\n</delete>"
    }
    ```

#### query

- 路径：`/tools/mybatisSelect`

- 发送：

    ```
    {
        "parameter": ["Integer title", "String content", "String dayDate", "String fileArray"],
        "keyParameter": ["Integer id"],
        "tbName": "tb_announce"
    }
    ```

- 返回：

    ```
    {
        "code": 12,
        "message": "请求成功",
        "info": "<select id=\"selectMsg\">\n\tSELECT title,content,day_date,file_array\n\tFROM tb_announce\n\tWHERE id=#{id}\n</select>"
    }
    ```
