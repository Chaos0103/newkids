package com.ssafy.newkids.api.controller.vocabulary;

import com.ssafy.newkids.api.ApiResponse;
import com.ssafy.newkids.api.controller.vocabulary.response.VocabularyResponse;
import com.ssafy.newkids.api.service.vocabulary.VocabularyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 단어장 API 컨트롤러
 *
 * @author 임우택
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/vocabulary")
public class VocabularyController {

    private final VocabularyService vocabularyService;

    /**
     * 단어장 저장 API
     *
     * @param wordId 저장할 단어의 PK
     * @return 저장된 단어의 정보
     */
    @PostMapping("/{wordId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<VocabularyResponse> createVocabulary(@PathVariable Long wordId) {
        String email = "ssafy@ssafy.com";
        VocabularyResponse response = vocabularyService.createVocabulary(email, wordId);
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
