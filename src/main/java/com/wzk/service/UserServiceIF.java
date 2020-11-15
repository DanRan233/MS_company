package com.wzk.service;

import com.wzk.entity.Result;
import com.wzk.entity.User;
import com.wzk.entity.UserState;

import java.util.Map;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/11/11 20:24
 */
public interface UserServiceIF {

    Result getTel(User user);

    Result addUser(User user);

    Result  login(User user, UserState userState);
}
