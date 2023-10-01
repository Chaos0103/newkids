package com.ssafy.recommendationservice.api.service.recommendation;

import com.ssafy.recommendationservice.api.controller.recommendation.response.AnotherArticleRecommendationResponse;
import com.ssafy.recommendationservice.api.controller.recommendation.response.MainRecommendationResponse;
import com.ssafy.recommendationservice.api.controller.recommendation.response.PeerAgeRecommendationResponse;
import com.ssafy.recommendationservice.client.FlaskServerClient;
import com.ssafy.recommendationservice.client.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecommendationService {

    private final FlaskServerClient flaskServerClient;

    public List<MainRecommendationResponse> getMainRecommendation() {
        return new ArrayList<>();
    }

    public List<PeerAgeRecommendationResponse> getPeerAgeRecommendation() {
        return new ArrayList<>();
    }

    public List<AnotherArticleRecommendationResponse> getAnotherArticleRecommendation(Long articleId) {

        List<ArticleResponse> getResponses = flaskServerClient.getAnotherRecommendation(articleId);

        return getResponses.stream().map(response -> AnotherArticleRecommendationResponse.builder()
            .articleId(response.getArticle_id())
            .title(response.getTitle())
            .thumbnailImg(response.getThumbnail_img())
            .build())
            .collect(Collectors.toList());
    }
}
