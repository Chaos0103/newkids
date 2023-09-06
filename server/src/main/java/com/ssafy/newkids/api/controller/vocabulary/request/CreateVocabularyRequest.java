package com.ssafy.newkids.api.controller.vocabulary.request;

import com.ssafy.newkids.api.service.vocabulary.dto.CreateVocabularyDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateVocabularyRequest {

    private String wordKey;
    private String word;
    private String description;

    @Builder
    private CreateVocabularyRequest(String wordKey, String word, String description) {
        this.wordKey = wordKey;
        this.word = word;
        this.description = description;
    }

    public CreateVocabularyDto toCreateVocabularyDto() {
        return CreateVocabularyDto.builder()
            .wordKey(this.wordKey)
            .word(this.word)
            .description(this.description)
            .build();
    }
}
