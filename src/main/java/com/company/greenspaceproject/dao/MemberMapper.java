package com.company.greenspaceproject.dao;

import com.company.greenspaceproject.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper {
    Integer addMember(Member member);

    Member findMemberByUid(Integer uid);

    Integer updateMember(Integer mid,
                         String firstName,
                         String lastName,
                         String middleName,
                         Integer gender,
                         String country,
                         String state,
                         String city,
                         String zip,
                         String address);
}
