package com.company.greenspaceproject.controller;

import com.company.greenspaceproject.entity.UserLogin;
import com.company.greenspaceproject.service.IUserService;
import com.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController // = @Controller + @ResponseBody
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    IUserService iUserService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("login")
    public JsonResult<UserLogin> login(String email,
                                       String password,
                                       HttpSession session){
        UserLogin userLogin = iUserService.login(email, password);

        // Bind data to Session
        session.setAttribute("id", userLogin.getId());
        session.setAttribute("email", userLogin.getEmail());

        LOGGER.info("Login Success");

        // Get Session Data

        LOGGER.info(getUidFromSession(session).toString());

        LOGGER.info(getEmailFromSession(session));

        return new JsonResult<UserLogin>(OK, userLogin);
    }

}
