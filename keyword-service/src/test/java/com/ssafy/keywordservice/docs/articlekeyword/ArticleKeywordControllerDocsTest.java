package com.ssafy.keywordservice.docs.articlekeyword;

import com.ssafy.keywordservice.api.controller.articlekeyword.ArticleKeywordController;
import com.ssafy.keywordservice.docs.RestDocsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

import java.util.UUID;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ArticleKeywordControllerDocsTest extends RestDocsSupport {

    @Override
    protected Object initController() {
        return new ArticleKeywordController();
    }

    @DisplayName("뉴스 키워드 등록 API")
    @Test
    void createArticleKeyword() throws Exception {

        String request = null;

        mockMvc.perform(
                post("/keyword-service/{articleKey}/article")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isCreated())
            .andDo(document("create-article-keyword",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("word").type(JsonFieldType.STRING)
                        .optional()
                        .description("등록할 단어")
                ),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.STRING)
                        .description("등록된 키워드 단어")
                )
            ));
    }

    @DisplayName("뉴스 키워드 조회 API")
    @Test
    void searchArticleKeyword() throws Exception {
        String memberKey = UUID.randomUUID().toString();


        mockMvc.perform(
                get("/keyword-service/{articleKey}/article", memberKey)
            )
            .andDo(print())
            .andExpect(status().isCreated())
            .andDo(document("create-article-keyword",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("word").type(JsonFieldType.STRING)
                        .optional()
                        .description("등록할 단어")
                ),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.STRING)
                        .description("등록된 키워드 단어")
                )
            ));
    }
}
