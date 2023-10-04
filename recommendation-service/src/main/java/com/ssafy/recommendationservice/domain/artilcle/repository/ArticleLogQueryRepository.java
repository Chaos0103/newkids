package com.ssafy.recommendationservice.domain.artilcle.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.recommendationservice.domain.artilcle.ArticleLog;
import com.ssafy.recommendationservice.domain.artilcle.QArticleLog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static com.ssafy.recommendationservice.domain.artilcle.QArticleLog.articleLog;

@Repository
public class ArticleLogQueryRepository {

    private final JPAQueryFactory queryFactory;

    public ArticleLogQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<Long> findHotArticle(LocalDateTime targetDate) {
        return queryFactory
            .select(articleLog.articleId)
            .from(articleLog)
            .where(articleLog.createdDate.after(targetDate))
            .orderBy(articleLog.count.desc())
            .limit(5)
            .fetch();
    }
}
