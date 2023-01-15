package net.ict.wjbooks_kakao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.security.Security;

@SpringBootApplication
@EnableJpaAuditing
public class WjbooksKakaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjbooksKakaoApplication.class, args);
    }

}
