package com.ssafy.articleservice.api.controller.article.response;

import com.ssafy.articleservice.domain.article.Article;
import com.ssafy.articleservice.domain.article.ArticleImage;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ArticleDetailResponse {

    private Long articleId;
    private String title;
    private String subTitle;
    private String writer;
    private LocalDateTime publishedDate;
    private String content;
    private String thumbnailImg;
    private List<String> imageUrls = new ArrayList<>();

    @Builder
    private ArticleDetailResponse(Long articleId, String title, String subTitle, String writer, LocalDateTime publishedDate, String content, String thumbnailImg, List<String> imageUrls) {
        this.articleId = articleId;
        this.title = title;
        this.subTitle = subTitle;
        this.writer = writer;
        this.publishedDate = publishedDate;
        this.content = content;
        this.thumbnailImg = thumbnailImg;
        this.imageUrls = imageUrls;
    }

    public static ArticleDetailResponse of(Article article, List<ArticleImage> images) {
        List<String> urls = images.stream()
            .map(ArticleImage::getUrl)
            .collect(Collectors.toList());

        return ArticleDetailResponse.builder()
            .articleId(article.getId())
            .title(article.getTitle())
            .subTitle(article.getSubTitle())
            .writer(article.getWriter())
            .publishedDate(article.getPublishedDate())
            .content(article.getHtmlContent())
            .thumbnailImg(article.getThumbnailImg())
            .imageUrls(urls)
            .build();
    }
}
