package net.ict.wjbooks.service;

import net.ict.wjbooks.domain.Member;
import net.ict.wjbooks.dto.MemberFormDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
//@Transactional

public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Member createMem(){
        MemberFormDto dto = new MemberFormDto();
        dto.setEmail("test1201@naver.com");
        dto.setName("1201테스트");
        dto.setAdr1("서울시");
        dto.setPassword("1234");
        dto.setTellPhone("01047233629");
        return Member.createMember(dto,passwordEncoder);
    }
    @Test
    public void insertMemberTest(){
        Member mem = createMem();
        memberService.saveMember(mem);
    }
}
