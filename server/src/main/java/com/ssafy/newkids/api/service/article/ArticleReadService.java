package com.ssafy.newkids.api.service.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class ArticleReadService {

    public void createArticleRead(String email, Long articleId) {

    }

    public void removeArticleRead(Long articleReadId) {

    }
}
