package net.ict.wjbooks_kakao.dto;

import lombok.Getter;
import lombok.Setter;
import net.ict.wjbooks_kakao.constant.Role;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

// 얘가 memberjoinDTO class랑 같음.
// 순수 회원가입에 관련된 DTO
@Getter
@Setter
public class MemberFormDto { //가입정보,빈 유효성 검사 추가


    private Long num;

    @NotEmpty(message="이메일은 필수 입력 값입니다.")//길이 0인지,빈문자열인지
    @Email(message="이메일형식으로 입력해주세요.")//이메일 형식인지
    private String memEmail;

    @NotBlank(message="이름은 필수 입력값입니다.") //길이 0인지
    private String memName;



    @NotEmpty(message="비밀번호는 필수 입력값입니다.")
    @Length(min=8,max=16,message="비밀번호는 8자 이상,16자 이하로 입력해주세요")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")

    private String memPass;


    @NotEmpty(message = "전화번호는 필수 입력값입니다.")
    @Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$", message = "10 ~ 11 자리의 숫자만 입력 가능합니다.")
    private String memTel;


    @NotEmpty(message = "주소1은 필수 입력값입니다.")
    private String memAdr1;

    @NotEmpty(message = "주소2은 필수 입력값입니다.")
    private String memAdr2;


    private String memAdr3;


    private Long memScore;


    private Role role;


}