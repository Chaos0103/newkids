package com.ssafy.recommendationservice.client.response;

import lombok.Builder;
import lombok.Data;

@Data
public class ArticleResponse {

    private Long article_id;
    private String thumbnail_img;
    private String title;

    @Builder
    public ArticleResponse(Long article_id, String thumbnail_img, String title) {
        this.article_id = article_id;
        this.thumbnail_img = thumbnail_img;
        this.title = title;
    }
}
