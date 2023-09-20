package com.ssafy.keywordservice.api.controller.articlekeyword;

import com.ssafy.keywordservice.api.controller.ApiResponse;
import com.ssafy.keywordservice.api.controller.articlekeyword.response.ArticleKeywordResponse;
import com.ssafy.keywordservice.api.controller.keyword.request.CreatedKeywordRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/keyword-service/{articleKey}/articles")
public class ArticleKeywordController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ArticleKeywordResponse> createArticleKeyword(@RequestBody CreatedKeywordRequest request, @PathVariable String articleKey) {
        ArticleKeywordResponse response = ArticleKeywordResponse.builder()
            .keywordId(1L)
            .word("돼지")
            .build();
        return ApiResponse.created(response);
    }

    @GetMapping
    public ApiResponse<ArticleKeywordResponse> searchArticleKeyword(@PathVariable String articleKey) {
        ArticleKeywordResponse response = ArticleKeywordResponse.builder()
            .keywordId(1L)
            .word("돼지")
            .build();
        return ApiResponse.ok(response);
    }
}
