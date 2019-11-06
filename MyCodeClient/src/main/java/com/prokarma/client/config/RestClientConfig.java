package com.prokarma.client.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;

import com.nimbusds.oauth2.sdk.util.CollectionUtils;

@Configuration
public class RestClientConfig {
 /*
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
 
        List<ClientHttpRequestInterceptor> interceptors
          = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new AuthorizationHeaderInterceptor(OAuth2AuthorizedClientService clientService)));
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
    */
}
