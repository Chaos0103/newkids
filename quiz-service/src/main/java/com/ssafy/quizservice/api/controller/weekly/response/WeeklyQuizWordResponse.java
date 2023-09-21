package com.ssafy.quizservice.api.controller.weekly.response;

import lombok.Builder;
import lombok.Data;

@Data
public class WeeklyQuizWordResponse {

    private int no;
    private String word;
    private String description;

    @Builder
    private WeeklyQuizWordResponse(int no, String word, String description) {
        this.no = no;
        this.word = word;
        this.description = description;
    }
}
