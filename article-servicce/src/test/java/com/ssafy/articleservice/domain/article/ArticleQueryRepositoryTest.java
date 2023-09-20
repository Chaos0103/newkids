package com.ssafy.articleservice.domain.article;

import com.ssafy.articleservice.IntegrationTestSupport;
import com.ssafy.articleservice.domain.article.repository.ArticleQueryRepository;
import com.ssafy.articleservice.domain.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

class ArticleQueryRepositoryTest extends IntegrationTestSupport {

    @Autowired
    private ArticleQueryRepository articleQueryRepository;

    @Autowired
    private ArticleRepository articleRepository;

    private Article createArticle() {
        Article article = Article.builder()
            .title("전인혁 오늘 지각으로 댄스에 당첨...")
            .subTitle("과연 오늘은 어떤 춤을?!")
            .writer("임우택")
            .publishedDate(LocalDateTime.of(2023, 9, 18, 9, 0))
            .content("전인혁은 오늘 지각을 하였다. 아직 일어나지 않은 것 같다. 오늘의 춤을 선택해야지~")
            .thumbnailImg("http://전즈리얼.jpg")
            .build();
        return articleRepository.save(article);
    }
}