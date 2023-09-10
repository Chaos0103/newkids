package com.ssafy.vocabularyservice.domain.word.repository;

import com.ssafy.vocabularyservice.IntegrationTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

class WordQueryRepositoryTest extends IntegrationTestSupport {

    @Autowired
    private WordQueryRepository wordQueryRepository;

    @DisplayName("단어 키가 존재하는지 알 수 있다.")
    @Test
    void existWordKey() {
        //given

        //when
        boolean isExistWordKey = wordQueryRepository.existWordKey("92288");

        //then
        assertThat(isExistWordKey).isFalse();
    }
}