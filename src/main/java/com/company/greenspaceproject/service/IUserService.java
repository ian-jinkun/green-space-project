package com.company.greenspaceproject.service;


import com.company.greenspaceproject.dao.UserLoginMapper;
import com.company.greenspaceproject.entity.Register;
import com.company.greenspaceproject.entity.UserLogin;

/* User Model Service Interface*/
public interface IUserService {
    /**
     * @param email
     * @param password
     * @return
     */
    UserLogin login(String email, String password);

    /**
     * @param email
     * @param password
     * @return
     */
    Register register(String email, String password, String confirm_password);

    /**
     *
     * @param email
     * @return
     */
    String sendVerificationCodeForRegis(String email);

    /**
     *
     * @param code
     * @return
     */
    void checkVerificationCodeForRegis(String email,String code);


    /**
     *
     * @param email
     */
    UserLogin forgetPassword(String email);

    /**
     *
     * @param email
     * @return
     */
    String sendVerificationCodeForReset(String email);

    /**
     *
     * @param code
     * @return
     */
    void checkVerificationCodeForReset(String email,String code);


    /**
     *
     * @param uid
     * @param Password
     * @param confirm_password
     */
    void changePassword(String uid,
                        String Password,
                        String confirm_password);

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
