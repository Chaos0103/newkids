package com.ssafy.quizservice.api.controller.weekly.response;

import lombok.Builder;
import lombok.Data;

@Data
public class WeeklyQuizResultResponse {

    private int totalScore;
    private int rightQuizCount;

    @Builder
    public WeeklyQuizResultResponse(int totalScore, int rightQuizCount) {
        this.totalScore = totalScore;
        this.rightQuizCount = rightQuizCount;
    }
}
