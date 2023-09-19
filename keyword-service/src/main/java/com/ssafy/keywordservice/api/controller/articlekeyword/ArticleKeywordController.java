package com.ssafy.keywordservice.api.controller.articlekeyword;

import com.ssafy.keywordservice.api.controller.ApiResponse;
import com.ssafy.keywordservice.api.controller.articlekeyword.response.ArticleKeywordResponse;
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
    public ApiResponse<?> createArticleKeyword(@PathVariable String articleKey) {
        return null;
    }

    @GetMapping
    public ApiResponse<ArticleKeywordResponse> searchArticleKeyword(@PathVariable String articleKey) {
        return null;
    }
}
