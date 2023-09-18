package com.ssafy.articleservice.domain.article.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.articleservice.api.controller.article.response.ArticleDetailResponse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ArticleQueryRepository {

    private final JPAQueryFactory queryFactory;

    public ArticleQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    public ArticleDetailResponse findById(Long articleId) {
        return null;
    }
}
