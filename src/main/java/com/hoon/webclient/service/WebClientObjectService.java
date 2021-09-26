package com.hoon.webclient.service;

import com.hoon.webclient.WebClientRequest;
import org.springframework.stereotype.Service;

@Service
public class WebClientObjectService {

    private final WebClientRequest webClientRequest;

    public WebClientObjectService(WebClientRequest webClientRequest) {
        this.webClientRequest = webClientRequest;
    }

    public String request() {
        return webClientRequest.requestTest();
    }
}
