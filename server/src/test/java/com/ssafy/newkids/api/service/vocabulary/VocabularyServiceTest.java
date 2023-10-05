package com.ssafy.newkids.api.service.vocabulary;

import com.ssafy.newkids.IntegrationTestSupport;
import com.ssafy.newkids.api.controller.vocabulary.response.VocabularyResponse;
import com.ssafy.newkids.domain.member.Member;
import com.ssafy.newkids.domain.member.repository.MemberRepository;
import com.ssafy.newkids.domain.vocabulary.Word;
import com.ssafy.newkids.domain.vocabulary.repository.WordRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

class VocabularyServiceTest extends IntegrationTestSupport {

    @Autowired
    private VocabularyService vocabularyService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private WordRepository wordRepository;

    @DisplayName("회원은 단어장에 학습하고 싶은 단어를 등록할 수 있다.")
    @Test
    void createVocabulary() {
        //given
        Member member = createMember();
        Word word = createWord();

        //when
        VocabularyResponse response = vocabularyService.createVocabulary(member.getEmail(), word.getId());

        //then
        assertThat(response)
            .extracting("wordKey", "word", "description", "check")
            .containsExactlyInAnyOrder(
                "92288", "돼지", "멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.", false);
    }

    private Member createMember() {
        Member member = Member.builder()
            .email("ssafy@ssafy.com")
            .encryptedPwd("encryptedPwd")
            .name("김싸피")
            .age(10)
            .level(1)
            .exp(0)
            .nickname("광주C205")
            .active(true)
            .build();
        return memberRepository.save(member);
    }

    private Word createWord() {
        Word word = Word.builder()
            .wordKey("92288")
            .content("돼지")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .build();
        return wordRepository.save(word);
    }
}