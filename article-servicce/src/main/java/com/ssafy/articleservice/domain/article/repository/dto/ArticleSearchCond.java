package com.ssafy.articleservice.domain.article.repository.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ArticleSearchCond {

    private String content;

    @Builder
    public ArticleSearchCond(String content) {
        this.content = content;
    }
}
