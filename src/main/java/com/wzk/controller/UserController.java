package com.wzk.controller;

import com.wzk.service.UserServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author DanRan233
 * @title: Usercontroller
 * @projectName demo_One
 * @description: TODO
 * @date 2020/8/22 16:40
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceIF userServiceIF;



}
