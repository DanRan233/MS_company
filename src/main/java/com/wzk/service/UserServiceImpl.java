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

    //创建阿里云短息工具类对象
    private SendSmsUtil sendSmsUtil = new SendSmsUtil();

    /**
     * description: 添加用户。
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/4 18:32
     * @author DanRan233
     * @Param [user]
     */
    @Override
    public Result addUser(User user) {
        Result result = new Result(2001, "未执行");
        int i = 0;
        i = userDao.addUser(user);
        System.out.println(i);
        if (i > 0) {
            result.setCode(2000);
            result.setMessage("注册成功");
        } else {
            result.setMessage("注册失败");
        }
        return result;

    }

    /**
     * description: 用户登录。
     * TODO: 用户登录状态及用户登录记录未启用
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/4 18:33
     * @author DanRan233
     * @Param [user, userState, session]
     */
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
            //userDao.addLoginInfo(userState);
            session.setAttribute("uId", u.getuId());
            result.setCode(2000);
            result.setMessage("登录成功");
            result.setData(u);
        } else {
            result.setCode(2001);
            result.setMessage("手机号或密码错误");
        }

        return result;
    }

    /**
     * description: 获取短信验证码。
     * TODO: 此方法因短信包有限，若测试时出现异常可能是短信包超量，请将方法中try-catch注释并将注释掉的代码启用
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/4 18:34
     * @author DanRan233
     * @Param [userAcCode]
     */
    @Override
    public Result addCode(UserAcCode userAcCode) {
        Result result = new Result(2001, "未执行");
        int i =userDao.getTel(userAcCode);
        System.out.println(i);
        if (i == 0) {
            try {
                sendSmsUtil.sendSms(userAcCode.getTel(), userAcCode.getAcCode());
                result.setCode(2000);
                result.setMessage("发送成功");
                result.setData(userAcCode.getAcCode());
            } catch (ClientException e) {
                e.printStackTrace();
                result.setCode(2001);
                result.setMessage("执行异常");
                result.setData(e.getErrMsg());
            }
//            result.setCode(2000);
//            result.setMessage("发送成功");
//            result.setData(userAcCode.getAcCode());
        } else {
            result.setMessage("手机号已存在");
        }
        return result;
    }
}
