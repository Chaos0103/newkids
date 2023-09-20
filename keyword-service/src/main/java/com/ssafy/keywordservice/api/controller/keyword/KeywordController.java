package com.ssafy.keywordservice.api.controller.keyword;

import com.ssafy.keywordservice.api.controller.ApiResponse;
import com.ssafy.keywordservice.api.controller.keyword.request.CreatedKeywordRequest;
import com.ssafy.keywordservice.api.service.keyword.KeywordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/keyword-service")
public class KeywordController {

    private final KeywordService keywordService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<?> createKeyword(@RequestBody CreatedKeywordRequest request) {
        return ApiResponse.created("돼지");
    }
}
