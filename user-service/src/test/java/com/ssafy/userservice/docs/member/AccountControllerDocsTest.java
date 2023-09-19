package com.ssafy.userservice.docs.member;

import com.ssafy.userservice.api.controller.member.AccountController;
import com.ssafy.userservice.api.controller.member.request.CheckEmailRequest;
import com.ssafy.userservice.api.controller.member.request.CheckNicknameRequest;
import com.ssafy.userservice.api.controller.member.request.LoginRequest;
import com.ssafy.userservice.api.controller.member.response.MemberResponse;
import com.ssafy.userservice.api.service.member.AccountService;
import com.ssafy.userservice.docs.RestDocsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AccountControllerDocsTest extends RestDocsSupport {

    private final AccountService accountService = mock(AccountService.class);

    @Override
    protected Object initController() {
        return new AccountController(accountService);
    }

    @DisplayName("계정 정보 조회 API")
    @Test
    void getMemberInfo() throws Exception {

        MemberResponse response = MemberResponse.builder()
            .name("김싸피")
            .age(10)
            .level(2)
            .exp(50)
            .nickname("광주")
            .build();

        given(accountService.getMemberInfo(anyString()))
            .willReturn(response);

        mockMvc.perform(
                get("/{memberKey}/info", UUID.randomUUID().toString())
                    .header("Authorization", "Bearer accessToken")
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("search-account",
                preprocessResponse(prettyPrint()),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.OBJECT)
                        .description("응답데이터"),
                    fieldWithPath("data.name").type(JsonFieldType.STRING)
                        .description("이름"),
                    fieldWithPath("data.age").type(JsonFieldType.NUMBER)
                        .description("나이"),
                    fieldWithPath("data.level").type(JsonFieldType.NUMBER)
                        .description("레벨"),
                    fieldWithPath("data.exp").type(JsonFieldType.NUMBER)
                        .description("경험치"),
                    fieldWithPath("data.nickname").type(JsonFieldType.STRING)
                        .description("닉네임")
                )
            ));
    }

    @DisplayName("이메일 중복 체크 API")
    @Test
    void checkEmail() throws Exception {
        CheckEmailRequest request = CheckEmailRequest.builder()
            .email("ssafy@ssafy.com")
            .build();

        given(accountService.checkEmail(anyString()))
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

        given(accountService.checkNickname(anyString()))
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
