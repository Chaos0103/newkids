package com.ssafy.articleservicce.api.controller.article;

import com.ssafy.articleservicce.api.controller.ApiResponse;
import com.ssafy.articleservicce.api.service.articleread.ArticleReadQueryService;
import com.ssafy.articleservicce.api.service.articleread.ArticleReadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/article-service/read")
public class ArticleReadController {

    private final ArticleReadService articleReadService;
    private final ArticleReadQueryService articleReadQueryService;

    // TODO: 2023/09/13 읽은 뉴스 기사 목록 등록 API
    @PostMapping("/{memberKey}")
    public ApiResponse<?> createArticleRead(@PathVariable String memberKey) {
        return ApiResponse.created(null);
    }

    // TODO: 2023/09/13 읽은 뉴스 기사 목록 조회 API
    @GetMapping("/{memberKey}")
    public ApiResponse<?> getArticleRead(@PathVariable String memberKey) {
        return ApiResponse.ok(null);
    }

    // TODO: 2023/09/13 읽은 뉴스 기사 목록 삭제 API
    @DeleteMapping("/{articleReadId}")
    public ApiResponse<?> removeArticleRead(@PathVariable Long articleReadId) {
        return ApiResponse.found(null);
    }
}
