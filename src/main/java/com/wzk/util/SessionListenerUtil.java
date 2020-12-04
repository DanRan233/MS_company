package com.wzk.util;

import com.wzk.dao.UserDao;
import com.wzk.entity.User;
import org.omg.CORBA.ServerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.HttpSessionMutexListener;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.*;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/12/3 20:02
 */
public class SessionListenerUtil implements HttpSessionListener {

    @Autowired
    UserDao userDao;

    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("session创建");
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("session销毁");
        HttpSession session=event.getSession();
        System.out.println(session.getAttribute("uId"));
        if(session.getAttribute("uId")==null){

        }else {
            userDao.updateUserStateId(new User((int) session.getAttribute("uId"), 1));
        }
    }
}
