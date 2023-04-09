package com.ipap.springcopilottest.config;

import org.springframework.boot.test.web.client.MockServerRestTemplateCustomizer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TestConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder(new MockServerRestTemplateCustomizer()).build();
    }

    @Bean
    public MockRestServiceServer mockServer(RestTemplate restTemplate) {
        return MockRestServiceServer.createServer(restTemplate);
    }
}
