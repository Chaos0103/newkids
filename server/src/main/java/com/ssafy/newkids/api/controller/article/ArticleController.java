package com.ssafy.newkids.api.controller.article;

import com.ssafy.newkids.api.ApiResponse;
import com.ssafy.newkids.api.controller.article.response.ArticleDetailResponse;
import com.ssafy.newkids.api.controller.article.response.ArticleResponse;
import com.ssafy.newkids.api.service.article.ArticleQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 기사 API 컨트롤러
 *
 * @author 임우택
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleQueryService articleQueryService;

    // TODO: 2023-09-07 임우택 기사 목록 조회 API
    @GetMapping
    public ApiResponse<Page<ArticleResponse>> getArticles(
        @RequestParam String keyword,
        @RequestParam String term,
        @RequestParam(defaultValue = "1") Integer pageNum
    ) {
        PageRequest pageRequest = PageRequest.of(pageNum - 1, 20);
        Page<ArticleResponse> responses = articleQueryService.getArticles(keyword, term, pageRequest);
        return ApiResponse.ok(responses);
    }

    // TODO: 2023-09-07 임우택 기사 상세 조회 API
    @GetMapping("/{articleId}")
    public ApiResponse<ArticleDetailResponse> getArticle(@PathVariable Long articleId) {
        ArticleDetailResponse response = articleQueryService.getArticle(articleId);
        return ApiResponse.ok(response);
    }
}
