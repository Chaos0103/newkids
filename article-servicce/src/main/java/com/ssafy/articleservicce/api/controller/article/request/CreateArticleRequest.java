package com.ssafy.articleservicce.api.controller.article.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateArticleRequest {

    private String title;

    @Builder
    private CreateArticleRequest(String title) {
        this.title = title;
    }
}
