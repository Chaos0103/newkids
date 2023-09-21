package com.ssafy.quizservice.api.controller.weekly;

import com.ssafy.quizservice.api.controller.ApiResponse;
import com.ssafy.quizservice.api.controller.weekly.request.CheckAnswerRequest;
import com.ssafy.quizservice.api.controller.weekly.response.WeeklyQuizResultResponse;
import com.ssafy.quizservice.api.controller.weekly.response.WeeklyQuizWordResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/quiz-controller/weekly")
public class WeeklyController {

    @PostMapping("/start")
    public ApiResponse<String> loadingWeeklyQuiz() {
        //회원 단어장 조회
        //10개 미만이면 예외 발생
        //아니라면 레디스에 등록 후 키 부여
        return ApiResponse.ok("key");
    }

    @PostMapping("/next")
    public ApiResponse<WeeklyQuizWordResponse> nextWeeklyWord() {
        //다음 단어 송출
        WeeklyQuizWordResponse response = WeeklyQuizWordResponse.builder()
            .word("홍진식")
            .description("광주 C205 대표 돼지")
            .build();
        return ApiResponse.ok(response);
    }

    @PostMapping("/answer")
    public ApiResponse<Boolean> checkWeeklyAnswer(@Valid @RequestBody CheckAnswerRequest request) {
        //정답 확인
        //반환: ture, false
        return ApiResponse.ok(true);
    }

    @PostMapping("/result")
    public ApiResponse<WeeklyQuizResultResponse> resultWeeklyQuiz() {
        WeeklyQuizResultResponse response = WeeklyQuizResultResponse.builder()
            .totalScore(70)
            .rightQuizCount(7)
            .build();
        return ApiResponse.ok(response);
    }
}
