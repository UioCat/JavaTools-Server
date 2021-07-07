# Uio-Tools工具 接口文档

[toc]
## 测试用例Java

```
package com.example.java_tools;

import java.util.Date;

/**
 * @author han xun
 * Date 2021/6/14 13:19
 * Description:
 */
public class Entity {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 数量
     */
    private Integer counts;

    /**
     * 求和
     */
    private Double sum;

    /**
     * 数字
     */
    private Float number;

    /**
     * 性别
     */
    private Byte sex;

    /**
     * 类型
     */
    private Character type;

    /**
     * 开始时间
     */
    private Date startTime;

    public Entity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}

```

## 测试用例SQL：

```
CREATE TABLE `tb_news` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `article_uid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `index_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `image_source` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `create_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `class_array` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `main_editor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `content_text` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `memo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `article_uid` (`article_uid`)
) ENGINE=InnoDB AUTO_INCREMENT=11845 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```





### 基础 URL：`https://www.uiofield.top`

### 根路径：`/tools`



## 解析SQL创表文件

parseSQL

- 路径，POST

```
/parseSQL
```

- 发送

```json
{
  "data":""
}
```

> data数据见测试用例：测试用例SQL

- 返回

```json
{
  "code":"200",
  "message":"请求成功",
  "info":{
    "fieldList":[
      "Integer id",
      "String title",
      "String keyword",
      "String articleUid"
    ],
    "className":"News",
    "tableName":"tb_news"
  }
}
```



## 根据SQL生成文件

generatorFileBySQL

- 路径，Post

```
/generatorFileBySQL
```

- 发送

```json
[
  {
    "fieldList":[
        "Integer id",
        "String title",
        "String keyword",
        "String articleUid"
      ],
    "tableName":"tb_news",
    "packageName":"com.uio.java_tools",
    "className":"News",
    "generatorMybatisParameterList":[
      {
        "type":"INSERT",
        "parameterList":[
          "Integer title","String keyword","String articleUid"
        ],
        "keyParamterList":null
      }
    ]
  }
]
```

>  1. ！！！！请注意该数据为 JSON数组，即用户可以解析多个SQL文件后，选择需要生成的代码并进行提交，一次性生成文件
>
>  2. fieldList为解析时后端返回的全部数据，与用户的选择数据无关
>
>  3. tableName为解析时后端返回的数据
>
>  4. className为解析时后端返回的数据，用户可以进行更改
>
>  5. projectName为用户输入
>
>  6. generatorMybatisParameterList内的parameterList数组为用户选择的数据，该数据插入，查询时的选择数据
>
>  7. generatorMybatisParameterList内keyParameterList数据为用户选择的诗句，该数据表示查询、修改的条件
>
>  8. generatorMybatisParameterList内type为枚举，只包含：
>
>     ```
>     INSERT
>     DELETE
>     UPDATE
>     SELECT
>     ```

- 返回

```json
{
  "code":"200",
  "message":"请求成功",
  "info":"https://www.uiofield.top/files/xxxx/xxxx.zip"
}
```

> info内为生成文件的下载链接



## 解析Java文件

parseJava

- 路径，Post

```
/parseJava
```

- 发送

```json
{
  "data":""
}
```

> data数据见测试用例

- 返回

```json
{
  "code":"200",
  "message":"请求成功",
  "info":{
    "fieldList":[
      "Integer id",
      "String title",
      "String keyword",
      "String articleUid"
    ],
    "className":"News",
    "tableName":"tb_news",
    "packageName":"com.uio.java_tools"
  }
}
```



## 根据Java生成文件

(该接口的上传参数和返回参数与根据SQL生成文件一致，后续该接口可能会发生变化)

generatorFileByJava

- 请求路径，Post

```
/generatorFileByJava
```

- 发送

```json
[
  {
    "fieldList":[
        "Integer id",
        "String title",
        "String keyword",
        "String articleUid"
      ],
    "tableName":"tb_news",
    "packageName":"com.uio.java_tools",
    "className":"News",
    "generatorMybatisParameterList":[
      {
        "type":"INSERT",
        "parameterList":[
          "Integer title","String keyword","String articleUid"
        ],
        "keyParamterList":null
      }
    ]
  }
]
```

>1. tableName为解析生成，用户可进行修改
>2. packageName为解析生成，用户可进行修改
>3. 类名为解析生成，不需要修改

- 返回

```json
{
  "code":"200",
  "message":"请求成功",
  "info":"https://www.uiofield.top/files/xxxx/xxxx.zip"
}
```

> info内为生成文件的下载链接

## Mybatis生成

暂未定义



## MySQL生成暂时保留原来，后续进行拓展

暂未定义



-------------

## 以下全部弃用

### 文本解析接口parse

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
      "info": [
          "Integer id",
          "String username",
          "String password",
          "String level"
      ]
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