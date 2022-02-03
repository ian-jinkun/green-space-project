package com.company.greenspaceproject.service.impl;

import com.company.greenspaceproject.dao.UserLoginMapper;
import com.company.greenspaceproject.entity.UserLogin;
import com.company.greenspaceproject.service.IUserService;
import com.company.greenspaceproject.service.ex.PasswordNotMatchException;
import com.company.greenspaceproject.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public UserLogin login(String email, String password) {
        UserLogin userLogin = userLoginMapper.findUserByEmail(email);

        if(userLogin == null) {
            throw new UserNotFoundException();
        }

        if(!password.equals(userLogin.getPassword()))
            // throw username or password don't match exception
        {
            throw new PasswordNotMatchException();
        }

//        String userPassword = getMD5Password(password, userLogin.getSalt());
//        if(!userPassword.equals(userLogin.getPassword()))
//            // throw username or password don't match exception
//        {
//            throw new PasswordNotMatchException();
//        }
        return userLogin;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {

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

}
