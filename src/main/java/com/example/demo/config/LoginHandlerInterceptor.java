package com.example.demo.config;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//      登录成功之后，应该有用户session
        Object loginuser = request.getSession().getAttribute("loginUser");
        if (loginuser == null) {
            request.setAttribute("msg", "没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);//属于转发，也是服务器跳转，相当于方法调用，在执行当前文件的过程中转向执行目标文件
            return false;
        } else {
            return true;
        }
    }
}
