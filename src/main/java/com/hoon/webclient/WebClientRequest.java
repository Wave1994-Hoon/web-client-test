package com.hoon.webclient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WebClientRequest {

    private final WebClientWrapper webClientWrapper;

    public String requestTest() {
        return webClientWrapper.get()
                .uri("http://localhost:8080/test")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
