package com.ssafy.newkids.docs.vocabulary;

import com.ssafy.newkids.api.controller.vocabulary.WordController;
import com.ssafy.newkids.api.controller.vocabulary.request.CreateWordRequest;
import com.ssafy.newkids.api.controller.vocabulary.request.EditWordRequest;
import com.ssafy.newkids.api.controller.vocabulary.response.WordResponse;
import com.ssafy.newkids.api.service.vocabulary.WordQueryService;
import com.ssafy.newkids.api.service.vocabulary.WordService;
import com.ssafy.newkids.api.service.vocabulary.dto.CreateWordDto;
import com.ssafy.newkids.api.service.vocabulary.dto.EditWordDto;
import com.ssafy.newkids.docs.RestDocsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WordControllerDocsController extends RestDocsSupport {

    private final WordService wordService = mock(WordService.class);
    private final WordQueryService wordQueryService = mock(WordQueryService.class);

    @Override
    protected Object initController() {
        return new WordController(wordService, wordQueryService);
    }

    @DisplayName("단어 등록 API")
    @Test
    void createWord() throws Exception {
        CreateWordRequest request = CreateWordRequest.builder()
            .wordKey("92288")
            .word("돼지")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .build();

        WordResponse response = WordResponse.builder()
            .wordKey("92288")
            .word("돼지")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .build();

        given(wordService.createWord(any(CreateWordDto.class)))
            .willReturn(response);

        mockMvc.perform(
                post("/words")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isCreated())
            .andDo(document("create-word",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("wordKey").type(JsonFieldType.STRING)
                        .description("단어키"),
                    fieldWithPath("word").type(JsonFieldType.STRING)
                        .description("단어"),
                    fieldWithPath("description").type(JsonFieldType.STRING)
                        .description("단어설명")
                ),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.OBJECT)
                        .description("응답데이터"),
                    fieldWithPath("data.wordKey").type(JsonFieldType.STRING)
                        .description("단어키"),
                    fieldWithPath("data.word").type(JsonFieldType.STRING)
                        .description("단어"),
                    fieldWithPath("data.description").type(JsonFieldType.STRING)
                        .description("단어설명")
                )
            ));
    }

    @DisplayName("단어 조회 API")
    @Test
    void getWords() throws Exception {
        WordResponse response1 = WordResponse.builder()
            .wordKey("92288")
            .word("돼지")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .build();
        WordResponse response2 = WordResponse.builder()
            .wordKey("92289")
            .word("홍진식돼지")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .build();

        List<WordResponse> responses = List.of(response1, response2);

        PageRequest pageRequest = PageRequest.of(0, 20);
        given(wordQueryService.getWords(anyString(), any(Pageable.class)))
            .willReturn(new PageImpl<>(responses, pageRequest, 100));

        mockMvc.perform(
                get("/words")
                    .param("keyword", "돼지")
                    .param("pageNum", "1")
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("search-words",
                preprocessResponse(prettyPrint()),
                requestParameters(
                    parameterWithName("keyword")
                        .description("검색할 키워드"),
                    parameterWithName("pageNum")
                        .description("페이지 번호")
                ),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.OBJECT)
                        .description("응답데이터"),
                    fieldWithPath("data.content").type(JsonFieldType.ARRAY)
                        .description("낙찰 내역 데이터"),
                    fieldWithPath("data.content[].wordKey").type(JsonFieldType.STRING)
                        .description("단어 키"),
                    fieldWithPath("data.content[].word").type(JsonFieldType.STRING)
                        .description("단어"),
                    fieldWithPath("data.content[].description").type(JsonFieldType.STRING)
                        .description("단어 설명"),
                    fieldWithPath("data.pageable").type(JsonFieldType.OBJECT)
                        .description("응답 데이터"),
                    fieldWithPath("data.pageable.sort").type(JsonFieldType.OBJECT)
                        .description("응답 데이터"),
                    fieldWithPath("data.pageable.sort.empty").type(JsonFieldType.BOOLEAN)
                        .description("응답 데이터"),
                    fieldWithPath("data.pageable.sort.sorted").type(JsonFieldType.BOOLEAN)
                        .description("응답 데이터"),
                    fieldWithPath("data.pageable.sort.unsorted").type(JsonFieldType.BOOLEAN)
                        .description("응답 데이터"),
                    fieldWithPath("data.pageable.offset").type(JsonFieldType.NUMBER)
                        .description("응답 데이터"),
                    fieldWithPath("data.pageable.pageNumber").type(JsonFieldType.NUMBER)
                        .description("응답 데이터"),
                    fieldWithPath("data.pageable.pageSize").type(JsonFieldType.NUMBER)
                        .description("응답 데이터"),
                    fieldWithPath("data.pageable.paged").type(JsonFieldType.BOOLEAN)
                        .description("응답 데이터"),
                    fieldWithPath("data.pageable.unpaged").type(JsonFieldType.BOOLEAN)
                        .description("응답 데이터"),
                    fieldWithPath("data.totalPages").type(JsonFieldType.NUMBER)
                        .description("총 페이지 수"),
                    fieldWithPath("data.totalElements").type(JsonFieldType.NUMBER)
                        .description("DB의 전체 데이터 갯수"),
                    fieldWithPath("data.last").type(JsonFieldType.BOOLEAN)
                        .description("마지막 페이지라면 true"),
                    fieldWithPath("data.size").type(JsonFieldType.NUMBER)
                        .description("페이지 당 나타낼 수 있는 데이터의 갯수"),
                    fieldWithPath("data.sort").type(JsonFieldType.OBJECT)
                        .description("응답 데이터"),
                    fieldWithPath("data.sort.empty").type(JsonFieldType.BOOLEAN)
                        .description("응답 데이터"),
                    fieldWithPath("data.sort.sorted").type(JsonFieldType.BOOLEAN)
                        .description("응답 데이터"),
                    fieldWithPath("data.sort.unsorted").type(JsonFieldType.BOOLEAN)
                        .description("응답 데이터"),
                    fieldWithPath("data.number").type(JsonFieldType.NUMBER)
                        .description("현재 페이지 번호"),
                    fieldWithPath("data.numberOfElements").type(JsonFieldType.NUMBER)
                        .description("실제 데이터의 갯수"),
                    fieldWithPath("data.first").type(JsonFieldType.BOOLEAN)
                        .description("첫번째 페이지이면 true"),
                    fieldWithPath("data.empty").type(JsonFieldType.BOOLEAN)
                        .description("리스트가 비어있는지 여부")

                )
            ));
    }

    @DisplayName("단어 수정 API")
    @Test
    void editWord() throws Exception {
        EditWordRequest request = EditWordRequest.builder()
            .word("홍진식")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .build();

        WordResponse response = WordResponse.builder()
            .wordKey("92288")
            .word("홍진식")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .build();

        given(wordService.editWord(anyString(), any(EditWordDto.class)))
            .willReturn(response);

        mockMvc.perform(
                patch("/words/{wordKey}", 92288)
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isFound())
            .andDo(document("edit-word",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("word").type(JsonFieldType.STRING)
                        .description("단어"),
                    fieldWithPath("description").type(JsonFieldType.STRING)
                        .description("단어설명")
                ),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.OBJECT)
                        .description("응답데이터"),
                    fieldWithPath("data.wordKey").type(JsonFieldType.STRING)
                        .description("단어키"),
                    fieldWithPath("data.word").type(JsonFieldType.STRING)
                        .description("단어"),
                    fieldWithPath("data.description").type(JsonFieldType.STRING)
                        .description("단어설명")
                )
            ));
    }

    @DisplayName("단어 삭제 API")
    @Test
    void removeWord() throws Exception {
        WordResponse response = WordResponse.builder()
            .wordKey("92288")
            .word("돼지")
            .description("멧돼짓과의 포유류. 몸무게는 200~250kg이며, 다리와 꼬리가 짧고 주둥이가 삐죽하다.")
            .build();

        given(wordService.removeWord(anyString()))
            .willReturn(response);

        mockMvc.perform(
                delete("/words/{wordKey}", 92288)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isFound())
            .andDo(document("remove-word",
                preprocessResponse(prettyPrint()),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.OBJECT)
                        .description("응답데이터"),
                    fieldWithPath("data.wordKey").type(JsonFieldType.STRING)
                        .description("단어키"),
                    fieldWithPath("data.word").type(JsonFieldType.STRING)
                        .description("단어"),
                    fieldWithPath("data.description").type(JsonFieldType.STRING)
                        .description("단어설명")
                )
            ));
    }
}
