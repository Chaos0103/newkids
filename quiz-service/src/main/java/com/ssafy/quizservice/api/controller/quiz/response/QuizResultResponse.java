package com.ssafy.quizservice.api.controller.quiz.response;

import lombok.Builder;
import lombok.Data;

@Data
public class QuizResultResponse {

    private int totalScore;
    private int rightQuizCount;

    @Builder
    public QuizResultResponse(int totalScore, int rightQuizCount) {
        this.totalScore = totalScore;
        this.rightQuizCount = rightQuizCount;
    }
}
