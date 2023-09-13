package com.ssafy.articleservice.api.controller.article;

import com.ssafy.articleservice.api.controller.ApiResponse;
import com.ssafy.articleservice.api.controller.article.response.ArticleDetailResponse;
import com.ssafy.articleservice.api.controller.article.response.ArticleResponse;
import com.ssafy.articleservice.api.service.article.ArticleQueryService;
import com.ssafy.articleservice.api.service.article.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/article-service")
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleQueryService articleQueryService;

    // TODO: 2023/09/13 뉴스 기사 조회 API
    @GetMapping
    public ApiResponse<Page<ArticleResponse>> getArticles() {
        return ApiResponse.ok(null);
    }

    // TODO: 2023/09/13 뉴스 기사 상세 조회 API
    @GetMapping("/{articleId}")
    public ApiResponse<ArticleDetailResponse> getArticle(@PathVariable Long articleId) {
        return ApiResponse.ok(null);
    }

    // TODO: 2023/09/13 뉴스 기사 삭제 API
    @DeleteMapping("/{articleId}")
    public ApiResponse<ArticleResponse> removeArticle(@PathVariable Long articleId) {
        return ApiResponse.found(null);
    }
}
