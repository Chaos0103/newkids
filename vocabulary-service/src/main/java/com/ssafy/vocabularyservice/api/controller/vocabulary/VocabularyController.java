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

    @PostMapping("/{memberKey}")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<WordResponse> createVocabulary(@Valid @RequestBody CreateVocabularyRequest request, @PathVariable String memberKey) {
        return ApiResponse.created(null);
    }
}
