package com.ssafy.articleservice.domain.article.repository;

import com.ssafy.articleservice.domain.article.ArticleImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleImageRepository extends JpaRepository<ArticleImage, Long> {

    @Query("select ai from ArticleImage ai where ai.article.id = :articleId")
    List<ArticleImage> findByArticleId(@Param("articleId") Long articleId);

}
