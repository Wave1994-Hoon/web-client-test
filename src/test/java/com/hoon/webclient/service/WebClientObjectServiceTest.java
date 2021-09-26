package com.hoon.webclient.service;

import com.hoon.webclient.WebClientRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class WebClientObjectServiceTest {

    @Mock
    WebClientRequest webClientRequest;

    @InjectMocks
    WebClientObjectService service;

    @Test
    void request() {
        // given
        given(webClientRequest.requestTest())
                .willReturn("ok");

        // when
        String result = service.request();

        // then
        assertThat(result).isEqualTo("ok");
    }
}