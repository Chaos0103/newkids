package com.ssafy.newkids.docs.member;

import com.ssafy.newkids.api.controller.member.MemberController;
import com.ssafy.newkids.api.controller.member.request.JoinRequest;
import com.ssafy.newkids.api.controller.member.request.WithdrawalRequest;
import com.ssafy.newkids.api.controller.member.response.JoinMemberResponse;
import com.ssafy.newkids.api.service.member.MemberService;
import com.ssafy.newkids.api.service.member.dto.JoinMemberDto;
import com.ssafy.newkids.docs.RestDocsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MemberControllerDocsTest extends RestDocsSupport {

    private final MemberService memberService = mock(MemberService.class);

    @Override
    protected Object initController() {
        return new MemberController(memberService);
    }

    @DisplayName("회원 가입 API")
    @Test
    void join() throws Exception {
        JoinRequest request = JoinRequest.builder()
            .email("ssafy@ssafy.com")
            .password("ssafy1234!")
            .name("김싸피")
            .age(10)
            .nickname("광주C205")
            .build();

        JoinMemberResponse response = JoinMemberResponse.builder()
            .email("ssafy@ssafy.com")
            .name("김싸피")
            .age(10)
            .nickname("광주C205")
            .build();

        given(memberService.join(any(JoinMemberDto.class)))
            .willReturn(response);

        mockMvc.perform(
                post("/join")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("create-member",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("email").type(JsonFieldType.STRING)
                        .description("계정 이메일"),
                    fieldWithPath("password").type(JsonFieldType.STRING)
                        .description("계정 비밀번호"),
                    fieldWithPath("name").type(JsonFieldType.STRING)
                        .description("이름"),
                    fieldWithPath("age").type(JsonFieldType.NUMBER)
                        .description("나이"),
                    fieldWithPath("nickname").type(JsonFieldType.STRING)
                        .description("닉네임")
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
                    fieldWithPath("data.email").type(JsonFieldType.STRING)
                        .description("계정 이메일"),
                    fieldWithPath("data.name").type(JsonFieldType.STRING)
                        .description("이름"),
                    fieldWithPath("data.age").type(JsonFieldType.NUMBER)
                        .description("나이"),
                    fieldWithPath("data.nickname").type(JsonFieldType.STRING)
                        .description("닉네임")
                )
            ));
    }

    @DisplayName("회원 탈퇴 API")
    @Test
    void withdrawal() throws Exception {
        WithdrawalRequest request = WithdrawalRequest.builder()
            .password("ssafy1234!")
            .build();

        given(memberService.withdrawal(anyString(), anyString()))
            .willReturn(true);

        mockMvc.perform(
                delete("/withdrawal")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("remove-member",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
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
                    fieldWithPath("data").type(JsonFieldType.BOOLEAN)
                        .description("중복 여부(true: 사용불가, false: 사용가능)")
                )
            ));
    }
}
