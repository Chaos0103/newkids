package com.ssafy.newkids.api.controller.vocabulary.request;

import com.ssafy.newkids.api.service.vocabulary.dto.CreateWordDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateWordRequest {

    private String wordKey;
    private String word;
    private String description;

    @Builder
    private CreateWordRequest(String wordKey, String word, String description) {
        this.wordKey = wordKey;
        this.word = word;
        this.description = description;
    }

    public CreateWordDto toCreateWordDto() {
        return CreateWordDto.builder()
            .wordKey(this.wordKey)
            .word(this.word)
            .description(this.description)
            .build();
    }
}
