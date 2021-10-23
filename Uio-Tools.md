# Uio-Tools工具

version：**v1.1**

## 接口文档

- 测试用例：

  ```
  package com.example.java_tools;
  
  public class User {
  
      private String foo = "123123";
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
  }
  ```

### 基础 URL：`https://www.uiofield.top`

### 根路径：`/tools`

### 文本解析接口parse

**v1.1更新**

该接口为 MySQL 和 MyBatis 共用

- 路径：

  ````
  /tools/wordIdentify
  ````

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
  
  ```
  {
      "code": 12,
      "message": "请求成功",
      "info": {
          "parameter":["Integer id", "String username", "String password", "String level","String uniqueName"],
          "tbName": "tb_user",
          "uniqueKey":["uniqueName"],
	        "primaryKey":["id"],
          "comment":["用户id","用户名","用户密码","用户权限","用户唯一名"]
      }
      
  }
  ```

### MySQL

#### 生成创表命令接口create

- 路径：

  ```
  /tools/createSQL
  ```

- 发送：

  ```
  {
      "parameter": ["Integer id", "String username", "String password", "String level"],
      "tbName": "tb_config"
  }
  ```

- 返回：

  ```
  {
      "code": 12,
      "message": "请求成功",
      "info": "CREATE TABLE tb_config( id int(32),username varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,password varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,level varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL);"
  }
  ```

#### 生成更新表命令接口update

- 路径：

  ````
  /tools/updateTable
  ````

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

#### 生成插入表命令insert

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

#### entityCreate

**v1.1新增**

- 路径：

    ```
    /tools/entity2SQL
    ```


- 发送：

    ```json
    {
       	"parameter": ["Integer id", "String taskName", "Long createTime", "String project", "Integer status"],
    	  "uniqueKey":["taskName"],
    	  "primaryKey":["id"],
        "tbName": "tb_config",
        "comment":["任务id","任务名","任务创建时间","任务所属项目","任务状态"]
    }
    ```



- 返回：

    ```json
    {
        "code": 12,
        "message": "请求成功",
        "info": "CREATE TABLE tb_config (id INT (32) UNIQUE COMMENT `任务id`,taskName VARCHAR (255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL UNIQUE COMMENT `任务名`,createTime BIGINT COMMENT `任务创建时间`,project VARCHAR (255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT `任务所属项目`,status INT(32) COMMENT `任务状态` PRIMARY KEY ( id ));"
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