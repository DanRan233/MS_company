package com.wzk.controller;

import com.aliyuncs.exceptions.ClientException;
import com.wzk.entity.Result;
import com.wzk.entity.User;
import com.wzk.entity.UserAcCode;
import com.wzk.entity.UserState;
import com.wzk.service.UserServiceIF;
import com.wzk.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/11/11 20:24
 */
@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserServiceIF userServiceIF;

    private RandomUtil randomUtil = new RandomUtil();

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
     *
     * @return java.lang.String
     * @author DanRan233
     * @Param [user]
     */
    @RequestMapping("/getTel")
    public Result getTel(@RequestBody User user) {
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
    public Result login(@RequestBody User user, HttpServletRequest req, HttpSession session) {
        String ip = req.getRemoteAddr();
        UserState userState = new UserState();
        userState.setLoginIP(ip);
        return userServiceIF.login(user, userState, session);
    }


    @RequestMapping("/getCode")
    public Result getCode(@RequestBody UserAcCode userAcCode) {
        userAcCode.setAcCode(randomUtil.getStrRandom(6));
        userAcCode.setExTime(new Date());
        System.out.println(userAcCode);
        return userServiceIF.addCode(userAcCode);
    }

}
