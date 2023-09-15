package com.ssafy.newkids.api.controller.article.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ArticleResponse {

    private Long articleId;
    private String title;
    private String publishedDate;
    private String content;
    private String image;

    @Builder
    public ArticleResponse(Long articleId, String title, String publishedDate, String content, String image) {
        this.articleId = articleId;
        this.title = title;
        this.publishedDate = publishedDate;
        this.content = content;
        this.image = image;
    }
}
