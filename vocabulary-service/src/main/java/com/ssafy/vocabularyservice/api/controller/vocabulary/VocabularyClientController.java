package com.ssafy.vocabularyservice.api.controller.vocabulary;

import com.ssafy.vocabularyservice.api.controller.vocabulary.response.WordClientResponse;
import com.ssafy.vocabularyservice.api.service.vocabulary.VocabularyQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/vocabulary-service/api/{memberKey}")
public class VocabularyClientController {

    private final VocabularyQueryService vocabularyQueryService;

    @GetMapping
    public List<WordClientResponse> getMyVocabulary(@PathVariable String memberKey) {
        log.debug("call VocabularyClientController#getMyVocabulary");

        List<WordClientResponse> responses = vocabularyQueryService.getMyVocabulary(memberKey);
        log.debug("responses={}", responses);

        return responses;
    }
}
