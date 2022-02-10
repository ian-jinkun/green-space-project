package com.company.greenspaceproject.ServiceTests;

import com.company.greenspaceproject.entity.Member;
import com.company.greenspaceproject.service.IMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    IMemberService memberService;

    @Test
    void updateMember() {
        Member member = new Member();
        member.setMid(1);
        member.setUid(-1);
        member.setFirstName("William");
        member.setLastName("Sun");
        member.setGender(1);
        member.setZip("R3P 1Z9");

        member.setCountry("CA");
        member.setState("MB");
        member.setCity("Winnipeg");
        member.setAddress("173 Victor Lewis Dr");

        System.out.println(member);

        memberService.updateMember(member);
    }

    @Test
    void addMember() {
        Member member = new Member();
        member.setUid(-2);
        member.setFirstName("William");
        member.setLastName("Sun");
        member.setGender(1);
        member.setZip("91710");

        member.setCountry("US");
        member.setState("CA");
        member.setCity("Irvine");
        member.setAddress("165 Pinestone St");

        System.out.println(member);

        memberService.insertMember(member);
    }
}
