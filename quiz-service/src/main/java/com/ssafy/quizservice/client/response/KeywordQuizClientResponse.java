package com.ssafy.quizservice.client.response;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class KeywordQuizClientResponse {

    private String content;
    private String description;
    private List<String> contents = new ArrayList<>();

    @Builder
    public KeywordQuizClientResponse(String content, String description, List<String> contents) {
        this.content = content;
        this.description = description;
        this.contents = contents;
    }
}
