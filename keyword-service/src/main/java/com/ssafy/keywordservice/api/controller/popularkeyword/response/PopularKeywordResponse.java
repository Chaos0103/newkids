package com.ssafy.keywordservice.api.controller.popularkeyword.response;

import lombok.Builder;
import lombok.Data;

@Data
public class PopularKeywordResponse {

    private Long keywordId;
    private String word;

    @Builder
    public PopularKeywordResponse(Long keywordId, String word) {
        this.keywordId = keywordId;
        this.word = word;
    }
}
