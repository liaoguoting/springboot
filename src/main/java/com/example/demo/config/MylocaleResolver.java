package com.example.demo.config;

import org.apache.tomcat.jni.Local;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MylocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
//        获取请求中的语言参数
        String language = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();
        //请求的连接携带了国际化参数
        if (!StringUtils.isEmpty(language)) {
            //zh_CN en_US
            String[] split = language.split("_");
            //国家，地区
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
