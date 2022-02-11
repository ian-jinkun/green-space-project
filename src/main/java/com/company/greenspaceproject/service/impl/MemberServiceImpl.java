package com.company.greenspaceproject.service.impl;

import com.company.greenspaceproject.dao.MemberMapper;
import com.company.greenspaceproject.entity.Member;
import com.company.greenspaceproject.service.IMemberService;
import com.company.greenspaceproject.service.ex.MemberProfileNotFoundException;
import com.company.greenspaceproject.service.ex.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    MemberMapper memberMapper;

    @Override
    public void updateMember(Member member) {
        Integer row = memberMapper.updateMember(member.getMid(), member.getFirstName(), member.getLastName(), member.getMiddleName(), member.getGender(),member.getCountry(),
                member.getState(), member.getCity(), member.getZip(), member.getAddress());
        if(row != 1){
            throw new ServiceException("Unknown Server Error");
        }
    }

    @Override
    public void insertMember(Member member) {
        Integer row = memberMapper.addMember(member);
        if(row != 1){
            throw new ServiceException("Unknown Server Error");
        }
    }

    @Override
    public Member getMemberByUid(Integer uid) {
        Member result = memberMapper.findMemberByUid(uid);
        if(result == null){
            throw new MemberProfileNotFoundException("Member Profile Not Found in Database");
        }
        result.setUid(null);
        result.setMid(null);

        return result;

    }
}
