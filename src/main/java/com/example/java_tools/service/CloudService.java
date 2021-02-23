package com.example.java_tools.service;

import com.example.java_tools.dao.FileMessageDao;
import com.example.java_tools.dao.UserDao;
import com.example.java_tools.entity.FileMessage;
import com.example.java_tools.entity.User;
import com.example.java_tools.enums.BackEnum;
import com.example.java_tools.exception.CustomException;
import com.example.java_tools.utils.BackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudService {

    @Autowired
    UserDao userDao;
    @Autowired
    FileMessageDao fileMessageDao;

    /**
     * 用户登录接口
     * @param user
     * @return
     */
    public User cloudLoginService(User user) {
        User userInMysql = userDao.queryUserByUsername(user.getUsername());

        if(userInMysql == null) {
            //如果账号不存在
            throw new CustomException(BackEnum.NO_USER);
        }else {
            if(userInMysql.getPassword().equals(user.getPassword())) {
                return userInMysql;
            }else {
                throw new CustomException(BackEnum.PWD_ERROR);
            }
        }
    }

    /**
     * 用户云储存文件列表获取
     * @param id
     * @return
     */
    public BackMessage cloudFileListService(int id) {
        User user = userDao.queryMsgById(id);
        String tableName = user.getTbName() ;
        List<FileMessage> result = fileMessageDao.queryAllMsg(tableName);

        return new BackMessage(BackEnum.REQUEST_SUCCESS,result);
    }

    /**
     * 用户注册接口
     * @param user
     * @return
     */
    public BackMessage cloudRegisterService(User user){
        User userInMysql = userDao.queryUserByUsername(user.getUsername());

        if(userInMysql != null){
            throw new CustomException(BackEnum.DATA_ERROR);
        }
        String tableName = "tb_" + user.getUsername();
        user.setTbName(tableName);

        userDao.insertMsg(user);
        userDao.createNewTable(tableName);

        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

}
