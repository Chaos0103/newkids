package com.ssafy.quizservice.docs.weekly;

import com.ssafy.quizservice.api.controller.quiz.request.CheckAnswerRequest;
import com.ssafy.quizservice.api.controller.weekly.WeeklyController;
import com.ssafy.quizservice.docs.RestDocsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

import java.util.UUID;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WeeklyControllerDocsTest extends RestDocsSupport {

    @Override
    protected Object initController() {
        return new WeeklyController();
    }

    @DisplayName("주간 키워드 퀴즈 시작 등록 API")
    @Test
    void loadingQuiz() throws Exception {
        mockMvc.perform(
                post("/quiz-controller/{memberKey}/weekly/start", UUID.randomUUID().toString())
                    .header("Authorization", "Access Token")
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("start-weekly-quiz",
                preprocessResponse(prettyPrint()),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.STRING)
                        .description("발급 키")
                )
            ));
    }

    @DisplayName("주간 키워드 퀴즈 다음 단어 호출 API")
    @Test
    void nextWord() throws Exception {
        mockMvc.perform(
                post("/quiz-controller/{memberKey}/weekly/next", UUID.randomUUID().toString())
                    .header("Authorization", "Access Token")
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("next-weekly-quiz",
                preprocessResponse(prettyPrint()),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.OBJECT)
                        .description("응답 데이터"),
                    fieldWithPath("data.no").type(JsonFieldType.NUMBER)
                        .description("문항 번호"),
                    fieldWithPath("data.word").type(JsonFieldType.STRING)
                        .description("정답 단어"),
                    fieldWithPath("data.description").type(JsonFieldType.STRING)
                        .description("단어 설명")
                )
            ));
    }

    @DisplayName("주간 키워드 퀴즈 정답 체크 API")
    @Test
    void checkAnswer() throws Exception {
        CheckAnswerRequest request = CheckAnswerRequest.builder()
            .answer("돼지")
            .build();

        mockMvc.perform(
                post("/quiz-controller/{memberKey}/weekly/answer", UUID.randomUUID().toString())
                    .header("Authorization", "Access Token")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("answer-weekly-quiz",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("answer").type(JsonFieldType.STRING)
                        .optional()
                        .description("입력한 정답")
                ),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.BOOLEAN)
                        .description("정답 여부(true: 정답, false: 오답)")
                )
            ));
    }

    @DisplayName("주간 키워드 퀴즈 결과 API")
    @Test
    void resultQuiz() throws Exception {
        mockMvc.perform(
                post("/quiz-controller/{memberKey}/weekly/result", UUID.randomUUID().toString())
                    .header("Authorization", "Access Token")
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("result-weekly-quiz",
                preprocessResponse(prettyPrint()),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.OBJECT)
                        .description("응답 데이터"),
                    fieldWithPath("data.totalScore").type(JsonFieldType.NUMBER)
                        .description("최종 점수"),
                    fieldWithPath("data.rightQuizCount").type(JsonFieldType.NUMBER)
                        .description("총 맞춘 문제 갯수")
                )
            ));
    }
}
