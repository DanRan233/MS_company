package com.wzk.controller;

import com.alibaba.fastjson.JSONObject;
import com.wzk.entity.Result;
import com.wzk.entity.User;
import com.wzk.entity.UserState;
import com.wzk.service.UserServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/11/11 20:24
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserServiceIF userServiceIF;

    /**
     * description  TODO
     * date         2020/11/12 0:10
     *
     * @return java.lang.String
     * @author DanRan233
     * @Param [user]
     */
    @RequestMapping("/register")
    public Result register(@RequestBody User user) {
        System.out.println(user);
        user.setStateId(1);
        return userServiceIF.addUser(user);
    }

    /**
     * description  TODO
     * date         2020/11/15 17:23
     * @author      DanRan233
     * @Param       [user]
     * @return      java.lang.String
     */
    @RequestMapping("/getTel")
    public Result getTel(@RequestBody User user){
        System.out.println(user);
        return userServiceIF.getTel(user);
    }

    /**
     * description  TODO
     * date         2020/11/12 13:50
     *
     * @return java.lang.String
     * @author DanRan233
     * @Param [user, req]
     */
    @RequestMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest req) {
        String ip = req.getRemoteAddr();
        UserState userState = new UserState();
        userState.setLoginIP(ip);
        if ("".equals(user.getTel()) || user.getTel() == null || "".equals(user.getPassword()) || user.getPassword() == null) {
            return new Result(2001,"手机号或密码为空");
        }
        return userServiceIF.login(user, userState);
    }


}
