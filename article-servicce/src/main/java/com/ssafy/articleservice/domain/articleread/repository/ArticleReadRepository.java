package com.ssafy.articleservice.domain.articleread.repository;

import com.ssafy.articleservice.domain.articleread.ArticleRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleReadRepository extends JpaRepository<ArticleRead, Long> {
}
