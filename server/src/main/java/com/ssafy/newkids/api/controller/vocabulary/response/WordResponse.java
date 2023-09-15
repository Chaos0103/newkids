package com.ssafy.newkids.api.controller.vocabulary.response;

import lombok.Builder;
import lombok.Data;

@Data
public class WordResponse {

    private String wordKey;
    private String word;
    private String description;

    @Builder
    public WordResponse(String wordKey, String word, String description) {
        this.wordKey = wordKey;
        this.word = word;
        this.description = description;
    }
}
