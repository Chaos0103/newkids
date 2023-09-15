package com.ssafy.vocabularyservice.api.controller.vocabulary;

import com.ssafy.vocabularyservice.api.controller.ApiResponse;
import com.ssafy.vocabularyservice.api.controller.vocabulary.request.CreateVocabularyRequest;
import com.ssafy.vocabularyservice.api.controller.vocabulary.response.WordResponse;
import com.ssafy.vocabularyservice.api.service.vocabulary.VocabularyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 단어장 API 컨트롤러
 *
 * @author 임우택
 */
@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/vocabulary-service")
public class VocabularyController {

    private final VocabularyService vocabularyService;

    /**
     * 단어장 등록 API
     *
     * @param request   등록할 단어의 정보
     * @param memberKey 등록할 회원키
     * @return 등록된 단어의 정보
     */
    @PostMapping("/{memberKey}")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<WordResponse> createVocabulary(@Valid @RequestBody CreateVocabularyRequest request, @PathVariable String memberKey) {
        log.debug("call VocabularyController#createVocabulary");
        log.debug("memberKey={}", memberKey);
        log.debug("CreateVocabularyRequest={}", request);

        WordResponse response = vocabularyService.createVocabulary(memberKey, request.getWordKey());
        log.debug("response={}", response);

        return ApiResponse.created(response);
    }

    /**
     * 단어장 체크 상태 변경 API
     *
     * @param vocabularyId 상태 변경할 단어장의 PK
     * @return 변경된 단어장 정보
     */
    @PatchMapping("/{vocabularyId}")
    @ResponseStatus(HttpStatus.FOUND)
    public ApiResponse<WordResponse> checkVocabulary(@PathVariable Long vocabularyId) {
        log.debug("call VocabularyController#checkVocabulary");
        log.debug("vocabularyId={}", vocabularyId);

        WordResponse response = vocabularyService.checkVocabulary(vocabularyId);
        log.debug("response={}", response);

        return ApiResponse.found(response);
    }

    /**
     * 단어장 삭제 API
     * @param vocabularyId 삭제할 단어장의 PK
     * @return 삭제된 단어장 정보
     */
    @DeleteMapping("/{vocabularyId}")
    @ResponseStatus(HttpStatus.FOUND)
    public ApiResponse<WordResponse> removeVocabulary(@PathVariable Long vocabularyId) {
        log.debug("call VocabularyController#removeVocabulary");
        log.debug("vocabularyId={}", vocabularyId);

        WordResponse response = vocabularyService.removeVocabulary(vocabularyId);
        log.debug("response={}", response);

        return ApiResponse.found(response);
    }
}
