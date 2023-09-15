package com.ssafy.newkids.api.service.vocabulary.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class EditWordDto {

    private String word;
    private String description;

    @Builder
    private EditWordDto(String word, String description) {
        this.word = word;
        this.description = description;
    }
}
