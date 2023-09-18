package com.ssafy.articleservice.domain.article.repository.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ArticleSearchCond {

    private String title;

    @Builder
    public ArticleSearchCond(String title) {
        this.title = title;
    }
}
