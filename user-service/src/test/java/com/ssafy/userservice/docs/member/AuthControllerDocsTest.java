package com.ssafy.userservice.docs.member;

import com.ssafy.userservice.api.controller.member.AuthController;
import com.ssafy.userservice.api.controller.member.request.CheckEmailRequest;
import com.ssafy.userservice.api.controller.member.request.CheckNicknameRequest;
import com.ssafy.userservice.api.service.member.AuthService;
import com.ssafy.userservice.docs.RestDocsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthControllerDocsTest extends RestDocsSupport {

    private final AuthService authService = mock(AuthService.class);

    @Override
    protected Object initController() {
        return new AuthController(authService);
    }

    @DisplayName("이메일 중복 체크 API")
    @Test
    void checkEmail() throws Exception {
        CheckEmailRequest request = CheckEmailRequest.builder()
            .email("ssafy@ssafy.com")
            .build();

        given(authService.checkEmail(anyString()))
            .willReturn(true);

        mockMvc.perform(
                post("/auth/email")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("auth-email",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("email").type(JsonFieldType.STRING)
                        .optional()
                        .description("중복 확인 이메일")
                ),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.BOOLEAN)
                        .description("중복 여부(true: 사용불가, false: 사용가능)")
                )
            ));
    }

    @DisplayName("닉네임 중복 체크 API")
    @Test
    void checkNickname() throws Exception {
        CheckNicknameRequest request = CheckNicknameRequest.builder()
            .nickname("광주C205")
            .build();

        given(authService.checkNickname(anyString()))
            .willReturn(true);

        mockMvc.perform(
                post("/auth/nickname")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("auth-nickname",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("nickname").type(JsonFieldType.STRING)
                        .optional()
                        .description("중복 확인 닉네임")
                ),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.BOOLEAN)
                        .description("중복 여부(true: 사용불가, false: 사용가능)")
                )
            ));
    }
}
