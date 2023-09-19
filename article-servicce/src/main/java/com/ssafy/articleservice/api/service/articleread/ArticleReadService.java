package com.ssafy.articleservice.api.service.articleread;

import com.ssafy.articleservice.api.controller.article.response.ArticleReadResponse;
import com.ssafy.articleservice.api.service.articleread.exception.DuplicateException;
import com.ssafy.articleservice.domain.article.Article;
import com.ssafy.articleservice.domain.article.repository.ArticleRepository;
import com.ssafy.articleservice.domain.articleread.ArticleRead;
import com.ssafy.articleservice.domain.articleread.repository.ArticleReadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class ArticleReadService {

    private final ArticleReadRepository articleReadRepository;
    private final ArticleRepository articleRepository;

    public ArticleReadResponse createArticleRead(String memberKey, Long articleId) {

        Optional<Article> findArticle = articleRepository.findById(articleId);
        if (findArticle.isEmpty()) {
            throw new NoSuchElementException("등록되지 않은 뉴스 기사 입니다.");
        }

        Optional<Long> check = articleReadRepository.findByMemberKeyAndArticleId(memberKey, articleId);
        if (check.isPresent()) {
            throw new DuplicateException("이미 등록된 뉴스 기사 내역입니다.");
        }

        ArticleRead articleRead = ArticleRead.builder()
            .memberKey(memberKey)
            .article(findArticle.get())
            .build();
        ArticleRead savedArticleRead = articleReadRepository.save(articleRead);

        return ArticleReadResponse.of(findArticle.get());
    }

    public void removeArticleRead(Long articleReadId) {

    }
}
