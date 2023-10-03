package com.ssafy.analysisservice.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.analysisservice.client.KeywordServiceClient;
import com.ssafy.analysisservice.domain.ArticleLog;
import com.ssafy.analysisservice.domain.KeywordLog;
import com.ssafy.analysisservice.repository.ArticleLogMongoRepository;
import com.ssafy.analysisservice.repository.KeywordLogMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class KafkaConsumer {

    private final KeywordServiceClient keywordServiceClient;
    private final ArticleLogMongoRepository articleLogMongoRepository;
    private final KeywordLogMongoRepository keywordLogMongoRepository;

    @KafkaListener(topics = "read-article-topic")
    public void writeKeywordLogs(String kafkaMessage) {
        log.info("Kafka Message: ->" + kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Long articleId = (Long) map.get("articleId");
        List<Long> keywordIds = keywordServiceClient.getKeywordIds(articleId);

        String memberKey = (String) map.get("memberKey");

        insertArticleLog(memberKey, articleId);
        insertKeywordLogs(memberKey, keywordIds);
    }

    private void insertArticleLog(String memberKey, Long articleId) {
        ArticleLog log = ArticleLog.builder()
            .memberKey(memberKey)
            .articleId(articleId)
            .build();

        articleLogMongoRepository.save(log);
    }

    private void insertKeywordLogs(String memberKey, List<Long> keywordIds) {
        List<KeywordLog> logs = keywordIds.stream()
            .map(keywordId -> KeywordLog.builder()
                .memberKey(memberKey)
                .keywordId(keywordId)
                .build())
            .collect(Collectors.toList());

        keywordLogMongoRepository.saveAll(logs);
    }
}
