package com.prokarma.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
public class FrontEndApplication {
    
    public static void main(String... args) {
        SpringApplication.run(FrontEndApplication.class, args);
    }

}
