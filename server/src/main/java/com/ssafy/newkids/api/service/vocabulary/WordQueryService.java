package com.ssafy.newkids.api.service.vocabulary;

import com.ssafy.newkids.api.controller.vocabulary.response.WordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class WordQueryService {

    public Page<WordResponse> getWords(String keyword, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(), pageable, 0);
    }
}
