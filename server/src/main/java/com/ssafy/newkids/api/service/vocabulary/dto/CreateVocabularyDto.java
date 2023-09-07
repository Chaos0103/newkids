package com.ssafy.newkids.api.service.vocabulary.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CreateVocabularyDto {

    private String wordKey;
    private String word;
    private String description;

    @Builder
    private CreateVocabularyDto(String wordKey, String word, String description) {
        this.wordKey = wordKey;
        this.word = word;
        this.description = description;
    }
}
