package com.ssafy.vocabularyservice.api.service.word;

import com.ssafy.vocabularyservice.api.controller.word.response.WordResponse;
import com.ssafy.vocabularyservice.api.service.word.dto.CreateWordDto;
import com.ssafy.vocabularyservice.api.service.word.dto.EditWordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class WordService {

    public WordResponse createWord(CreateWordDto dto) {
        return null;
    }

    public WordResponse editWord(String wordId, EditWordDto dto) {
        return null;
    }

    public WordResponse removeWord(String wordId) {
        return null;
    }
}

