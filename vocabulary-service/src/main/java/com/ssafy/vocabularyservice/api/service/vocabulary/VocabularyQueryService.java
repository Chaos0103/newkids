package com.ssafy.vocabularyservice.api.service.vocabulary;

import com.ssafy.vocabularyservice.api.controller.vocabulary.response.WordClientResponse;
import com.ssafy.vocabularyservice.domain.vocabulary.repository.VocabularyQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class VocabularyQueryService {

    private final VocabularyQueryRepository vocabularyQueryRepository;

    public List<WordClientResponse> getMyVocabulary(String memberKey) {
        return vocabularyQueryRepository.findByMemberKey(memberKey);
    }
}
