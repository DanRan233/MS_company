package com.wzk.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: 登录拦截器，保证数据安全性。 TODO
 * @date 2020/12/1 12:56
 */
public class LoginFilterUtil implements Filter {

    // 初始话放行页面，将要放行的文件放入集合中
    static List list = new ArrayList();

    static {
        list.add("/pages/login.html");
        list.add("/user/login");
        list.add("/user/getTel");
        list.add("/user/register");
        list.add("/user/getCode");
        list.add("/js/easyui/jquery.min.js");
        list.add("/js/easyui/jquery.easyui.min.js");
        list.add("/js/login.js");
        list.add("/favicon.ico");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        //获取请求路径
        String path = req.getRequestURI();
        //判断是否放行页面及
        if (list.contains(path)) {
            filterChain.doFilter(req, res);
            return;
        } else {
            //从session中获取用户ID
            int uId;
            try {
                uId = (Integer) session.getAttribute("uId");
            } catch (NullPointerException e) {
                uId = 0;
            }
            // 用户ID存在时直接放行，否则返回值登录页面
            if (uId != 0) {
                filterChain.doFilter(req, res);
            } else {
                res.sendRedirect("/pages/login.html");
            }
        }


    }

    @Override
    public void destroy() {

    }
}
