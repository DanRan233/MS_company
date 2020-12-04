package com.wzk.service;

import com.aliyuncs.exceptions.ClientException;
import com.wzk.dao.UserDao;
import com.wzk.entity.Result;
import com.wzk.entity.User;
import com.wzk.entity.UserAcCode;
import com.wzk.entity.UserState;
import com.wzk.util.SendSmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/11/11 20:25
 */
@Service
public class UserServiceImpl implements UserServiceIF {

    @Autowired
    private UserDao userDao;

    private SendSmsUtil sendSmsUtil = new SendSmsUtil();

    @Override
    public Result getTel(User user) {
        Result result = new Result(2001, "未执行");
        user = userDao.getTel(user);
        result.setCode(2000);
        result.setMessage("成功");
        result.setData(user);
        return result;
    }

    @Override
    public Result addUser(User user) {
        Result result = new Result(2001, "未执行");
        int i = 0;
        i = userDao.addUser(user);

        if (i > 0) {
            result.setCode(2000);
            result.setMessage("注册成功");
        } else {
            result.setMessage("注册失败");
        }
        return result;

    }

    @Override
    public Result login(User user, UserState userState, HttpSession session) {
        User u;
        Result result = new Result();
        u = userDao.loginUser(user);
        if (u == null) {
            result.setMessage("手机号或密码错误");
        } else if (u.getuId() != 0) {
            u.setStateId(2);
            userState.setuId(u.getuId());
            userState.setStateId(2);
            userDao.updateUserStateId(u);
            userDao.addLoginInfo(userState);
            session.setAttribute("uId", u.getuId());
            result.setCode(2000);
            result.setMessage("登录成功");
            result.setData(u);
        }else {
            result.setCode(2001);
            result.setMessage("手机号或密码错误");
        }

        return result;
    }

    @Override
    public Result addCode(UserAcCode userAcCode) {
        Result result = new Result(2001, "未执行");
        try {
            sendSmsUtil.sendSms(userAcCode.getTel(), userAcCode.getAcCode());
        } catch (ClientException e) {
            e.printStackTrace();
        }
        result.setCode(2000);
        result.setMessage("发送成功");
        result.setData(userAcCode.getAcCode());

        return result;
    }
}
