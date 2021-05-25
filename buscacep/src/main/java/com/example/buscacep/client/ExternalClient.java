package com.example.buscacep.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component  
public class ExternalClient {

    @Value("${external-client.uri}")
    public String baseUrl;

    private WebClient webClient;

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl(baseUrl).build();
        return this.webClient;
    }

    public WebClient getInstance(){
        return this.webClient;
    }

}
