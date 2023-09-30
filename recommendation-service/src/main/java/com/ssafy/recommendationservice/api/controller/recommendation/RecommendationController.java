package com.ssafy.recommendationservice.api.controller.recommendation;

import com.ssafy.recommendationservice.api.controller.ApiResponse;
import com.ssafy.recommendationservice.api.controller.recommendation.response.AnotherArticleRecommendationResponse;
import com.ssafy.recommendationservice.api.controller.recommendation.response.MainRecommendationResponse;
import com.ssafy.recommendationservice.api.controller.recommendation.response.PeerAgeRecommendationResponse;
import com.ssafy.recommendationservice.api.service.recommendation.RecommendationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/recommendation-service/api")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/main")
    public ApiResponse<List<MainRecommendationResponse>> getMainRecommendation() {
        List<MainRecommendationResponse> responses = recommendationService.getMainRecommendation();
        return ApiResponse.ok(responses);
    }

    @GetMapping("/peer-age")
    public ApiResponse<List<PeerAgeRecommendationResponse>> getPeerAgeRecommendation() {
        List<PeerAgeRecommendationResponse> responses = recommendationService.getPeerAgeRecommendation();
        return ApiResponse.ok(responses);
    }

    @GetMapping("/another-article")
    public ApiResponse<List<AnotherArticleRecommendationResponse>> getAnotherArticleRecommendation() {
        List<AnotherArticleRecommendationResponse> responses = recommendationService.getAnotherArticleRecommendation();
        return ApiResponse.ok(responses);
    }
}
