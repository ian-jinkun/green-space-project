package com.company.greenspaceproject.config;


import com.company.greenspaceproject.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Handler, Interceptor Registration
 */


@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        HandlerInterceptor interceptor = new LoginInterceptor();

        //Config White List
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/users/login");
        patterns.add("/users/regis");
        patterns.add("/users/register.html");
        patterns.add("/users/register");
        patterns.add("/users/login.html");
        patterns.add("/");
        patterns.add("/web/index.html");
        patterns.add("/web/main.html");
        patterns.add("/users/verify_regis.html");
        patterns.add("/users/verify_reset.html");
        patterns.add("/users/code-regis");
        patterns.add("/users/code-reset");
        patterns.add("/users/verify-regis");
        patterns.add("/users/verify-reset");
        patterns.add("/users/forget_password.html");
        patterns.add("/users/forget-password");
        patterns.add("/users/change_password");
        patterns.add("/users/change_password.html");
        // register interceptor complete
        interceptorRegistry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns); // Intercept URLs /** means all URLs.

        // Config White List and Black List
    }
}
