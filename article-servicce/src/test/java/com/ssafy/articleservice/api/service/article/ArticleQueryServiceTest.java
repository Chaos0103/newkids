package com.ssafy.articleservice.api.service.article;

import com.ssafy.articleservice.IntegrationTestSupport;
import com.ssafy.articleservice.api.controller.article.response.ArticleDetailResponse;
import com.ssafy.articleservice.domain.article.Article;
import com.ssafy.articleservice.domain.article.ArticleImage;
import com.ssafy.articleservice.domain.article.repository.ArticleImageRepository;
import com.ssafy.articleservice.domain.article.repository.ArticleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class ArticleQueryServiceTest extends IntegrationTestSupport {

    @Autowired
    private ArticleQueryService articleQueryService;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleImageRepository articleImageRepository;

    @DisplayName("기사 PK를 받아 기사 내용을 조회한다.")
    @Test
    void getArticle() {
        //given
        Article article = createArticle();
        ArticleImage articleImage1 = createArticleImage(article);
        ArticleImage articleImage2 = createArticleImage(article);

        //when
        ArticleDetailResponse response = articleQueryService.getArticle(article.getId());

        //then
        assertThat(response.getImageUrls())
            .hasSize(2);
    }

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

    private ArticleImage createArticleImage(Article article) {
        ArticleImage articleImage = ArticleImage.builder()
            .url("http://오늘의_새로운_사진.jpg")
            .article(article)
            .build();
        return articleImageRepository.save(articleImage);
    }
}