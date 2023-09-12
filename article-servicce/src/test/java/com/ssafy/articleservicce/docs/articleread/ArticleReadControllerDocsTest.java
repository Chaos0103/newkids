package com.ssafy.articleservicce.docs.articleread;

import com.ssafy.articleservicce.api.controller.article.ArticleReadController;
import com.ssafy.articleservicce.api.service.articleread.ArticleReadQueryService;
import com.ssafy.articleservicce.api.service.articleread.ArticleReadService;
import com.ssafy.articleservicce.docs.RestDocsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class ArticleReadControllerDocsTest extends RestDocsSupport {

    private final ArticleReadService articleReadService = mock(ArticleReadService.class);
    private final ArticleReadQueryService articleReadQueryService = mock(ArticleReadQueryService.class);

    @Override
    protected Object initController() {
        return new ArticleReadController(articleReadService, articleReadQueryService);
    }

    @DisplayName("읽은 뉴스 기사 목록 등록 API")
    @Test
    void createArticleRead() throws Exception {

    }

    @DisplayName("읽은 뉴스 기사 목록 조회 API")
    @Test
    void getArticleRead() throws Exception {

    }

    @DisplayName("읽은 뉴스 기사 목록 삭제 API")
    @Test
    void removeArticleRead() throws Exception {

    }
}
