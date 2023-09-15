package com.ssafy.newkids.api.controller.vocabulary.request;

import com.ssafy.newkids.api.service.vocabulary.dto.EditWordDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditWordRequest {

    private String word;
    private String description;

    @Builder
    private EditWordRequest(String word, String description) {
        this.word = word;
        this.description = description;
    }

    public EditWordDto toEditWordDto() {
        return EditWordDto.builder()
            .word(this.word)
            .description(this.description)
            .build();
    }
}
