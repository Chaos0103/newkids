package com.ssafy.articleservice.domain.articleread.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.articleservice.api.controller.article.response.ArticleReadResponse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ArticleReadQueryRepository {

    private final JPAQueryFactory queryFactory;

    public ArticleReadQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<ArticleReadResponse> findByMemberKey(String memberKey) {
        return null;
    }
}
