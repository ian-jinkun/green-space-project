package com.company.greenspaceproject.MapperTests;

import com.company.greenspaceproject.dao.MemberMapper;
import com.company.greenspaceproject.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MemberMapperTest {
    @Autowired
    MemberMapper memberMapper;

    @Test
    void addMember() {
        Member member = new Member();
        member.setUid(-1);
        member.setFirstName("William");
        member.setLastName("Sun");
        member.setGender(1);
        member.setCountry("CA");
        member.setState("MB");
        member.setCity("Winnipeg");
        member.setAddress("173 Victor Lewis Dr");
        member.setZip("R3P 1Z9");
        memberMapper.addMember(member);
    }

    @Test
    void updateMember() {
        Member member = new Member();
        member.setMid(1);
        member.setUid(-1);
        member.setFirstName("William");
        member.setLastName("Sun");
        member.setGender(1);
        member.setZip("R3P 1Z9");

        member.setCountry("US");
        member.setState("CA");
        member.setCity("Irvine");
        member.setAddress("UC Irvine");

        System.out.println(member);

        /*
            Integer updateMember(Integer uid,
                         String firstName,
                         String LastName,
                         String middleName,
                         Integer gender,
                         String country,
                         String state,
                         String city,
                         String zip,
                         String address);
         */
        System.out.println(memberMapper.updateMember(member.getMid(), member.getFirstName(), member.getLastName(), member.getMiddleName(), member.getGender(),member.getCountry(),
                member.getState(), member.getCity(), member.getZip(), member.getAddress()));
    }
}
