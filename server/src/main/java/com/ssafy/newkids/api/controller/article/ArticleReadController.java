package com.ssafy.newkids.api.controller.article;

import com.ssafy.newkids.api.ApiResponse;
import com.ssafy.newkids.api.service.article.ArticleReadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 기사 읽기 API 컨트롤러
 *
 * @author 임우택
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/articles/{articleId}/read")
public class ArticleReadController {

    private final ArticleReadService articleReadService;

    // TODO: 2023-09-07 임우택 기사 읽기 API
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<?> createArticleRead(@PathVariable Long articleId) {
        String email = "ssafy@ssafy.com";
        articleReadService.createArticleRead(email, articleId);
        return ApiResponse.ok(null);
    }

    // TODO: 2023-09-07 임우택 기사 읽음 삭제 API
    @DeleteMapping
    public ApiResponse<?> removeArticleRead(@PathVariable Long articleId) {
        articleReadService.removeArticleRead(articleId);
        return ApiResponse.ok(null);
    }
}
