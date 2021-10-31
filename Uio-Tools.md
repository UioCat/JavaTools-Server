# Uio-Tools 工具

version：**v1.3**

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

**v1.3 更新**
该接口为 MySQL 和 MyBatis 共用

- 路径：

    ```
    /tools/wordIdentify
    ```

- 发送：

    ```
    {
      "data": "package com.example.java_tools;\r\n\r\n  public class User {\r\n\r\n      private String foo = 123123;\r\n      private String name;\r\n      private Integer sex;\r\n      private Boolean urban;\r\n      private Double balance;\r\n      private Float money;\r\n\r\n      public User(String foo, String name, Integer sex, Boolean urban, Double balance, Float money) {\r\n          this.foo = foo;\r\n          this.name = name;\r\n          this.sex = sex;\r\n          this.urban = urban;\r\n          this.balance = balance;\r\n          this.money = money;\r\n      }\r\n\r\n      public String getName() {\r\n          return name;\r\n      }\r\n\r\n      public void setName(String name) {\r\n          this.name = name;\r\n      }\r\n  }"
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
                    "datatype": "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci",
                    "field": "foo",
                    "comment": "private",
                    "defaultValue": "123123",
                    "unique": false
                },
                {
                    "type": "String",
                    "datatype": "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci",
                    "field": "name",
                    "comment": "private",
                    "defaultValue": null,
                    "unique": false
                },
                {
                    "type": "Integer",
                    "datatype": "int(32)",
                    "field": "sex",
                    "comment": "private",
                    "defaultValue": null,
                    "unique": false
                },
                {
                    "type": "Boolean",
                    "datatype": "bit(1)",
                    "field": "urban",
                    "comment": "private",
                    "defaultValue": null,
                    "unique": false
                },
                {
                    "type": "Double",
                    "datatype": "double",
                    "field": "balance",
                    "comment": "private",
                    "defaultValue": null,
                    "unique": false
                },
                {
                    "type": "Float",
                    "datatype": "float",
                    "field": "money",
                    "comment": "private",
                    "defaultValue": null,
                    "unique": false
                }
            ],
            "tableName": "User",
            "primaryKey": null,
            "namespace": null,
            "underline": false
        }
    }
    ```

### MySQL

#### 生成创表命令接口 create

**v1.3 更新**

- 路径：

    ```
    /tools/createSQL
    ```

- 发送：

    ```json
    {
        "parameters": [
            {
                "type": "String",
                "datatype": "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci",
                "field": "foo",
                "comment": "private",
                "defaultValue": "123123",
                "unique": false
            },
            {
                "type": "String",
                "datatype": "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci",
                "field": "name",
                "comment": "private",
                "defaultValue": null,
                "unique": false
            },
            {
                "type": "Integer",
                "datatype": "int(32)",
                "field": "sex",
                "comment": "private",
                "defaultValue": null,
                "unique": false
            },
            {
                "type": "Boolean",
                "datatype": "bit(1)",
                "field": "urban",
                "comment": "private",
                "defaultValue": null,
                "unique": false
            },
            {
                "type": "Double",
                "datatype": "double",
                "field": "balance",
                "comment": "private",
                "defaultValue": null,
                "unique": false
            },
            {
                "type": "Float",
                "datatype": "float",
                "field": "money",
                "comment": "private",
                "defaultValue": null,
                "unique": false
            }
        ],
        "tableName": "User",
        "primaryKey": null,
        "namespace": null,
        "underline": false
    }
    ```

- 返回：

    ```json
    {
        "code": 200,
        "message": "请求成功",
        "info": "CREATE TABLE User(\r\n    `foo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 123123 comment `private`,\r\n    `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT null comment `private`,\r\n    `sex` int(32) DEFAULT null comment `private`,\r\n    `urban` bit(1) DEFAULT null comment `private`,\r\n    `balance` double DEFAULT null comment `private`,\r\n    `money` float DEFAULT null comment `private`\r\n);"
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
