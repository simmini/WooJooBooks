package net.ict.wjbooks.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.ict.wjbooks.constant.Role;
import net.ict.wjbooks.dto.MemberFormDto;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
@ToString
@DynamicInsert
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long m_num;
    // 이메일 형식인지 확인하는 부분 넣어야함
    @Column(name="m_email", unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String m_name;

    @Column(nullable = false)
    private String m_pass;

    @Column(nullable = false)
    private String m_tel;

    @ColumnDefault("0")
    private Long m_score;

    @Column(nullable = false)
    private String m_address1;

    @Column(nullable = true)
    private String m_address2;

    @Column(nullable = true)
    private String m_address3;

    @Enumerated(EnumType.STRING)
    private Role role;

//    member 생성코드
    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setEmail(memberFormDto.getEmail());
        member.setM_name(memberFormDto.getName());
        member.setM_address1(memberFormDto.getAdr1());
        member.setM_address2(memberFormDto.getAdr2());
        member.setM_address3(memberFormDto.getAdr3());
        member.setM_pass(passwordEncoder.encode(memberFormDto.getPassword()));
        member.setM_tel(memberFormDto.getTellPhone());
        return member;
    }
}
