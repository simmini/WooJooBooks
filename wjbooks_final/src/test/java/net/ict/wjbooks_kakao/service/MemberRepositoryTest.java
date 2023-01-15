package net.ict.wjbooks_kakao.service;

import net.ict.wjbooks_kakao.constant.Role;
import net.ict.wjbooks_kakao.domain.Member;
import net.ict.wjbooks_kakao.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest

public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertMem(){
        Member member = Member.builder()
                .memNum(999L)
                .memEmail("test1@naver.com")
                .memName("test")
                .memPass(passwordEncoder.encode("test1@naver.com"))
                .memTel("01012345678")
                .memAdr1("test시")
                .memAdr2("test구")
                .build();
        member.addRole(Role.ADMIN);
        memberRepository.save(member);
    }

}
