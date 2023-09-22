package com.ssafy.keywordservice.api.controller.articlekeyword;

import com.ssafy.keywordservice.api.controller.ApiResponse;
import com.ssafy.keywordservice.api.controller.articlekeyword.response.ArticleKeywordResponse;
import com.ssafy.keywordservice.api.controller.keyword.request.CreatedKeywordRequest;
import com.ssafy.keywordservice.api.service.articlekeyword.ArticleKeywordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/keyword-service/{articleKey}/articles")
public class ArticleKeywordController {

    private final ArticleKeywordService articleKeywordService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ArticleKeywordResponse> createArticleKeyword(
        @Valid @RequestBody CreatedKeywordRequest request,
        @PathVariable String articleKey
    ) {
        log.debug("ArticleKeywordController#createArticleKeyword");
        log.debug("request={}", request);

        ArticleKeywordResponse response = articleKeywordService.createArticleKeyword(articleKey, request.getWord());
        log.debug("response={}", response);

        return ApiResponse.created(response);
    }

    // TODO: 2023-09-20 searchArticleKeyword
    @GetMapping
    public ApiResponse<ArticleKeywordResponse> searchArticleKeyword(@PathVariable String articleKey) {
        ArticleKeywordResponse response = ArticleKeywordResponse.builder()
            .keywordId(1L)
            .word("돼지")
            .build();
        return ApiResponse.ok(response);
    }
}
