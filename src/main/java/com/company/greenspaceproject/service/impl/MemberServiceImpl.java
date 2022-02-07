package com.company.greenspaceproject.service.impl;

import com.company.greenspaceproject.dao.MemberMapper;
import com.company.greenspaceproject.entity.Member;
import com.company.greenspaceproject.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    MemberMapper memberMapper;

    @Override
    public void updateMember(Member member) {

    }

    @Override
    public void insertMember(Member member) {

    }
}
