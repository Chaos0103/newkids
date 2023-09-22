package com.ssafy.keywordservice.domain.articlekeyword;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleKeywordRepository extends JpaRepository<ArticleKeyword, Long> {
}
