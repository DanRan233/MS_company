package com.wzk.controller;

import com.alibaba.fastjson.JSONObject;
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
    public String register(@RequestBody User user) {
        System.out.println(user);
        user.setStateId(1);
        return JSONObject.toJSONString(userServiceIF.addUser(user));
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
    public String login(@RequestBody User user, HttpServletRequest req) {
        String ip = req.getRemoteAddr();
        UserState userState = new UserState();
        userState.setLoginIP(ip);
        Map<String, Object> map = new HashMap<>();
        map.put("result",0);
        map.put("resultInfo","用户名或密码未输入");
        if ("".equals(user.getuName()) || user.getuName() == null || "".equals(user.getPassword()) || user.getPassword() == null) {
            map.put("result",0);
            map.put("resultInfo","用户名或密码未输入");
            return JSONObject.toJSONString(map);
        }
        map = userServiceIF.login(user, userState);

        return JSONObject.toJSONString(map);
    }


}
