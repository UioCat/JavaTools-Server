package com.example.java_tools.controller;


import com.example.java_tools.entity.User;
import com.example.java_tools.enums.BackEnum;
import com.example.java_tools.exception.CustomException;
import com.example.java_tools.service.CloudService;
import com.example.java_tools.utils.BackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class CloudController {

    @Autowired
    CloudService cloudService;

    /**
     * 用户登录接口
     * @param session
     * @param user username, password
     * @return
     */
    @PostMapping("/cloud_login")
    public BackMessage cloudLoginController(HttpSession session, @RequestBody User user) {
        User userInMysql = cloudService.cloudLoginService(user);
        session.setAttribute("id",userInMysql.getId());
        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

    /**
     * 用户文件列表获取接口
     * @param request -> id
     * @return
     */
    @RequestMapping("/cloud_file_list")
    public BackMessage cloudFileListController(HttpServletRequest request) {

        Integer id = (Integer) request.getSession().getAttribute("id");
        if(id == null){
            throw new CustomException(BackEnum.REQUEST_SUCCESS);
        }
        return cloudService.cloudFileListService(id);

    }

    /**
     * 用户注册接口
     * @param session
     * @param user username,password
     * @return
     */
    @RequestMapping("/cloud_user_register")
    public BackMessage cloudUserRegisterController(HttpSession session, @RequestBody User user) {

        return cloudService.cloudRegisterService(user);
    }

}
