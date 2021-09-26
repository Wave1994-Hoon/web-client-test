package com.hoon.webclient.service;

import com.hoon.webclient.service.WebClientNotWrapperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class WebClientNotWrapperServiceTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    WebClient webClient;

    @Mock(answer = Answers.RETURNS_SELF)
    WebClient.Builder builder;

    @InjectMocks
    WebClientNotWrapperService service;

    @BeforeEach
    void setUp() {
        given(builder.build()).willReturn(webClient);
        service = new WebClientNotWrapperService(builder);
    }

    @Test
    @DisplayName("WebClient_builder_객체_테스트")
    void requestTest() {
        // given
        given(webClient.get()
                .uri("http://localhost:8080/test")
                .retrieve()
                .bodyToMono(String.class)
                .block()
        ).willReturn("ok");

        // when
        String result = service.request();

        // then
        assertThat(result).isEqualTo("ok");

    }

}