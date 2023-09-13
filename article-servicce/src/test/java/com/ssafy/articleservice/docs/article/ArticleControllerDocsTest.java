package com.ssafy.articleservice.docs.article;

import com.ssafy.articleservice.api.controller.article.ArticleController;
import com.ssafy.articleservice.api.controller.article.response.ArticleDetailResponse;
import com.ssafy.articleservice.api.service.article.ArticleQueryService;
import com.ssafy.articleservice.api.service.article.ArticleService;
import com.ssafy.articleservice.docs.RestDocsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.restdocs.payload.JsonFieldType;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ArticleControllerDocsTest extends RestDocsSupport {

    private final ArticleService articleService = mock(ArticleService.class);
    private final ArticleQueryService articleQueryService = mock(ArticleQueryService.class);

    @Override
    protected Object initController() {
        return new ArticleController(articleService, articleQueryService);
    }

    @DisplayName("뉴스 기사 조회 API")
    @Test
    void getArticles() throws Exception {

    }

    @DisplayName("뉴스 기사 단건 조회 API")
    @Test
    void getArticle() throws Exception {
        ArticleDetailResponse response = ArticleDetailResponse.builder()
            .build();
        // TODO: 2023-09-13 작성중
        mockMvc.perform(
                get("/article-service/{articleId}", UUID.randomUUID().toString())
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("search-detail-article",
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
                    fieldWithPath("data.content").type(JsonFieldType.ARRAY)
                        .description("낙찰 내역 데이터")
                )
            ));
    }

    @DisplayName("뉴스 기사 삭제 API")
    @Test
    void removeArticle() throws Exception {

    }
}
