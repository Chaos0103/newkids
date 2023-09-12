package com.ssafy.articleservicce.api.controller.article;

import com.ssafy.articleservicce.api.controller.ApiResponse;
import com.ssafy.articleservicce.api.controller.article.request.CreateArticleRequest;
import com.ssafy.articleservicce.api.controller.article.response.ArticleDetailResponse;
import com.ssafy.articleservicce.api.controller.article.response.ArticleResponse;
import com.ssafy.articleservicce.api.service.article.ArticleQueryService;
import com.ssafy.articleservicce.api.service.article.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/article-service")
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleQueryService articleQueryService;

    // TODO: 2023/09/13 뉴스 기사 등록 API
    @PostMapping
    public ApiResponse<ArticleResponse> createArticle(@Valid @RequestBody CreateArticleRequest request) {
        return ApiResponse.created(null);
    }

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

    // TODO: 2023/09/13 뉴스 기사 수정 API
    @PatchMapping("/{articleId}")
    public ApiResponse<ArticleResponse> editArticle(@PathVariable Long articleId) {
        return ApiResponse.found(null);
    }

    // TODO: 2023/09/13 뉴스 기사 삭제 API
    @DeleteMapping("/{articleId}")
    public ApiResponse<ArticleResponse> removeArticle(@PathVariable Long articleId) {
        return ApiResponse.found(null);
    }
}
