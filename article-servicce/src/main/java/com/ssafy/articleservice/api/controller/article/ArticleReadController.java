package com.ssafy.articleservice.api.controller.article;

import com.ssafy.articleservice.api.controller.ApiResponse;
import com.ssafy.articleservice.api.controller.article.request.CreateArticleReadRequest;
import com.ssafy.articleservice.api.controller.article.response.ArticleReadResponse;
import com.ssafy.articleservice.api.service.articleread.ArticleReadQueryService;
import com.ssafy.articleservice.api.service.articleread.ArticleReadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/article-service/read")
public class ArticleReadController {

    private final ArticleReadService articleReadService;
    private final ArticleReadQueryService articleReadQueryService;

    // TODO: 2023/09/13 읽은 뉴스 기사 목록 등록 API
    @PostMapping("/{memberKey}")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ArticleReadResponse> createArticleRead(@PathVariable String memberKey, @Valid @RequestBody CreateArticleReadRequest request) {
        ArticleReadResponse response = articleReadService.createArticleRead(memberKey, request.getArticleId());
        return ApiResponse.created(response);
    }

    // TODO: 2023/09/13 읽은 뉴스 기사 목록 조회 API
    @GetMapping("/{memberKey}")
    public ApiResponse<Page<ArticleReadResponse>> getArticleRead(@PathVariable String memberKey) {
        Page<ArticleReadResponse> response = articleReadQueryService.getMyArticleRead(memberKey);
        return ApiResponse.ok(response);
    }

    // TODO: 2023/09/13 읽은 뉴스 기사 목록 삭제 API
    @DeleteMapping("/{articleReadId}")
    @ResponseStatus(HttpStatus.FOUND)
    public ApiResponse<?> removeArticleRead(@PathVariable Long articleReadId) {
        articleReadService.removeArticleRead(articleReadId);
        return ApiResponse.found(null);
    }
}
