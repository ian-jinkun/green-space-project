package com.company.greenspaceproject.dao;

import com.company.greenspaceproject.entity.Member;

public interface MemberMapper {
    Integer addMember(Member member);

    Member findMemberByUid(Integer uid);
}
