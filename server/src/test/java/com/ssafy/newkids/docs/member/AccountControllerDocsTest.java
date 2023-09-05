package com.ssafy.newkids.docs.member;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssafy.newkids.api.controller.member.AccountController;
import com.ssafy.newkids.api.controller.member.request.LoginRequest;
import com.ssafy.newkids.api.service.member.AccountService;
import com.ssafy.newkids.docs.RestDocsSupport;
import com.ssafy.newkids.security.TokenInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AccountControllerDocsTest extends RestDocsSupport {

    private final AccountService accountService = mock(AccountService.class);

    @Override
    protected Object initController() {
        return new AccountController(accountService);
    }

    @DisplayName("계정 로그인 API")
    @Test
    void login() throws Exception {
        LoginRequest request= LoginRequest.builder()
            .email("ssafy@ssafy.com")
            .password("ssafy1234!")
            .build();

        TokenInfo token = TokenInfo.builder()
            .grantType("Bearer")
            .accessToken("accessToken")
            .refreshToken("refreshToken")
            .build();

        given(accountService.login(anyString(), anyString()))
            .willReturn(token);

        mockMvc.perform(
                post("/login")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("login-account",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("email").type(JsonFieldType.STRING)
                        .description("계정 이메일"),
                    fieldWithPath("password").type(JsonFieldType.STRING)
                        .description("계정 비밀번호")
                ),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.OBJECT)
                        .description("응답데이터"),
                    fieldWithPath("data.grantType").type(JsonFieldType.STRING)
                        .description("인증권한"),
                    fieldWithPath("data.accessToken").type(JsonFieldType.STRING)
                        .description("access token"),
                    fieldWithPath("data.refreshToken").type(JsonFieldType.STRING)
                        .description("refresh token")
                )
            ));
    }
}
