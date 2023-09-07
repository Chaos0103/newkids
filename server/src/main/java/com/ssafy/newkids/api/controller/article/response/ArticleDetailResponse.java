package com.ssafy.newkids.api.controller.article.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ArticleDetailResponse {

    private String title;
    private String publishedDate;
    private String content;
    private String writer;
    private List<String> images;
    private List<String> keywords;

    @Builder
    public ArticleDetailResponse(String title, String publishedDate, String content, String writer, List<String> images, List<String> keywords) {
        this.title = title;
        this.publishedDate = publishedDate;
        this.content = content;
        this.writer = writer;
        this.images = images;
        this.keywords = keywords;
    }
}
