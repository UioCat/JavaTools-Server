package com.example.java_tools.dao;

import com.example.java_tools.entity.FileMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface FileMessageDao {

    /**
     * 插入一条文件信息
     * @param fileMessage id,fileName,fileUrl,tbName
     */
    void insertMsg(FileMessage fileMessage);

    /**
     * 查询数据库中所有文件信息
     * @param tableName
     * @return
     */
    List<FileMessage> queryAllMsg(String tableName);

    /**
     * 根据id 删除一条文件信息
     * @param fileMessage id,tbName
     */
    void deleteMsgById(FileMessage fileMessage);


}
