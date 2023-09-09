package com.ssafy.vocabularyservice.domain.word.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import static com.ssafy.vocabularyservice.domain.word.QWord.word;

/**
 * 단어 Query 저장소
 *
 * @author 임우택
 */
@Repository
public class WordQueryRepository {

    private final JPAQueryFactory queryFactory;

    public WordQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    /**
     * 단어키 중복 검사 쿼리
     *
     * @param wordKey 중복 검사할 단어키
     * @return true: 사용 불가(중복), false: 사용 가능
     */
    public boolean existWordKey(String wordKey) {
        Integer result = queryFactory
            .selectOne()
            .from(word)
            .where(word.wordKey.eq(wordKey))
            .fetchFirst();
        return result != null;
    }
}
