package com.ssafy.vocabularyservice.api.service.vocabulary;

import com.ssafy.vocabularyservice.api.controller.vocabulary.response.WordResponse;
import com.ssafy.vocabularyservice.api.service.vocabulary.exception.DuplicateException;
import com.ssafy.vocabularyservice.domain.vocabulary.Vocabulary;
import com.ssafy.vocabularyservice.domain.vocabulary.repository.VocabularyQueryRepository;
import com.ssafy.vocabularyservice.domain.vocabulary.repository.VocabularyRepository;
import com.ssafy.vocabularyservice.domain.word.Word;
import com.ssafy.vocabularyservice.domain.word.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * 단어장 명령 서비스
 * @author 임우택
 */
@RequiredArgsConstructor
@Service
@Transactional
public class VocabularyService {

    private final VocabularyRepository vocabularyRepository;
    private final VocabularyQueryRepository vocabularyQueryRepository;
    private final WordRepository wordRepository;

    public WordResponse createVocabulary(String memberKey, String workKey) {
        //중복 검사
        boolean isExistVocabulary = vocabularyQueryRepository.existVocabulary(memberKey, workKey);
        if (isExistVocabulary) {
            throw new DuplicateException("이미 단어장에 등록된 단어입니다.");
        }

        //단어 조회
        Optional<Word> findWord = wordRepository.findByWordKey(workKey);
        if (findWord.isEmpty()) {
            throw new NoSuchElementException("등록되지 않은 단어입니다.");
        }
        Word word = findWord.get();

        Vocabulary vocabulary = Vocabulary.builder()
            .check(false)
            .memberKey(memberKey)
            .word(word)
            .build();
        Vocabulary savedVocabulary = vocabularyRepository.save(vocabulary);

        //단어장 저장
        return WordResponse.of(word);
    }
}
