package net.ict.wjbooks_kakao.service;

import net.ict.wjbooks_kakao.constant.Role;
import net.ict.wjbooks_kakao.domain.Member;
import net.ict.wjbooks_kakao.dto.MemberFormDto;


public interface MemberService {

    void join(MemberFormDto memberFormDto);

    MemberFormDto read(String email);

    void modify(MemberFormDto memberFormDto);
//    void modiSe(MemberSecurityDTO memberSecurityDTO);

    default Member dtoToEntity(MemberFormDto memberFormDto){
        Member member = Member.builder()
                .memEmail(memberFormDto.getMemEmail())
                .memPass(memberFormDto.getMemPass())   //passwordencoder 어떡할거임 ?
                .memName(memberFormDto.getMemName())
                .memTel(memberFormDto.getMemTel())
                .memAdr1(memberFormDto.getMemAdr1())
                .memAdr2(memberFormDto.getMemAdr2())
                .memAdr3(memberFormDto.getMemAdr3())
                .role(Role.USER)
                .build();

        return member;
    }

    default MemberFormDto entityToDTO(Member member){
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setNum(member.getMemNum());
        memberFormDto.setMemName(member.getMemName());
        memberFormDto.setMemEmail(member.getMemEmail());
        memberFormDto.setMemPass(member.getMemPass());
        memberFormDto.setMemTel(member.getMemTel());
        memberFormDto.setMemAdr1(member.getMemAdr1());
        memberFormDto.setMemAdr2(member.getMemAdr2());
        memberFormDto.setMemAdr3(member.getMemAdr3());
        return memberFormDto;
    }

    void remove(String email);
}
