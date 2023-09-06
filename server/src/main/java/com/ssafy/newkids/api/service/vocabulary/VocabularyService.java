package com.ssafy.newkids.api.service.vocabulary;

import com.ssafy.newkids.api.controller.vocabulary.response.VocabularyResponse;
import com.ssafy.newkids.api.service.vocabulary.dto.CreateVocabularyDto;
import com.ssafy.newkids.domain.vocabulary.repository.VocabularyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class VocabularyService {

    private final VocabularyRepository vocabularyRepository;

    public VocabularyResponse createVocabulary(String email, CreateVocabularyDto dto) {
        return null;
    }

    public VocabularyResponse checkVocabulary(Long vocabularyId) {
        return null;
    }

    public VocabularyResponse removeVocabulary(Long vocabularyId) {
        return null;
    }
}
