package com.wzk.service;

import com.wzk.dao.UserDao;
import com.wzk.entity.User;
import com.wzk.entity.UserState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    UserDao userDao;

    @Override
    public Map<String,Object> addUser(User user) {
        Map<String,Object> map = new HashMap<>();
        map.put("result",0);
        map.put("resultInfo","");
        int i=0;
        try {
            i=userDao.addUser(user);
        }catch (Exception e){
            e.printStackTrace();
            map.put("resultInfo",e.getMessage());
        }
        if (i>0){
            map.put("result",1);
            map.put("resultInfo","注册成功");
            return map;
        }else {
            map.put("result",0);
            map.put("resultInfo","注册失败");
            return map;
        }

    }

    @Override
    public Map<String,Object> login(User user, UserState userState) {
        User u=new User();
        Map<String,Object> map = new HashMap<>();
        map.put("result",0);
        map.put("resultInfo","");
        try {
            u=userDao.loginUser(user);
            if(u==null){
                map.put("result",1);
                map.put("resultInfo","用户名或密码错误");
            } else if (u.getuId()!=0&&u.getStateId()!=2){
                u.setStateId(2);
                userState.setuId(u.getuId());
                userState.setStateId(2);
                userDao.updateUserStateId(u);
                userDao.addLoginType(userState);
                map.put("result",3);
                map.put("resultInfo","登录成功");
                map.put("data",u);
            }else if (u.getStateId()==2){
                u.setStateId(-1);
                map.put("result",2);
                map.put("resultInfo","用户已登录");
            }else {
                map.put("result",1);
                map.put("resultInfo","用户名或密码错误");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
