package com.ssafy.newkids.api.service.vocabulary;

import com.ssafy.newkids.api.controller.vocabulary.response.VocabularyResponse;
import com.ssafy.newkids.domain.member.Member;
import com.ssafy.newkids.domain.member.repository.MemberRepository;
import com.ssafy.newkids.domain.vocabulary.Vocabulary;
import com.ssafy.newkids.domain.vocabulary.Word;
import com.ssafy.newkids.domain.vocabulary.repository.VocabularyRepository;
import com.ssafy.newkids.domain.vocabulary.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

/**
 * 단어장 명령 서비스
 *
 * @author 임우택
 */
@RequiredArgsConstructor
@Service
@Transactional
public class VocabularyService {

    private final VocabularyRepository vocabularyRepository;
    private final MemberRepository memberRepository;
    private final WordRepository wordRepository;

    /**
     * 단어장 저장
     *
     * @param email 저장을 요청한 계정 이메일
     * @param wordId 단어장에 저장할 단어의 PK
     * @return 저장된 단어의 정보
     * @throws NoSuchElementException 등록되지 않은 계정 혹은 단어를 조회한 경우
     */
    public VocabularyResponse createVocabulary(String email, Long wordId) {
        Member member = getMemberEntity(email);
        Word word = getWordEntity(wordId);

        Vocabulary savedVocabulary = saveVocabulary(member, word);

        return VocabularyResponse.builder()
            .wordKey(word.getWordKey())
            .word(word.getContent())
            .description(word.getDescription())
            .check(savedVocabulary.getCheck())
            .build();
    }

    public VocabularyResponse checkVocabulary(Long vocabularyId) {
        return null;
    }

    public VocabularyResponse removeVocabulary(Long vocabularyId) {
        return null;
    }

    /**
     * 계정 이메일로 회원 엔티티 조회
     *
     * @param email 계정 이메일
     * @return 조회된 회원 엔티티
     */
    private Member getMemberEntity(String email) {
        return memberRepository.findByEmail(email)
            .orElseThrow(NoSuchElementException::new);
    }

    /**
     * 단어 PK로 단어 엔티티 조회
     *
     * @param wordId 단어 PK
     * @return 조회된 단어 엔티티
     */
    private Word getWordEntity(Long wordId) {
        return wordRepository.findById(wordId)
            .orElseThrow(NoSuchElementException::new);
    }

    /**
     * 단어장 엔티티 저장
     *
     * @param member 회원 FK
     * @param word 단어 FK
     * @return 저장된 단어장 엔티티
     */
    private Vocabulary saveVocabulary(Member member, Word word) {
        Vocabulary vocabulary = Vocabulary.builder()
            .member(member)
            .word(word)
            .check(false)
            .build();
        return vocabularyRepository.save(vocabulary);
    }
}
