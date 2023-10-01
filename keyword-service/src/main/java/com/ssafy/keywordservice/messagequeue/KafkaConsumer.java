package com.ssafy.keywordservice.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.keywordservice.domain.articlekeyword.repository.ArticleKeywordQueryRepository;
import com.ssafy.keywordservice.domain.keyword.Keyword;
import com.ssafy.keywordservice.domain.keywordsearch.KeywordSearch;
import com.ssafy.keywordservice.domain.keywordsearch.repository.KeywordSearchQueryRepository;
import com.ssafy.keywordservice.domain.keywordsearch.repository.KeywordSearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class KafkaConsumer {

    private final ArticleKeywordQueryRepository articleKeywordQueryRepository;
    private final KeywordSearchQueryRepository keywordSearchQueryRepository;
    private final KeywordSearchRepository keywordSearchRepository;

    @KafkaListener(topics = "read-article-topic")
    public void updateExp(String kafkaMessage) {
        log.info("Kafka Message: ->" + kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Long articleKey = (Long) map.get("articleKey");
        List<Keyword> keywords = articleKeywordQueryRepository.findKeywordIdsByArticleKey(articleKey);

        List<Long> keywordIds = keywords.stream()
            .map(Keyword::getId)
            .collect(Collectors.toList());

        String memberKey = (String) map.get("memberKey");
        List<KeywordSearch> keywordSearches = keywordSearchQueryRepository.findByMemberKeyAndKeywordIdIn(memberKey, keywordIds);

        Map<Long, KeywordSearch> keywordSearchMap = keywordSearches.stream()
            .collect(Collectors.toMap(keywordSearch -> keywordSearch.getKeyword().getId(), ks -> ks));

        for (Keyword keyword : keywords) {
            KeywordSearch keywordSearch = keywordSearchMap.getOrDefault(keyword.getId(), KeywordSearch.builder()
                .count(0)
                .memberKey(memberKey)
                .keyword(keyword)
                .build());

            keywordSearch.increaseCount();

            keywordSearchRepository.save(keywordSearch);
        }
    }
}
