package com.wzk.service;

import com.aliyuncs.exceptions.ClientException;
import com.wzk.entity.Result;
import com.wzk.entity.User;
import com.wzk.entity.UserAcCode;
import com.wzk.entity.UserState;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/11/11 20:24
 */
public interface UserServiceIF {

    Result addUser(User user);

    Result  login(User user, UserState userState, HttpSession session);

    Result addCode(UserAcCode userAcCode);
}
