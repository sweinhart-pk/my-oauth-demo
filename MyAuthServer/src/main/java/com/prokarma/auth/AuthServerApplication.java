package com.prokarma.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
public class AuthServerApplication {
    
    public static void main(String... args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

}
