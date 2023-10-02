package com.ssafy.articleservice.api.controller.article;

import com.ssafy.articleservice.api.controller.article.response.PopularArticleResponse;
import com.ssafy.articleservice.api.service.popular.PopularArticleQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/article-service/api/client")
public class ArticleClientController {

    private final PopularArticleQueryService popularArticleQueryService;

    @GetMapping("/popular")
    public List<PopularArticleResponse> popularArticle() {
        log.debug("ArticleClientController#popularArticle");

        List<PopularArticleResponse> responses = popularArticleQueryService.getPopularArticle();
        log.debug("responses={}", responses);

        return responses;
    }
}
