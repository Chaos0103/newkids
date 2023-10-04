package com.ssafy.recommendationservice.api.service.hotkeyword;

import com.ssafy.recommendationservice.api.controller.hotkeyword.response.WordCloudResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HotKeywordService {

    public List<WordCloudResponse> getHotKeywordByWordCloud() {
        return new ArrayList<>();
    }
}
