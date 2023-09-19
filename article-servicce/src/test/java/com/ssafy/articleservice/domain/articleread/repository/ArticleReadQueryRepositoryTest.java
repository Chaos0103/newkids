package com.ssafy.articleservice.domain.articleread.repository;

import com.ssafy.articleservice.IntegrationTestSupport;
import com.ssafy.articleservice.api.controller.article.response.ArticleReadResponse;
import com.ssafy.articleservice.domain.articleread.ArticleRead;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class ArticleReadQueryRepositoryTest extends IntegrationTestSupport {

    @Autowired
    private ArticleReadQueryRepository articleReadQueryRepository;

    @Autowired
    private ArticleReadRepository articleReadRepository;

    @DisplayName("회원 고유키로 읽은 뉴스 기사를 조회한다.")
    @Test
    void findByMemberKey() {
        //given
        String memberKey = UUID.randomUUID().toString();
        createArticleRead(memberKey);
        createArticleRead(memberKey);
        createArticleRead(memberKey);

        //when
        List<ArticleReadResponse> responses = articleReadQueryRepository.findByMemberKey(memberKey);

        //then
        assertThat(responses).hasSize(3);
    }

    private ArticleRead createArticleRead(String memberKey) {
        ArticleRead articleRead = ArticleRead.builder()
            .memberKey(memberKey)
            .article(null)
            .build();
        return articleReadRepository.save(articleRead);
    }
}