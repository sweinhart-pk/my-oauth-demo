package com.prokarma.auth.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.prokarma.auth.security.ActiveUserStore;

@Configuration
public class AppConfig {
    // beans

	@Value("${spring.mail.host}")
	private String host;
	
	@Value("${spring.mail.port}")
	private Integer port;
	
	@Value("${spring.mail.protocol}")
	private String protocol;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@Value("${spring.mail.password}")
	private String password;
	
	@Value("${spring.mail.properties.mail.smtp.auth}")
	private String auth;
	
	@Value("${spring.mail.properties.mail.smtp.connectiontimeout}")
	private String connectiontimeout;
	
	@Value("${spring.mail.properties.mail.smtp.timeout}")
	private String timeout;
	
	@Value("${spring.mail.properties.mail.smtp.writetimeout}")
	private String writetimeout;
	
	@Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	private String tlsenable;
	
	@Value("${spring.mail.properties.mail.smtp.starttls.required}")
	private String tlsrequired;
	
    @Bean
    public ActiveUserStore activeUserStore() {
        return new ActiveUserStore();
    }
    
    @Bean
    public JavaMailSender javaMailSender() {
    	Properties props = new Properties();
    	props.put("mail.smtp.auth", auth);
    	props.put("mail.smtp.timeout", timeout);
    	props.put("mail.smtp.writetimeout", writetimeout);
    	props.put("mail.smtp.connectiontimeout", connectiontimeout);
    	props.put("mail.smtp.starttls.enable", tlsenable);
    	props.put("mail.smtp.starttls.required", tlsrequired);
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        javaMailSender.setProtocol(protocol);
        javaMailSender.setJavaMailProperties(props);
        return javaMailSender;
    }
    
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}