package net.ict.wjbooks_kakao.service;

import net.ict.wjbooks_kakao.dto.MemberFormDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public MemberFormDto createMem(){
        MemberFormDto dto = new MemberFormDto();
        dto.setEmail("qwertyasdf@naver.com");
        dto.setName("테스트");
        dto.setAdr1("테스트시");
        dto.setAdr2("테스트구");
        dto.setPassword("test1@naver.com");
        dto.setTellPhone("01012345678");
        return dto;
    }
    @Test
    public void insertMemberTest() throws MemberService.MidExistException {
        MemberFormDto mem = createMem();
        memberService.join(mem);

    }
}
