package com.company.greenspaceproject.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/users/login.html").setViewName("login");
        registry.addViewController("/web/index.html").setViewName("main");
        registry.addViewController("/users/register.html").setViewName("register");
        registry.addViewController("/users/verify_regis.html").setViewName("verify_regis");
        registry.addViewController("/users/verify_reset.html").setViewName("verify_reset");
        registry.addViewController("/users/forget_password.html").setViewName("forget_password");
        registry.addViewController("/users/change_password.html").setViewName("change_password");
        registry.addViewController("/users/profile.html").setViewName("profile");

    }

}
