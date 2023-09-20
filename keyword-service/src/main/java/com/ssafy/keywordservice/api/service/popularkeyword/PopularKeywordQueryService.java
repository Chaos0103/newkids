package com.ssafy.keywordservice.api.service.popularkeyword;

import com.ssafy.keywordservice.api.controller.popularkeyword.response.PopularKeywordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PopularKeywordQueryService {

    public List<PopularKeywordResponse> getTopFivePopularKeyword() {
        return null;
    }
}
