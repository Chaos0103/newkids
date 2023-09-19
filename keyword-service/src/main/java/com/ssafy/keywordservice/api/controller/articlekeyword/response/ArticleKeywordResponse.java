package com.ssafy.keywordservice.api.controller.articlekeyword.response;

import lombok.Builder;
import lombok.Data;

@Data
public class ArticleKeywordResponse {

    private Long keywordId;
    private String word;

    @Builder
    public ArticleKeywordResponse(Long keywordId, String word) {
        this.keywordId = keywordId;
        this.word = word;
    }
}
