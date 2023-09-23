package com.ssafy.vocabularyservice.domain.vocabulary.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.vocabularyservice.api.controller.vocabulary.response.WordClientResponse;
import com.ssafy.vocabularyservice.domain.word.QWord;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

import static com.ssafy.vocabularyservice.domain.vocabulary.QVocabulary.vocabulary;
import static com.ssafy.vocabularyservice.domain.word.QWord.word;

/**
 * 단어장 Querydsl 저장소
 *
 * @author 임우택
 */
@Repository
public class VocabularyQueryRepository {

    private final JPAQueryFactory queryFactory;

    public VocabularyQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    /**
     * 회원키와 단어키로 단어장 중복 여부 조회
     *
     * @param memberKey 조회할 회원키
     * @param wordKey   조회할 단어키
     * @return 단어장 중복 등록 여부
     */
    public boolean existVocabulary(String memberKey, String wordKey) {
        Integer result = queryFactory
            .selectOne()
            .from(vocabulary)
            .join(vocabulary.word, word)
            .where(
                vocabulary.memberKey.eq(memberKey),
                vocabulary.word.wordKey.eq(wordKey)
            )
            .fetchFirst();
        return result != null;
    }

    public List<WordClientResponse> findByMemberKey(String memberKey) {
        return queryFactory
            .select(Projections.constructor(WordClientResponse.class,
                vocabulary.word.wordKey,
                vocabulary.word.content,
                vocabulary.word.description
            ))
            .from(vocabulary)
            .join(vocabulary.word, word)
            .where(vocabulary.memberKey.eq(memberKey))
            .orderBy(NumberExpression.random().asc())
            .limit(10)
            .fetch();
    }
}
