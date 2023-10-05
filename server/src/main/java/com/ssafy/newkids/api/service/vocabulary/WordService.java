package com.ssafy.newkids.api.service.vocabulary;

import com.ssafy.newkids.api.controller.vocabulary.response.WordResponse;
import com.ssafy.newkids.api.service.vocabulary.dto.CreateWordDto;
import com.ssafy.newkids.api.service.vocabulary.dto.EditWordDto;
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
