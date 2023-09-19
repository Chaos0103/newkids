package com.ssafy.articleservice.api.service.articleread;

import com.ssafy.articleservice.api.controller.article.response.ArticleReadResponse;
import com.ssafy.articleservice.domain.articleread.repository.ArticleReadQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ArticleReadQueryService {

    private final ArticleReadQueryRepository articleReadQueryRepository;

    public Page<ArticleReadResponse> getMyArticleRead(String memberKey) {
        return null;
    }
}
