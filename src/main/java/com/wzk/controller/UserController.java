package com.wzk.controller;

import com.aliyuncs.exceptions.ClientException;
import com.wzk.entity.Result;
import com.wzk.entity.User;
import com.wzk.entity.UserAcCode;
import com.wzk.entity.UserState;
import com.wzk.service.UserServiceIF;
import com.wzk.util.RandomUtil;
import com.wzk.util.SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: 处理用户注册登录等处理的controller
 * @date 2020/11/11 20:24
 */
@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserController {

    @Autowired //默认按类型装配bean
    UserServiceIF userServiceIF;

    // 获取随机数工具类对象
    private RandomUtil randomUtil = new RandomUtil();

    //  获取SHA加密工具类对象
    private SHA sha=new SHA();
    /**
     * description: 用户注册接口。
     * TODO:
     * @date         2020/11/12 0:10
     * @return java.lang.String
     * @author DanRan233
     * @Param [user]
     */
    @RequestMapping("/register")
    public Result register(@RequestBody User user) {
        // 对密码进行加密
        System.out.println(user);
        user.setPassword(sha.encode(user.getPassword()));
        user.setStateId(1);
        return userServiceIF.addUser(user);
    }

    /**
     * description: 查询手机号是否存在接口。
     * TODO: 功能未使用。
     * @date         2020/11/15 17:23
     * @return java.lang.String
     * @author DanRan233
     * @Param [user]
     */
//    @RequestMapping("/getTel")
//    public Result getTel(@RequestBody User user) {
//        return userServiceIF.getTel(user);
//    }

    /**
     * @description: 用户登录接口。
     * TODO: 记录用户登录功能未启用。
     * @date         2020/11/12 13:50
     * @return java.lang.String
     * @author DanRan233
     * @Param [user, req]
     */
    @RequestMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest req, HttpSession session) {
        String ip = req.getRemoteAddr();
        user.setPassword(sha.encode(user.getPassword()));
        UserState userState = new UserState();
        userState.setLoginIP(ip);
        return userServiceIF.login(user, userState, session);
    }

    /**
     * @description: 获取随机验证并向用户发送信息。
     * TODO: 测试短信包有限，提交作品一周或短信包超限后会关闭。如果需要继续测试请将Sevice层发送短信调用注释并将随机验证码打印至控制台
     * @date         2020/12/4 17:55
     * @author      DanRan233
     * @Param       [userAcCode]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getCode")
    public Result getCode(@RequestBody UserAcCode userAcCode) {
        userAcCode.setAcCode(randomUtil.getStrRandom(6));
        userAcCode.setExTime(new Date());
        System.out.println(userAcCode);
        return userServiceIF.addCode(userAcCode);
    }

}
