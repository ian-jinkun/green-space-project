package com.company.greenspaceproject.dao;

import com.company.greenspaceproject.entity.UserLogin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginMapper {
    /**
     * @param email
     * @return return the UserLogin find, if not find return null.
     */
    public UserLogin findUserByEmail(String email);

    /**
     * Insert login user
     * @param userLogin
     * @returnlines impact (add, delete, update impacted number of lines as a return, check if execute success)
     */
    public Integer insert(UserLogin userLogin);

}
