package com.ssafy.articleservice.api.controller.article.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class CreateArticleReadRequest {

    @NonNull
    private Long articleId;

    @Builder
    private CreateArticleReadRequest(Long articleId) {
        this.articleId = articleId;
    }
}
