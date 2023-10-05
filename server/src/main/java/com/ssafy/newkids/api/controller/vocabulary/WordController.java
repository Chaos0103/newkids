package com.ssafy.newkids.api.controller.vocabulary;

import com.ssafy.newkids.api.ApiResponse;
import com.ssafy.newkids.api.controller.vocabulary.request.CreateWordRequest;
import com.ssafy.newkids.api.controller.vocabulary.request.EditWordRequest;
import com.ssafy.newkids.api.controller.vocabulary.response.WordResponse;
import com.ssafy.newkids.api.service.vocabulary.WordQueryService;
import com.ssafy.newkids.api.service.vocabulary.WordService;
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
@RequestMapping("/words")
public class WordController {

    private final WordService wordService;
    private final WordQueryService wordQueryService;

    // TODO: 2023-09-07 임우택 단어 등록 API
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<WordResponse> createWord(@Valid @RequestBody CreateWordRequest request) {
        WordResponse response = wordService.createWord(request.toCreateWordDto());
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
