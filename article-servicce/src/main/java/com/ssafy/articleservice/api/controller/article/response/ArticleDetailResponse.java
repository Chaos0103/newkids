package com.ssafy.articleservice.api.controller.article.response;

import lombok.Builder;
import lombok.Data;

@Data
public class ArticleDetailResponse {

    private String title;

    @Builder
    private ArticleDetailResponse(String title) {
        this.title = title;
    }
}
