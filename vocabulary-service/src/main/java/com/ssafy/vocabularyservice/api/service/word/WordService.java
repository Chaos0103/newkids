package com.ssafy.vocabularyservice.api.service.word;

import com.ssafy.vocabularyservice.api.controller.word.response.WordResponse;
import com.ssafy.vocabularyservice.api.service.word.dto.CreateWordDto;
import com.ssafy.vocabularyservice.api.service.word.dto.EditWordDto;
import com.ssafy.vocabularyservice.api.service.word.exception.DuplicateException;
import com.ssafy.vocabularyservice.domain.word.Word;
import com.ssafy.vocabularyservice.domain.word.repository.WordQueryRepository;
import com.ssafy.vocabularyservice.domain.word.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class WordService {

    private final WordRepository wordRepository;
    private final WordQueryRepository wordQueryRepository;

    public WordResponse createWord(CreateWordDto dto) {
        boolean isExistWordKey = wordQueryRepository.existWordKey(dto.getWordKey());
        if (isExistWordKey) {
            throw new DuplicateException("이미 사용중인 단어키입니다.");
        }

        Word word = dto.toEntity();
        Word savedWord = wordRepository.save(word);

        return WordResponse.of(savedWord);
    }

    public WordResponse editWord(String wordId, EditWordDto dto) {
        return null;
    }

    public WordResponse removeWord(String wordId) {
        return null;
    }
}

