package com.ssafy.newkids.api.controller.vocabulary;

import com.ssafy.newkids.api.ApiResponse;
import com.ssafy.newkids.api.controller.vocabulary.request.CreateVocabularyRequest;
import com.ssafy.newkids.api.controller.vocabulary.response.VocabularyResponse;
import com.ssafy.newkids.api.service.vocabulary.VocabularyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/vocabulary")
public class VocabularyController {

    private final VocabularyService vocabularyService;

    //    C: 단어장 추가
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<VocabularyResponse> createVocabulary(@Valid @RequestBody CreateVocabularyRequest request) {
        String email = "ssafy@ssafy.com";
        VocabularyResponse response = vocabularyService.createVocabulary(email, request.toCreateVocabularyDto());
        return ApiResponse.created(response);
    }

    //    R: 내 단어장 목록 검색
    @GetMapping
    public ApiResponse<?> getVocabulary() {
        return ApiResponse.ok(null);
    }

    //    U: 단어 체크
    @PatchMapping("/{vocabularyId}")
    @ResponseStatus(HttpStatus.FOUND)
    public ApiResponse<VocabularyResponse> checkVocabulary(@PathVariable Long vocabularyId) {
        VocabularyResponse response = vocabularyService.checkVocabulary(vocabularyId);
        return ApiResponse.found(response);
    }

    //    D: 단어장 삭제
    @DeleteMapping("/{vocabularyId}")
    @ResponseStatus(HttpStatus.FOUND)
    public ApiResponse<VocabularyResponse> removeVocabulary(@PathVariable Long vocabularyId) {
        VocabularyResponse response = vocabularyService.removeVocabulary(vocabularyId);
        return ApiResponse.found(response);
    }
}
