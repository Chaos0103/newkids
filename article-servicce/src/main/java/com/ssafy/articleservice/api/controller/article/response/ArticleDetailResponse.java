package com.ssafy.articleservice.api.controller.article.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ArticleDetailResponse {

    private String title;
    private String subTitle;
    private String writer;
    private LocalDateTime publishedDate;
    private String content;
    private String thumbnailImg;
    private List<String> imageUrls = new ArrayList<>();

    @Builder
    private ArticleDetailResponse(String title, String subTitle, String writer, LocalDateTime publishedDate, String content, String thumbnailImg, List<String> imageUrls) {
        this.title = title;
        this.subTitle = subTitle;
        this.writer = writer;
        this.publishedDate = publishedDate;
        this.content = content;
        this.thumbnailImg = thumbnailImg;
        this.imageUrls = imageUrls;
    }
}
