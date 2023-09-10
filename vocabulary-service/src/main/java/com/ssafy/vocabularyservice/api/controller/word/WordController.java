package com.ssafy.vocabularyservice.api.controller.word;

import com.ssafy.vocabularyservice.api.controller.ApiResponse;
import com.ssafy.vocabularyservice.api.controller.word.request.CreateWordRequest;
import com.ssafy.vocabularyservice.api.controller.word.request.EditWordRequest;
import com.ssafy.vocabularyservice.api.controller.word.response.WordResponse;
import com.ssafy.vocabularyservice.api.service.word.WordQueryService;
import com.ssafy.vocabularyservice.api.service.word.WordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 단어 API 컨트롤러
 *
 * @author 임우택
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/vocabulary-service/words")
public class WordController {

    private final WordService wordService;
    private final WordQueryService wordQueryService;

    /**
     * 단어 등록 API
     *
     * @param request 등록할 단어의 정보
     * @return 201 CREATED 등록된 단어의 정보
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<WordResponse> createWord(@Valid @RequestBody CreateWordRequest request) {
        log.debug("call WordController#createWord");
        log.debug("CreateWordRequest={}", request);

        WordResponse response = wordService.createWord(request.toCreateWordDto());
        log.debug("response={}", response);

        return ApiResponse.created(response);
    }

    // TODO: 2023-09-07 임우택 단어 조회 API
    @GetMapping
    public ApiResponse<Page<WordResponse>> getWords(
        @RequestParam String keyword,
        @RequestParam(defaultValue = "1") Integer pageNum
    ) {
        PageRequest pageRequest = PageRequest.of(pageNum - 1, 20);
        Page<WordResponse> response = wordQueryService.getWords(keyword, pageRequest);
        return ApiResponse.ok(response);
    }

    // TODO: 2023-09-07 임우택 단어 수정 API
    @PatchMapping("/{wordId}")
    @ResponseStatus(HttpStatus.FOUND)
    public ApiResponse<WordResponse> editWord(@PathVariable String wordId, @Valid @RequestBody EditWordRequest request) {
        WordResponse response = wordService.editWord(wordId, request.toEditWordDto());
        return ApiResponse.found(response);
    }

    // TODO: 2023-09-07 임우택 단어 삭제 API
    @DeleteMapping("/{wordId}")
    @ResponseStatus(HttpStatus.FOUND)
    public ApiResponse<WordResponse> removeWord(@PathVariable String wordId) {
        WordResponse response = wordService.removeWord(wordId);
        return ApiResponse.found(response);
    }
}
