package com.company.greenspaceproject.controller;

import com.company.greenspaceproject.entity.Register;
import com.company.greenspaceproject.entity.UserLogin;
import com.company.greenspaceproject.service.IUserService;
import com.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


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
        session.setAttribute("uid", userLogin.getUid());
        session.setAttribute("email", userLogin.getEmail());

        LOGGER.info(userLogin.getUid()+"");

        LOGGER.info("Login Success");
        LOGGER.info(userLogin.toString());

        // Get Session Data

        LOGGER.info(getUidFromSession(session).toString());

        LOGGER.info(getEmailFromSession(session));

        return new JsonResult<UserLogin>(OK, userLogin);
    }

    @RequestMapping("regis")
    public JsonResult<Register> register(String email,
                                      String password,
                                      String confirm_password,
                                      HttpSession session){
        Register register = iUserService.register(email,password,confirm_password);

        session.setAttribute("register", register);
        LOGGER.info("Register Success");
        LOGGER.info(getRegister(session));

        return new JsonResult<Register>(OK, register);
    }

    @RequestMapping("forget-password")
    public JsonResult<String> forgetPassword(String email, HttpSession session){
        LOGGER.info("Get email:" + email);

        UserLogin userLogin = iUserService.forgetPassword(email);

        session.setAttribute("email", userLogin.getEmail());
        session.setAttribute("uid", userLogin.getUid());

        LOGGER.info(getUidFromSession(session).toString());
        LOGGER.info(getEmail(session));

        return new JsonResult<String>(OK);
    }

    @RequestMapping("code-regis")
    public JsonResult<String> sendVerificationCodeForRegis(String email){
        LOGGER.info("Get email:" + email);
        LOGGER.info("Get register verification code email:" + email);

        String verificationCode =  iUserService.sendVerificationCodeForRegis(email);

        LOGGER.info("Send verification code success:" + verificationCode);

        return new JsonResult<String>(OK);
    }

    @RequestMapping("verify-regis")
    public JsonResult<String> checkVerificationCodeForRegis(String email, String code, HttpSession session){
        LOGGER.info("Get inputting code:" + code);
        LOGGER.info("Get email:" + email);

        iUserService.checkVerificationCodeForRegis(email,code);

        session.removeAttribute("register");
        LOGGER.info("Inputting code match the verification code");

        return new JsonResult<String>(OK);
    }

    @RequestMapping("code-reset")
    public JsonResult<String> sendVerificationCodeForRest(String email) {
        LOGGER.info("Get email:" + email);
        LOGGER.info("Get reset verification code email:" + email);

        String verificationCode = iUserService.sendVerificationCodeForReset(email);

        LOGGER.info("Send verification code success:" + verificationCode);

        return new JsonResult<String>(OK);
    }

    @RequestMapping("verify-reset")
    public JsonResult<String> checkVerificationCodeForReset(String email, String code){
        LOGGER.info("Get inputting code:" + code);
        LOGGER.info("Get email:" + email);

        iUserService.checkVerificationCodeForReset(email,code);

        LOGGER.info("Inputting code match the verification code");

        return new JsonResult<String>(OK);
    }

    @RequestMapping("change-password")
    public JsonResult<String> forgetPassword(String uid, String password, String confirm_password, HttpSession session){
        LOGGER.info("Get uid:" + uid);

        LOGGER.info("Get password:" + password);

        LOGGER.info("Get confirm password:" + confirm_password);

        iUserService.changePassword(uid, password, confirm_password);

        session.removeAttribute("uid");

        session.removeAttribute("email");

        LOGGER.info("Change password successful");

        return new JsonResult<String>(OK);
    }


}
