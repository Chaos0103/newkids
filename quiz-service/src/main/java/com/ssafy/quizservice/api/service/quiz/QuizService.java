package com.ssafy.quizservice.api.service.quiz;

import com.ssafy.quizservice.api.service.quiz.exception.NotEnoughDataException;
import com.ssafy.quizservice.client.VocabularyServiceClient;
import com.ssafy.quizservice.client.response.WordClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuizService {

//    private final
    private final VocabularyServiceClient vocabularyServiceClient;

    public List<WordClientResponse> getMyVocabulary(String memberKey) {
        List<WordClientResponse> responses = vocabularyServiceClient.getMyVocabulary(memberKey);

        if (responses.size() < 10) {
            throw new NotEnoughDataException("단어장에 저장된 단어의 갯수가 부족합니다.");
        }

        return responses;
    }
}
