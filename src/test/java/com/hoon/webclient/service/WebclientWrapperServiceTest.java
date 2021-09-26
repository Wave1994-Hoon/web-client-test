package com.hoon.webclient.service;

import com.hoon.webclient.WebClientWrapper;
import com.hoon.webclient.service.WebclientWrapperService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class WebclientWrapperServiceTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    WebClientWrapper webClientWrapper;

    @InjectMocks
    WebclientWrapperService service;

    @Test
    @DisplayName("WebClient_wrapper_객체_테스트")
    void requestTest() {
        // given
        given(webClientWrapper.get()
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