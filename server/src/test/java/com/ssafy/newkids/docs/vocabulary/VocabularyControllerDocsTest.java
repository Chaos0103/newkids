package com.ssafy.newkids.docs.vocabulary;

import com.ssafy.newkids.api.controller.vocabulary.VocabularyController;
import com.ssafy.newkids.api.controller.vocabulary.response.VocabularyResponse;
import com.ssafy.newkids.api.service.vocabulary.VocabularyService;
import com.ssafy.newkids.docs.RestDocsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VocabularyControllerDocsTest extends RestDocsSupport {

    private final VocabularyService vocabularyService = mock(VocabularyService.class);

    @Override
    protected Object initController() {
        return new VocabularyController(vocabularyService);
    }

    @DisplayName("단어장 등록 API")
    @Test
    void createVocabulary() throws Exception {
        VocabularyResponse response = VocabularyResponse.builder()
            .wordKey("92288")
            .word("돼지")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .check(false)
            .build();

        given(vocabularyService.createVocabulary(anyString(), anyLong()))
            .willReturn(response);

        mockMvc.perform(
                post("/vocabulary/{wordId}", 1L)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isCreated())
            .andDo(document("create-vocabulary",
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
                    fieldWithPath("data.wordKey").type(JsonFieldType.STRING)
                        .description("단어키"),
                    fieldWithPath("data.word").type(JsonFieldType.STRING)
                        .description("단어"),
                    fieldWithPath("data.description").type(JsonFieldType.STRING)
                        .description("단어설명"),
                    fieldWithPath("data.check").type(JsonFieldType.BOOLEAN)
                        .description("단어체크여부(체크: true, 미체크: false)")
                )
            ));
    }

    @DisplayName("단어장 체크 API")
    @Test
    void checkVocabulary() throws Exception {
        VocabularyResponse response = VocabularyResponse.builder()
            .wordKey("92288")
            .word("돼지")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .check(true)
            .build();

        given(vocabularyService.checkVocabulary(anyLong()))
            .willReturn(response);

        mockMvc.perform(
                patch("/vocabulary/{vocabularyId}", 1L)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isFound())
            .andDo(document("check-vocabulary",
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
                    fieldWithPath("data.wordKey").type(JsonFieldType.STRING)
                        .description("단어키"),
                    fieldWithPath("data.word").type(JsonFieldType.STRING)
                        .description("단어"),
                    fieldWithPath("data.description").type(JsonFieldType.STRING)
                        .description("단어설명"),
                    fieldWithPath("data.check").type(JsonFieldType.BOOLEAN)
                        .description("단어체크여부(체크: true, 미체크: false)")
                )
            ));
    }

    @DisplayName("단어장 삭제 API")
    @Test
    void removeVocabulary() throws Exception {
        VocabularyResponse response = VocabularyResponse.builder()
            .wordKey("92288")
            .word("돼지")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .check(true)
            .build();

        given(vocabularyService.removeVocabulary(anyLong()))
            .willReturn(response);

        mockMvc.perform(
                delete("/vocabulary/{vocabularyId}", 1L)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isFound())
            .andDo(document("remove-vocabulary",
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
                    fieldWithPath("data.wordKey").type(JsonFieldType.STRING)
                        .description("단어키"),
                    fieldWithPath("data.word").type(JsonFieldType.STRING)
                        .description("단어"),
                    fieldWithPath("data.description").type(JsonFieldType.STRING)
                        .description("단어설명"),
                    fieldWithPath("data.check").type(JsonFieldType.BOOLEAN)
                        .description("단어체크여부(체크: true, 미체크: false)")
                )
            ));
    }
}
