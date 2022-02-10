package com.company.greenspaceproject.dao;

import com.company.greenspaceproject.entity.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserLoginMapper {
    /**
     * @param email
     * @return return the UserLogin find, if not find return null.
     */
    UserLogin findUserByEmail(String email);

    /**
     *
     * @param uid
     * @return
     */
    UserLogin findUserByUid(Integer uid);

    /**
     * Insert login user
     * @param userLogin
     * @returnlines impact (add, delete, update impacted number of lines as a return, check if execute success)
     */
    Integer insert(UserLogin userLogin);

    /**
     *
     * @param userLogin
     * @return
     */
    Integer update(UserLogin userLogin);

    /**
     *
     * @param userLogin
     * @return
     */
    Integer updateVerificationCode(UserLogin userLogin);

    /**
     *
     * @param userLogin
     * @return
     */
    Integer updateLoginAttempts(UserLogin userLogin);

    /**
     *
     * @param userLogin
     * @return
     */
    Integer updateLocked(UserLogin userLogin);


    public UserLogin findUserById(Integer uid);

}
