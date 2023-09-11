package com.ssafy.vocabularyservice.api.service.vocabulary;

import com.ssafy.vocabularyservice.api.controller.vocabulary.response.WordResponse;
import com.ssafy.vocabularyservice.domain.vocabulary.repository.VocabularyRepository;
import com.ssafy.vocabularyservice.domain.word.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 단어장 명령 서비스
 * @author 임우택
 */
@RequiredArgsConstructor
@Service
@Transactional
public class VocabularyService {

    private final VocabularyRepository vocabularyRepository;
    private final WordRepository wordRepository;

    public WordResponse createVocabulary(String memberKey, String workKey) {
        return null;
    }
}
