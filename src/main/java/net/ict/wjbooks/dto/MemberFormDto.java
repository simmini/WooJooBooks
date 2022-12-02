package net.ict.wjbooks.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class MemberFormDto { //가입정보,빈 유효성 검사 추가

    @NotEmpty(message="이메일은 필수 입력 값입니다.")//길이 0인지,빈문자열인지
    @Email(message="이메일형식으로 입력해주세요.")//이메일 형식인지
    @Column(name="m_email",nullable = false)
    private String email;

    @NotBlank(message="이름은 필수 입력값입니다.") //길이 0인지
    @Column(name="m_name",nullable = false)
    private String name;



    @NotEmpty(message="비밀번호는 필수 입력값입니다.")
    @Length(min=8,max=16,message="비밀번호는 8자 이상,16자 이하로 입력해주세요")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    @Column(name="m_pass",nullable = false)
    private String password;


    @NotEmpty(message = "전화번호는 필수 입력값입니다.")
    @Column(name="m_tel",nullable = false)
    @Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$", message = "10 ~ 11 자리의 숫자만 입력 가능합니다.")
    private String tellPhone;


    @NotEmpty(message = "주소는 필수 입력값입니다.")
    @Column(name="m_address1",nullable = false)
    private String adr1;

    @Column(name="m_address2",nullable = true)
    private String adr2;

    @Column(name="m_address3",nullable = true)
    private String adr3;

    @ColumnDefault("0")
    @Column(name="m_score",nullable = true)
    private Long m_score;





}