package com.ssafy.articleservice.docs.article;

import com.ssafy.articleservice.api.controller.article.ArticleController;
import com.ssafy.articleservice.api.service.article.ArticleQueryService;
import com.ssafy.articleservice.api.service.article.ArticleService;
import com.ssafy.articleservice.docs.RestDocsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class ArticleControllerDocsTest extends RestDocsSupport {

    private final ArticleService articleService = mock(ArticleService.class);
    private final ArticleQueryService articleQueryService = mock(ArticleQueryService.class);

    @Override
    protected Object initController() {
        return new ArticleController(articleService, articleQueryService);
    }

    @DisplayName("뉴스 기사 등록 API")
    @Test
    void createArticle() throws Exception {

    }

    @DisplayName("뉴스 기사 조회 API")
    @Test
    void getArticles() throws Exception {

    }

    @DisplayName("뉴스 기사 단건 조회 API")
    @Test
    void getArticle() throws Exception {

    }

    @DisplayName("뉴스 기사 수정 API")
    @Test
    void editArticle() throws Exception {

    }

    @DisplayName("뉴스 기사 삭제 API")
    @Test
    void removeArticle() throws Exception {

    }
}
