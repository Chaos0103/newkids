package com.ssafy.articleservice.api.controller.article.response;

import lombok.Builder;
import lombok.Data;

@Data
public class ArticleReadResponse {

    private Long articleId;
    private String title;
    private String thumbnailImg;

    @Builder
    public ArticleReadResponse(Long articleId, String title, String thumbnailImg) {
        this.articleId = articleId;
        this.title = title;
        this.thumbnailImg = thumbnailImg;
    }
}
