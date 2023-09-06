package com.ssafy.newkids.api.controller.vocabulary.response;

import lombok.Builder;
import lombok.Data;

@Data
public class VocabularyResponse {

    private String wordKey;
    private String word;
    private String description;
    private Boolean check;

    @Builder
    public VocabularyResponse(String wordKey, String word, String description, Boolean check) {
        this.wordKey = wordKey;
        this.word = word;
        this.description = description;
        this.check = check;
    }
}
