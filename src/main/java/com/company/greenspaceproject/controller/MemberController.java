package com.company.greenspaceproject.controller;

import com.company.greenspaceproject.dao.MemberMapper;
import com.company.greenspaceproject.dao.UserLoginMapper;
import com.company.greenspaceproject.entity.Member;
import com.company.greenspaceproject.entity.UserLogin;
import com.company.greenspaceproject.service.IMemberService;
import com.company.greenspaceproject.service.ex.SessionNotFoundException;
import com.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("member")
public class MemberController extends BaseController{
    @Autowired
    private IMemberService memberService;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private UserLoginMapper userLoginMapper;

    @RequestMapping("update_member")
    public JsonResult<Void> updateMember(HttpSession session,
                                         Member member){
        Integer uid = getUidFromSession(session);
        UserLogin user = userLoginMapper.findUserById(uid);
        if(user == null)
            throw new SessionNotFoundException("Session Expired");
        member.setUid(uid);
//        Integer mid = memberMapper.findMemberByUid(uid);
//        if(mid == null) {
//            memberService.insertMember(member);
//        }
        Member findMember = memberMapper.findMemberByUid(uid);
        if(findMember == null){
            memberService.insertMember(member);
        }
        else {
            member.setMid(findMember.getMid());
            memberService.updateMember(member);
        }
        return new JsonResult<>(OK);

    }
    @RequestMapping("get_member_by_uid")
    public JsonResult<Member> getMemberByUid(HttpSession session){
        Member data = memberService.getMemberByUid(getUidFromSession(session));

        return new JsonResult<>(OK, data);
    }
}
