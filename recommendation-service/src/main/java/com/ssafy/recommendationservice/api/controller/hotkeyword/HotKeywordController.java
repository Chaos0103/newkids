package com.ssafy.recommendationservice.api.controller.hotkeyword;

import com.ssafy.recommendationservice.api.controller.ApiResponse;
import com.ssafy.recommendationservice.api.controller.hotkeyword.response.WordCloudResponse;
import com.ssafy.recommendationservice.api.service.hotkeyword.HotKeywordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/recommendation-service/api/hot-keyword")
public class HotKeywordController {

    private final HotKeywordService hotKeywordService;

    @GetMapping
    public ApiResponse<List<WordCloudResponse>> getHotKeywordByWordCloud() {
        List<WordCloudResponse> responses = hotKeywordService.getHotKeywordByWordCloud();
        return ApiResponse.ok(responses);
    }
}
