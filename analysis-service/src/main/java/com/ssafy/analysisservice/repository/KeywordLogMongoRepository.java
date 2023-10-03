package com.ssafy.analysisservice.repository;

import com.ssafy.analysisservice.domain.KeywordLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordLogMongoRepository extends MongoRepository<KeywordLog, String> {
}
