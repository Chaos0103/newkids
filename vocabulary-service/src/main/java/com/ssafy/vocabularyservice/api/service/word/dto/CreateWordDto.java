package com.ssafy.vocabularyservice.api.service.word.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CreateWordDto {

    private String wordKey;
    private String content;
    private String description;

    @Builder
    private CreateWordDto(String wordKey, String content, String description) {
        this.wordKey = wordKey;
        this.content = content;
        this.description = description;
    }
}
