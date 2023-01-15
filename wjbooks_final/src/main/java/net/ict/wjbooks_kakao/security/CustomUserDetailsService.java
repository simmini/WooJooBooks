package net.ict.wjbooks_kakao.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.wjbooks_kakao.domain.Member;
import net.ict.wjbooks_kakao.repository.MemberRepository;
import net.ict.wjbooks_kakao.security.dto.MemberSecurityDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(@Param("email") String username) throws UsernameNotFoundException {

        // 파라메터로 입력된 값의 email 을 db에서 조회해서 가져오기
        Optional<Member> result = memberRepository.getWithRole(username);
        if (result.isEmpty()) { //해당 아이디를 가진 사용자가 없다면
            throw new UsernameNotFoundException("username not found...");
        }
        // db에서 일치하는 회원의 정보를 찾았다면 securityDTO에 담기
        Member member = result.get();
        MemberSecurityDTO memberSecurityDTO =
                new MemberSecurityDTO(
                        member.getMemEmail(),
                        member.getMemPass(),
                        member.getMemName(),
                        member.getMemTel(),
                        member.getMemAdr1(),
                        member.getMemAdr2(),
                        member.getMemAdr3(),
                        member.isDel(),
                        false,
                        member.getRoleSet()
                                .stream().map(memberRole -> new SimpleGrantedAuthority("ROLE_" + memberRole.name()))
                                .collect(Collectors.toList())
                );

        log.info("memberSecurityDTO");
        log.info(memberSecurityDTO);

        return memberSecurityDTO;
    }

}

