package com.ssafy.articleservice.docs.article;

import com.ssafy.articleservice.api.controller.article.ArticleController;
import com.ssafy.articleservice.api.controller.article.response.ArticleDetailResponse;
import com.ssafy.articleservice.api.service.article.ArticleQueryService;
import com.ssafy.articleservice.api.service.article.ArticleService;
import com.ssafy.articleservice.docs.RestDocsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.restdocs.payload.JsonFieldType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.*;
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
            .title("")
            .subTitle("")
            .writer("")
            .publishedDate(LocalDateTime.now())
            .content("")
            .thumbnailImg("")
            .imageUrls(List.of(""))
            .build();

        given(articleQueryService.getArticle(anyLong()))
            .willReturn(response);

        mockMvc.perform(
                get("/article-service/{articleId}", 1L)
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
                    fieldWithPath("data.title").type(JsonFieldType.STRING)
                        .description("기사 제목"),
                    fieldWithPath("data.subTitle").type(JsonFieldType.STRING)
                        .description("기사 부제목"),
                    fieldWithPath("data.writer").type(JsonFieldType.STRING)
                        .description("기사 작성자"),
                    fieldWithPath("data.publishedDate").type(JsonFieldType.ARRAY)
                        .description("기사 작성일"),
                    fieldWithPath("data.content").type(JsonFieldType.STRING)
                        .description("기사 내용"),
                    fieldWithPath("data.thumbnailImg").type(JsonFieldType.STRING)
                        .description("기사 썸네일 이미지"),
                    fieldWithPath("data.imageUrls[]").type(JsonFieldType.ARRAY)
                        .description("기사 이미지 리스스")
                )
            ));
    }

    @DisplayName("뉴스 기사 삭제 API")
    @Test
    void removeArticle() throws Exception {

    }
}
