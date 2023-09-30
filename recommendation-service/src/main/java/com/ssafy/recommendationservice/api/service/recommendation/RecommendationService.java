package com.ssafy.recommendationservice.api.service.recommendation;

import com.ssafy.recommendationservice.api.controller.recommendation.response.AnotherArticleRecommendationResponse;
import com.ssafy.recommendationservice.api.controller.recommendation.response.MainRecommendationResponse;
import com.ssafy.recommendationservice.api.controller.recommendation.response.PeerAgeRecommendationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RecommendationService {

    public List<MainRecommendationResponse> getMainRecommendation() {
        return new ArrayList<>();
    }

    public List<PeerAgeRecommendationResponse> getPeerAgeRecommendation() {
        return new ArrayList<>();
    }

    public List<AnotherArticleRecommendationResponse> getAnotherArticleRecommendation() {
        return new ArrayList<>();
    }
}
