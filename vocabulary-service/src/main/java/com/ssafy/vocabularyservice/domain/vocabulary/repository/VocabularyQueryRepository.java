package com.ssafy.vocabularyservice.domain.vocabulary.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * 단어장 Querydsl 저장소
 * @author 임우택
 */
@Repository
public class VocabularyQueryRepository {

    private final JPAQueryFactory queryFactory;

    public VocabularyQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public boolean existVocabulary(String memberKey, String wordKey) {
        return false;
    }
}
