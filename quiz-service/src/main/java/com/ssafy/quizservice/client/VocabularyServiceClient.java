package com.ssafy.quizservice.client;

import com.ssafy.quizservice.client.response.WordClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "vocabulary-service")
public interface VocabularyServiceClient {

    @GetMapping("/vocabulary-service/api/{memberKey}")
    List<WordClientResponse> getMyVocabulary(@PathVariable String memberKey);
}
