package com.company.greenspaceproject.service.impl;

import com.company.greenspaceproject.controller.UserController;
import com.company.greenspaceproject.dao.RegisterMapper;
import com.company.greenspaceproject.dao.UserLoginMapper;
import com.company.greenspaceproject.entity.Register;
import com.company.greenspaceproject.entity.User;
import com.company.greenspaceproject.entity.UserLogin;
import com.company.greenspaceproject.service.IUserService;
import com.company.greenspaceproject.service.ex.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Autowired
    private RegisterMapper registerMapper;

    @Value("${mail.fromMail.addr}")
    private String from;
    @Autowired
    private JavaMailSender mailSender;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserLogin login(String email, String password) {
        checkEmailPassword(email, password);
        UserLogin userLogin = userLoginMapper.findUserByEmail(email);

        if(userLogin == null) {
            throw new UserNotFoundException();
        }
//        if(!password.equals(userLogin.getPassword()))
//            // throw username or password don't match exception
//        {
//            throw new PasswordNotMatchException();
//        }
        Integer uid = userLogin.getUid();

        Integer locked = userLogin.getLocked();
        if(locked == 1){
            throw new UserLockedException();
        }

        String userPassword = getMD5Password(password, userLogin.getSalt());
        Integer login_attempts = userLogin.getLogin_attempts();
        if(!userPassword.equals(userLogin.getPassword()))
        // throw username or password don't match exception
        {
            login_attempts+=1;
            userLogin.setLogin_attempts(login_attempts);
            Integer integer = userLoginMapper.updateLoginAttempts(userLogin);
            if(integer == null || integer > 1){
                throw new DatabaseException();
            }

            if(login_attempts >= 5){
                userLogin.setLocked(1);
                Integer integer1 = userLoginMapper.updateLocked(userLogin);
                if(integer1 == null || integer1 > 1){
                    throw new DatabaseException();
                }
                throw new UserLockedException();
            }
            throw new PasswordNotMatchException();
        }
        return userLogin;
    }

    @Override
    public Register register(String email, String password, String confirm_password){
        checkEmailPassword(email, password);
        if(confirm_password==null || confirm_password.equals("")){
            throw new ConfirmPasswordNullException();
        }
        if(!password.equals(confirm_password)){
            throw new ConfirmPasswordNotMatchException();
        }
        UserLogin userLogin = userLoginMapper.findUserByEmail(email);

        if(userLogin != null) {
            throw new EmailDuplicatedException();
        }
        Register register = registerMapper.findUserByEmail(email);
        String salt = UUID.randomUUID().toString().toUpperCase();
        String userPassword = getMD5Password(password, salt);

        if(register != null){
            register.setSalt(salt);
            register.setPassword(userPassword);
            LOGGER.info("Register repeat, update register table");
            registerMapper.update(register);
        }
        else{
            register = new Register();
            register.setEmail(email);
            register.setSalt(salt);
            register.setPassword(userPassword);
            LOGGER.info("Create a new register, insert register table");
            registerMapper.insert(register);
        }
        return register;
    }

    @Override
    public String sendVerificationCodeForRegis(String email){
        if(email == null || email.equals("")){
            throw new EmailNullException();
        }

        Register register = registerMapper.findUserByEmail(email);

        if(register == null){
            throw new RegisterNullException();
        }

        String verificationCode = sendVerificationCode(email);
        register.setVerification_code(verificationCode);
        Integer integer = registerMapper.updateVerificationCode(register);
        if(integer == null || integer > 1) {
            throw new DatabaseException();
        }
        return verificationCode;
    }

    @Override
    public void checkVerificationCodeForRegis(String email,String code){
        if(email == null || email.equals("")){
            throw new EmailNullException();
        }
        if(code == null || code.equals("")){
            throw new VerifyCodeNullException();
        }
        Register register = registerMapper.findUserByEmail(email);
        if(register == null){
            throw new DatabaseException();
        }
        String verification_code = register.getVerification_code();
        if(verification_code == null){
            throw new NotSendVerifyCodeException();
        }
        if(!verification_code.equals(code)){
            throw new VerifyCodeNotMatchException();
        }
        UserLogin userLogin = createUserByVerify(register);
        Integer integer = userLoginMapper.insert(userLogin);
        if(integer == null || integer > 1) {
            throw new DatabaseException();
        }
        integer = registerMapper.delete(register);
        if(integer == null || integer > 1) {
            throw new DatabaseException();
        }
    }

    @Override
    public String sendVerificationCodeForReset(String email){
        if(email == null || email.equals("")){
            throw new EmailNullException();
        }

        UserLogin userLogin = userLoginMapper.findUserByEmail(email);

        if(userLogin == null){
            throw new UserNotFoundException();
        }

        String verificationCode = sendVerificationCode(email);
        userLogin.setVerification_code(verificationCode);
        Integer integer = userLoginMapper.updateVerificationCode(userLogin);
        if(integer == null || integer > 1) {
            throw new DatabaseException();
        }
        return verificationCode;
    }

    @Override
    public void checkVerificationCodeForReset(String email,String code){
        if(email == null || email.equals("")){
            throw new EmailNullException();
        }
        if(code == null || code.equals("")){
            throw new VerifyCodeNullException();
        }
        UserLogin userLogin = userLoginMapper.findUserByEmail(email);
        if(userLogin == null){
            throw new DatabaseException();
        }
        String verification_code = userLogin.getVerification_code();
        if(verification_code == null){
            throw new NotSendVerifyCodeException();
        }
        if(!verification_code.equals(code)){
            throw new VerifyCodeNotMatchException();
        }
    }

    @Override
    public UserLogin forgetPassword(String email){
        if(email == null || email.equals("")){
            throw new EmailNullException();
        }
        UserLogin userLogin = userLoginMapper.findUserByEmail(email);
        if(userLogin == null){
            throw new UserNotFoundException();
        }
        return userLogin;
    }

    @Override
    public void changePassword(String uid, String password, String confirm_password) {
        if(uid == null || uid.equals("")){
            throw new UidNullException();
        }
        Integer id = Integer.parseInt(uid);
        if(password == null || password.equals("")){
            throw new PasswordNullException();
        }
        if(confirm_password==null || confirm_password.equals("")){
            throw new ConfirmPasswordNullException();
        }
        if(!password.equals(confirm_password)){
            throw new ConfirmPasswordNotMatchException();
        }
        UserLogin userLogin = userLoginMapper.findUserByUid(id);

        if(userLogin == null){
            throw new UserNotFoundException();
        }
        String salt = UUID.randomUUID().toString().toUpperCase();
        String userPassword = getMD5Password(password, salt);
        userLogin.setSalt(salt);
        userLogin.setPassword(userPassword);
        userLogin.setLocked(0);
        userLogin.setLogin_attempts(0);
        userLogin.setVerification_code(null);
        Integer integer = userLoginMapper.update(userLogin);
        if(integer == null || integer > 1){
            throw new DatabaseException();
        }
        LOGGER.info("user login change password, update userLogin table");
    }

    @Override
    public UserLoginMapper getByUid(Integer uid) {
        return null;
    }

    @Override
    public void changeInfo(Integer uid, String username, UserLoginMapper user) {

    }

    @Override
    public void changeAvatar(Integer uid, String avatar, String username) {

    }

    /**
     * Generate encrypt password
     * @param password
     * @param salt
     * @return
     */
    private String getMD5Password(String password, String salt){
        // md5 encrypt method for three times
        for(int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        // return password
        return password;
    }
    /**
     *Check Email format（正则表达式）
     * @param content
     * @return
     */
    private boolean checkEmailFormat(String content){
        /*
         * " \w"：'[A-Za-z0-9_]'。
         * "|"  :or
         * "*" : Zero or more occurrences
         * "+" : occurs once or more times
         * "{n,m}" :  at least n and a maximum of m
         * "$" : end of previous character
         */
        String REGEX="^\\w+((-\\w+)|(\\.\\w+))*@\\w+(\\.\\w{2,3}){1,3}$";
        Pattern p = Pattern.compile(REGEX);
        Matcher matcher=p.matcher(content);

        return matcher.matches();
    }

    private void checkEmailPassword(String email, String password) {
        if(email==null || email.equals("")){
            throw new EmailNullException();
        }
        if(password==null || password.equals("")){
            throw new PasswordNullException();
        }
        if(!checkEmailFormat(email)){
            throw new EmailInvalidFormatException();
        }
    }

    private String generateVerificationCode(){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        return checkCode;
    }

    private String sendVerificationCode(String email){
        String verificationCode = generateVerificationCode();
        String massage = "Your verification code is " + verificationCode +".";
        sendSimpleMail(email,"Verification Code",massage);
        return verificationCode;
    }

    private void sendSimpleMail(String to,String title,String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(title);
            message.setText(content);
            mailSender.send(message);
            LOGGER.info("Email is sent");
        }catch (SendVerificationCodeException e) {
            e.printStackTrace();
        }
    }

    private UserLogin createUserByVerify(Register register){
        UserLogin userLogin = new UserLogin();
        userLogin.setEmail(register.getEmail());
        userLogin.setPassword(register.getPassword());
        userLogin.setSalt(register.getSalt());
        return userLogin;
    }



}
