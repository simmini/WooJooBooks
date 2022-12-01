package net.ict.wjbooks.service;

import lombok.RequiredArgsConstructor;
import net.ict.wjbooks.domain.Member;
import net.ict.wjbooks.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor        // 생성자 주입방식
public class MemberService {

    private final MemberRepository memberRepository;

    // DB에 중복된 이메일 있는지 검증
    private void validateMember(Member member){
        Member findMemberEmail = memberRepository.findByEmail(member.getEmail());
        if(findMemberEmail != null){
            throw new IllegalStateException("이미 등록된 이메일 입니다. 다른 이메일을 이용해주세요");
        }
    }
    // 상기 검증 메소드를 거친 후 중복되지 않음이 확인되면 멤버를 db에 저장
    public Member saveMember(Member member){
        validateMember(member);
        return memberRepository.save(member);
    }


}
