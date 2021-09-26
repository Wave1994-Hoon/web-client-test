package com.hoon.webclient.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientNotWrapperService {

    private final WebClient webClient;

    public WebClientNotWrapperService(WebClient.Builder builder) {
        webClient = builder.build();
    }

    public String request() {
        return webClient.get()
                .uri("http://localhost:8080/test")
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }
}
