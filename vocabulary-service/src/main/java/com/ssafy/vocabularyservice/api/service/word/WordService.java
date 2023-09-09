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

/**
 * 단어 명령 서비스
 * @author 임우택
 */
@RequiredArgsConstructor
@Service
@Transactional
public class WordService {

    private final WordRepository wordRepository;
    private final WordQueryRepository wordQueryRepository;

    /**
     * 단어 등록
     * @param dto 등록할 단어의 정보
     * @return 등록된 단어의 정보
     * @throws DuplicateException 단어 키가 이미 존재하는 경우
     */
    public WordResponse createWord(CreateWordDto dto) {
        checkWordKeyDuplication(dto);

        Word savedWord = saveEntity(dto);

        return WordResponse.of(savedWord);
    }

    public WordResponse editWord(String wordId, EditWordDto dto) {
        return null;
    }

    public WordResponse removeWord(String wordId) {
        return null;
    }

    private void checkWordKeyDuplication(CreateWordDto dto) {
        boolean isExistWordKey = wordQueryRepository.existWordKey(dto.getWordKey());
        if (isExistWordKey) {
            throw new DuplicateException("이미 사용중인 단어키입니다.");
        }
    }

    private Word saveEntity(CreateWordDto dto) {
        Word word = dto.toEntity();
        return wordRepository.save(word);
    }
}

