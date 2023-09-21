package com.ssafy.quizservice.api.controller.quiz;

import com.ssafy.quizservice.api.controller.ApiResponse;
import com.ssafy.quizservice.api.controller.quiz.request.CheckAnswerRequest;
import com.ssafy.quizservice.api.controller.quiz.response.QuizResultResponse;
import com.ssafy.quizservice.api.controller.quiz.response.QuizWordResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/quiz-controller/{memberKey}")
public class QuizController {

    @PostMapping("/start")
    public ApiResponse<String> loadingQuiz(@PathVariable String memberKey) {
        //회원 단어장 조회
        //10개 미만이면 예외 발생
        //아니라면 레디스에 등록 후 키 부여
        return ApiResponse.ok("key");
    }

    @PostMapping("/next")
    public ApiResponse<QuizWordResponse> nextWord(@PathVariable String memberKey) {
        //다음 단어 송출
        QuizWordResponse response = QuizWordResponse.builder()
            .word("홍진식")
            .description("광주 C205 대표 돼지")
            .build();
        return ApiResponse.ok(response);
    }

    @PostMapping("/answer")
    public ApiResponse<Boolean> checkAnswer(@Valid @RequestBody CheckAnswerRequest request, @PathVariable String memberKey) {
        //정답 확인
        //반환: ture, false
        return ApiResponse.ok(true);
    }

    @PostMapping("/result")
    public ApiResponse<QuizResultResponse> resultQuiz(@PathVariable String memberKey) {
        QuizResultResponse response = QuizResultResponse.builder()
            .totalScore(70)
            .rightQuizCount(7)
            .build();
        return ApiResponse.ok(response);
    }
}
