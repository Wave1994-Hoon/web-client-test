package com.hoon.webclient.controller;

import com.hoon.webclient.service.WebclientWrapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebClientController {

    private final WebclientWrapperService webclientService;

    @GetMapping("/webClient")
    public ResponseEntity<String> webClientTest() {
        return ResponseEntity.ok().body(webclientService.request());
    }
}
