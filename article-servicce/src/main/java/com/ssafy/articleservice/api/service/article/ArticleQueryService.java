package com.ssafy.articleservice.api.service.article;

import com.ssafy.articleservice.api.controller.article.response.ArticleDetailResponse;
import com.ssafy.articleservice.api.controller.article.response.ArticleResponse;
import com.ssafy.articleservice.domain.article.repository.ArticleQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ArticleQueryService {

    private final ArticleQueryRepository articleQueryRepository;

    public Page<ArticleResponse> getArticles() {
        return null;
    }

    public ArticleDetailResponse getArticle(Long articleId) {
        return articleQueryRepository.findById(articleId);
    }
}
