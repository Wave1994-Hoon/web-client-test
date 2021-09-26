package com.hoon.webclient.service;

import com.hoon.webclient.WebClientWrapper;
import org.springframework.stereotype.Service;


@Service
public class WebclientWrapperService {

    private final WebClientWrapper webClientWrapper;

    public WebclientWrapperService(WebClientWrapper client) {
        this.webClientWrapper = client;
    }

    public String request() {
        return webClientWrapper.get()
                .uri("http://localhost:8080/test")
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }

}
