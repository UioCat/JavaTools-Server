package com.example.java_tools;

import com.example.java_tools.service.impl.SQLConvertServiceImpl;
import com.example.java_tools.service.impl.TokenizerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class Test {

    @Autowired
    TokenizerServiceImpl tokenizerService;
    @Autowired
    SQLConvertServiceImpl sqlConvertService;

    @org.junit.jupiter.api.Test
    void testForWordIdentity() {
        List<String> str = tokenizerService.extractFieldFromJavaCode("package com.uio.green_book.entity;\n" +
                "\n" +
                "import java.text.SimpleDateFormat;\n" +
                "\n" +
                "public class Comment {\n" +
                "\n" +
                "    /** 评论id */\n" +
                "    private Long id;\n" +
                "\n" +
                "    /** 评论内容 */\n" +
                "    private String content;\n" +
                "\n" +
                "    /** 评论用户id */\n" +
                "    private Integer commentUserId;\n" +
                "\n" +
                "    /** 评论时间 */\n" +
                "    private String time;\n" +
                "\n" +
                "    /**评论的作品id */\n" +
                "    private long showreelId;\n" +
                "\n" +
                "    /** 评论用户头像 */\n" +
                "    private String commentUserHeadImage;\n" +
                "\n" +
                "    public Comment() {\n" +
                "    }\n" +
                "\n" +
                "    public Comment(Long id, String content, User user,long showreelId) {\n" +
                "        this.id = id;\n" +
                "        this.content = content;\n" +
                "        this.commentUserId = user.getId();\n" +
                "        this.commentUserHeadImage = user.getHeadImage();\n" +
                "        this.time = new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\").format(System.currentTimeMillis());\n" +
                "        this.showreelId = showreelId;\n" +
                "    }\n" +
                "\n" +
                "    public String getCommentUserHeadImage() {\n" +
                "        return commentUserHeadImage;\n" +
                "    }\n" +
                "\n" +
                "    public void setCommentUserHeadImage(String commentUserHeadImage) {\n" +
                "        this.commentUserHeadImage = commentUserHeadImage;\n" +
                "    }\n" +
                "\n" +
                "    public long getShowreelId() {\n" +
                "        return showreelId;\n" +
                "    }\n" +
                "\n" +
                "    public void setShowreelId(long showreelId) {\n" +
                "        this.showreelId = showreelId;\n" +
                "    }\n" +
                "\n" +
                "    public Long getId() {\n" +
                "        return id;\n" +
                "    }\n" +
                "\n" +
                "    public void setId(Long id) {\n" +
                "        this.id = id;\n" +
                "    }\n" +
                "\n" +
                "    public String getContent() {\n" +
                "        return content;\n" +
                "    }\n" +
                "\n" +
                "    public void setContent(String content) {\n" +
                "        this.content = content;\n" +
                "    }\n" +
                "\n" +
                "    public Integer getCommentUserId() {\n" +
                "        return commentUserId;\n" +
                "    }\n" +
                "\n" +
                "    public void setCommentUserId(Integer commentUserId) {\n" +
                "        this.commentUserId = commentUserId;\n" +
                "    }\n" +
                "\n" +
                "    public String getTime() {\n" +
                "        return time;\n" +
                "    }\n" +
                "\n" +
                "    public void setTime(String time) {\n" +
                "        this.time = time;\n" +
                "    }\n" +
                "}\n");

        System.out.println(Arrays.toString(str.toArray()));

    }
}

class User {

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

    public Integer getSex()     {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Boolean getUrban() {
        return urban;
    }

    public void setUrban(Boolean urban) {
        this.urban = urban;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
}