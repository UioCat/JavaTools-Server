package com.example.java_tools.dao;

import com.example.java_tools.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {

    /**
     * 插入一条数据
     * @param user username,password,tbName
     */
    void insertMsg(User user);

    /**
     * 创建一张表
     * @param tableName
     */
    void createNewTable(String tableName);

    /**
     * 查询数据ByUsername， 登录时使用
     * @param username
     * @return id,username,password
     */
    User queryUserByUsername(String username);

    /**
     * 查询数据ById
     * @param id
     * @return id，username，password，tbName
     */
    User queryMsgById(int id);

    /**
     * 更新数据ById
     * @param user username | password
     */
    void updateMsgById(User user);

}
