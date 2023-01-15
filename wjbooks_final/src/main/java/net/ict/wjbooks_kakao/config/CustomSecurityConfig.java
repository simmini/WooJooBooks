package net.ict.wjbooks_kakao.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.wjbooks_kakao.security.CustomUserDetailsService;
import net.ict.wjbooks_kakao.security.handler.Custom403Handler;
import net.ict.wjbooks_kakao.security.handler.CustomSocialLoginSuccessHandler;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Log4j2
@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class CustomSecurityConfig {

    private final DataSource dataSource;
    private final CustomUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomSocialLoginSuccessHandler(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        log.info("------------configure-------------------");

        //인증을 요구하는 페이지를 커스텀 로그인 페이지로 연동
        http.formLogin().loginPage("/member/login")
                .defaultSuccessUrl("/sellboard/main")
                .usernameParameter("email")     // 로그인 시 username 으로 이용할 id setting
                .failureUrl("/member/login/error")

                // 로그아웃 시에 세션 쿠키, 자동로그인 쿠키 삭제, 이동경로
                        .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/sellboard/main")
                .deleteCookies("JSESSIONID","remember-me")

                // 자동로그인 setting
                        .and()
                .rememberMe()
                .key("key")
                .userDetailsService(userDetailsService)
//                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60*60*24*30);

        http.authorizeRequests()    // 메인 인증 없이 들어갈 수 있어야함
                .mvcMatchers("/sellboard/main","/sellboard/list","/member/new","/member/login").permitAll()
                // admin page는 관리자만
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                // 그외 나머지 페이지는 인증된 사람만, 인증안됐으면 로그인 요청하기
                .anyRequest().authenticated();
        //CSRF 토큰 비활성화
        http.csrf().disable();


        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler()); //403

        http.oauth2Login().loginPage("/member/login").successHandler(authenticationSuccessHandler());

        return http.build();
    }
        //영구 토큰
//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
//        repo.setDataSource(dataSource);
//        return repo;
//    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new Custom403Handler();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {  // 정적 자원 인증 무시
        log.info("------------web configure-------------------");
        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());

    }


}
