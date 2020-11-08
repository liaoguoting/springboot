package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
//    @ResponseBody //去掉 return "xxx"就会跳到视图，否则直接显示文本内容
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session//1108 拦截器
    ) {
        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            session.setAttribute("loginUser", username);//1108 拦截器
//            return "dashboard";//直接进入登录页面
            return "redirect:/main.html";//1107 登陆功能 重定向
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        }
    }
}
