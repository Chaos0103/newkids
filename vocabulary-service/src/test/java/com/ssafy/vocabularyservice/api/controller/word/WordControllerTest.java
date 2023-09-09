package com.ssafy.vocabularyservice.api.controller.word;

import com.ssafy.vocabularyservice.ControllerTestSupport;
import com.ssafy.vocabularyservice.api.controller.word.request.CreateWordRequest;
import com.ssafy.vocabularyservice.api.controller.word.response.WordResponse;
import com.ssafy.vocabularyservice.api.service.word.WordQueryService;
import com.ssafy.vocabularyservice.api.service.word.WordService;
import com.ssafy.vocabularyservice.api.service.word.dto.CreateWordDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class WordControllerTest extends ControllerTestSupport {

    @MockBean
    private WordService wordService;

    @MockBean
    private WordQueryService wordQueryService;

    @DisplayName("새로운 단어를 등록한다.")
    @Test
    void createWord() throws Exception {
        //given
        CreateWordRequest request = CreateWordRequest.builder()
            .wordKey("92288")
            .content("돼지")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .build();

        WordResponse response = WordResponse.builder()
            .wordKey("92288")
            .content("돼지")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .build();

        given(wordService.createWord(any(CreateWordDto.class)))
            .willReturn(response);


        //when //then
        mockMvc.perform(
                post("/vocabulary-service/words")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.code").value("201"))
            .andExpect(jsonPath("$.status").value("CREATED"))
            .andExpect(jsonPath("$.message").value("CREATED"))
            .andExpect(jsonPath("$.data").isNotEmpty());
    }

    @DisplayName("새로운 단어를 등록할 때 단어 키는 필수값이다.")
    @Test
    void createWordWithoutWordKey() throws Exception {
        //given
        CreateWordRequest request = CreateWordRequest.builder()
            .content("돼지")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .build();

        //when //then
        mockMvc.perform(
                post("/vocabulary-service/words")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.code").value("400"))
            .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
            .andExpect(jsonPath("$.message").value("단어 키는 필수입니다."))
            .andExpect(jsonPath("$.data").isEmpty());
    }

    @DisplayName("새로운 단어를 등록할 때 단어는 필수값이다.")
    @Test
    void createWordWithoutContent() throws Exception {
        //given
        CreateWordRequest request = CreateWordRequest.builder()
            .wordKey("92288")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .build();

        //when //then
        mockMvc.perform(
                post("/vocabulary-service/words")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.code").value("400"))
            .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
            .andExpect(jsonPath("$.message").value("단어는 필수입니다."))
            .andExpect(jsonPath("$.data").isEmpty());
    }

    @DisplayName("새로운 단어를 등록할 때 설명은 필수값이다.")
    @Test
    void createWordWithoutDescription() throws Exception {
        //given
        CreateWordRequest request = CreateWordRequest.builder()
            .wordKey("92288")
            .content("돼지")
            .build();

        //when //then
        mockMvc.perform(
                post("/vocabulary-service/words")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.code").value("400"))
            .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
            .andExpect(jsonPath("$.message").value("설명은 필수입니다."))
            .andExpect(jsonPath("$.data").isEmpty());
    }
}