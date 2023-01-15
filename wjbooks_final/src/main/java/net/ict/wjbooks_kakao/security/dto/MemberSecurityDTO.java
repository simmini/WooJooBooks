package net.ict.wjbooks_kakao.security.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Getter
@Setter
@ToString
public class MemberSecurityDTO extends User implements OAuth2User {

    private String memEmail;
    private String memPass;
    private String memName;
    private boolean del;
    private boolean social;

    private String memTel;
    private String memAdr1;
    private String memAdr2;
    private String memAdr3;

    private Map<String, Object> props; //소셜 로그인 정보

    public MemberSecurityDTO(String username, String password, String name, String tel, String adr1, String adr2, String adr3, boolean del, boolean social,
                             Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);

        this.memEmail = username;
        this.memPass = password;
        this.memName = name;
        this.memTel = tel;
        this.memAdr1 = adr1;
        this.memAdr2 = adr2;
        this.memAdr3 = adr3;
        this.del = del;
        this.social = social;
    }

    public Map<String, Object> getAttributes() {
        return this.getProps();
    }

    @Override
    public String getName() {
        //원래 있떤거
//        return this.memName;
    // session 유지를 위해 email 값 저장
        return this.memEmail;
    }

}
