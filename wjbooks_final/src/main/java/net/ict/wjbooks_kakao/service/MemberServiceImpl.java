package net.ict.wjbooks_kakao.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.wjbooks_kakao.domain.Member;
import net.ict.wjbooks_kakao.dto.MemberFormDto;
import net.ict.wjbooks_kakao.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor        // 생성자 주입방식;
@Log4j2
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void join(MemberFormDto memberFormDto)  {

        Optional<Member> findMemberEmail=memberRepository.findByMemEmail(memberFormDto.getMemEmail());
        log.info(findMemberEmail);
        if(findMemberEmail.isPresent()){//이메일 있으면
            throw new IllegalStateException("이미 등록된 이메일 입니다. 다른 이메일을 이용해주세요");
        }

        memberFormDto.setMemPass(passwordEncoder.encode(memberFormDto.getMemPass()));
        Member member = dtoToEntity(memberFormDto);
        memberRepository.save(member);
    }

    @Override
    public MemberFormDto read(String email) {
        Optional<Member> findMemberEmail=memberRepository.findByMemEmail(email);
        log.info(findMemberEmail);//이메일로 조회한 member에 모든값을 가져옴
        Member member=findMemberEmail.orElseThrow();//에러처리
        MemberFormDto memberFormDto=entityToDTO(member);
        log.info(memberFormDto);

        return memberFormDto;
    }

    @Override
    public void modify(MemberFormDto memberFormDto) {
        Optional<Member> findMemberForModify = memberRepository.findByMemEmail(memberFormDto.getMemEmail());

        Member member = findMemberForModify.orElseThrow();
        memberFormDto.setMemPass(passwordEncoder.encode(memberFormDto.getMemPass()));
        member.change(memberFormDto.getMemPass(), memberFormDto.getMemAdr1(), memberFormDto.getMemAdr2(), memberFormDto.getMemAdr3());
        memberRepository.save(member);
    }

    @Override
    public void remove(String email) {
        memberRepository.deleteByMemEmail(email);
    }


}
