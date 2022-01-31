package com.company.greenspaceproject.service;


import com.company.greenspaceproject.dao.UserLoginMapper;
import com.company.greenspaceproject.entity.UserLogin;

/* User Model Service Interface*/
public interface IUserService {
    /**
     * @param email
     * @param password
     * @return
     */
    UserLogin login(String email, String password);

    void changePassword(Integer uid,
                        String username,
                        String oldPassword,
                        String newPassword);

    /**
     * Find user from uid
     * @param uid user's uid
     * @return User
     */
    UserLoginMapper getByUid(Integer uid);

    void changeInfo(Integer uid, String username, UserLoginMapper user);


    /**
     *
     * @param uid user's uid
     * @param avatar user's avatar path
     * @param username user's username
     */
    void changeAvatar(Integer uid,
                      String avatar,
                      String username);

}
