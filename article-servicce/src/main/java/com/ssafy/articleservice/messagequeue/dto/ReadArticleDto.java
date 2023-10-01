package com.ssafy.articleservice.messagequeue.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ReadArticleDto {

    private String memberKey;
    private Long articleKey;

    @Builder
    public ReadArticleDto(String memberKey, Long articleKey) {
        this.memberKey = memberKey;
        this.articleKey = articleKey;
    }
}
