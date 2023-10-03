package com.ssafy.keywordservice.api.controller.client;

import com.ssafy.keywordservice.api.service.articlekeyword.ArticleKeywordQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/keyword-service/api/client")
public class KeywordServiceClientController {

    private final ArticleKeywordQueryService articleKeywordQueryService;

    @GetMapping("/{articleId}")
    public List<Long> getKeywordIds(@PathVariable Long articleId) {
        log.debug("call KeywordServiceClientController#getKeywordIds");
        log.debug("articleId={}", articleId);

        List<Long> keywordIds = articleKeywordQueryService.getArticleKeywordIds(articleId);
        log.debug("keywordIds={}", keywordIds);

        return keywordIds;
    }
}
