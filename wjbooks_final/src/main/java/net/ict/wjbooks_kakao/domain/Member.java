package net.ict.wjbooks_kakao.domain;

import lombok.*;
import net.ict.wjbooks_kakao.constant.Role;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter @Setter
@ToString(exclude = "roleSet")
@DynamicInsert
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memNum;
    // 이메일 형식인지 확인하는 부분 넣어야함
    @Column(name="m_email", unique = true, nullable = false)
    private String memEmail;

    @Column(name = "m_name", nullable = false)
    private String memName;

    @Column(name = "m_pass", nullable = false)
    private String memPass;

    @Column(name = "m_tel", nullable = false)
    private String memTel;

    @Column(name = "m_score")
    @ColumnDefault("0")
    private Long memScore;

    @Column(name = "m_address1", nullable = false)
    private String memAdr1;
    //1202 : 주소값 2번째까지 강제 입력될 수 있게 setting
    @Column(name = "m_address2",nullable = false)
    private String memAdr2;

    @Column(name = "m_address3", nullable = true)
    private String memAdr3;

    private boolean del;        // 계정 탈퇴 여부
    private boolean social;     // 카카오 로그인

    @Enumerated(EnumType.STRING)
    private Role role;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Role> roleSet = new HashSet<>();

    public void addRole(Role role){this.roleSet.add(role);}

    public void change(String memPass,String memAdr1,String memAdr2,String memAdr3){
        this.memPass=memPass;
        this.memAdr1=memAdr1;
        this.memAdr2=memAdr2;
        this.memAdr3=memAdr3;
    }
}
