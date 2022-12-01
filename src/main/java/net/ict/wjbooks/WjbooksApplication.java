package net.ict.wjbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WjbooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjbooksApplication.class, args);
    }

}
