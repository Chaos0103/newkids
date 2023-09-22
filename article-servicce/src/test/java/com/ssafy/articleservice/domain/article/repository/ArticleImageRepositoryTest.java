package com.ssafy.articleservice.domain.article.repository;

import com.ssafy.articleservice.IntegrationTestSupport;
import com.ssafy.articleservice.domain.article.Article;
import com.ssafy.articleservice.domain.article.ArticleImage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ArticleImageRepositoryTest extends IntegrationTestSupport {

    @Autowired
    private ArticleImageRepository articleImageRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @DisplayName("기사 PK로 연관된 이미지를 조회한다.")
    @Test
    void findByArticleId() {
        //given
        Article article = createArticle();
        ArticleImage articleImage1 = createArticleImage(article);
        ArticleImage articleImage2 = createArticleImage(article);

        //when
        List<ArticleImage> articleImages = articleImageRepository.findByArticleId(article.getId());

        //then
        assertThat(articleImages).hasSize(2);
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