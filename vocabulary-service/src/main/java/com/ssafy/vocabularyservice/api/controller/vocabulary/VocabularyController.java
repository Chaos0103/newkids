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
     * @param request 등록할 단어의 정보
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
}
