package com.ssafy.articleservice.api.controller.article.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleResponse {

    private String title;
    private String subTitle;
    private String writer;
    private LocalDateTime publishedDate;
    private String thumbnailImg;

    @Builder
    public ArticleResponse(String title, String subTitle, String writer, LocalDateTime publishedDate, String thumbnailImg) {
        this.title = title;
        this.subTitle = subTitle;
        this.writer = writer;
        this.publishedDate = publishedDate;
        this.thumbnailImg = thumbnailImg;
    }
}
