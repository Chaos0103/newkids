package com.ssafy.vocabularyservice.domain.word.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.vocabularyservice.api.controller.word.response.WordResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

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

    public List<WordResponse> findAllContentLike(String content, Pageable pageable) {
        List<Long> wordIds = queryFactory
            .select(word.id)
            .from(word)
            .where(
                word.content.like("%" + content + "%")
            )
            .orderBy(word.content.asc())
            .limit(pageable.getPageSize())
            .offset(pageable.getOffset())
            .fetch();

        if (CollectionUtils.isEmpty(wordIds)) {
            return new ArrayList<>();
        }

        return queryFactory
            .select(Projections.constructor(WordResponse.class,
                word.wordKey,
                word.content,
                word.description
            ))
            .from(word)
            .where(word.id.in(wordIds))
            .orderBy(word.content.asc())
            .fetch();
    }
}
