package com.company.greenspaceproject.dao;


import com.company.greenspaceproject.entity.Register;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RegisterMapper {

    /**
     *
     * @param email
     * @return
     */
    public Register findUserByEmail(String email);

    /**
     *
     * @param register
     */
    public Integer insert(Register register);

    /**
     *
     * @param register
     * @return
     */
    public Integer update(Register register);

    /**
     *
     * @param register
     * @return
     */
    public Integer delete(Register register);

    /**
     *
     * @param register
     * @return
     */
    public Integer updateVerificationCode(Register register);



}
