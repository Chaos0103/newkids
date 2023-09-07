package com.ssafy.newkids.docs.article;

import com.ssafy.newkids.api.controller.article.ArticleController;
import com.ssafy.newkids.api.controller.article.response.ArticleDetailResponse;
import com.ssafy.newkids.api.controller.article.response.ArticleResponse;
import com.ssafy.newkids.api.service.article.ArticleQueryService;
import com.ssafy.newkids.docs.RestDocsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.restdocs.payload.JsonFieldType;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ArticleControllerDocsTest extends RestDocsSupport {

    private final ArticleQueryService articleQueryService = mock(ArticleQueryService.class);

    @Override
    protected Object initController() {
        return new ArticleController(articleQueryService);
    }

    @DisplayName("기사 조회 API")
    @Test
    void getArticles() throws Exception {
        ArticleResponse response1 = ArticleResponse.builder()
            .articleId(1L)
            .title("홍진식 돼지")
            .publishedDate("최영환 기자")
            .content("홍진식은 사람의 탈을 쓴 돼지로 밝혀져...")
            .image("http://pig.jpg")
            .build();
        ArticleResponse response2 = ArticleResponse.builder()
            .articleId(2L)
            .title("최영환 돼지")
            .publishedDate("홍진식 기자")
            .content("최근 국과수의 연구 결과 최영환이 더 돼지로 밝혀졌다.")
            .image("http://pigpig.jpg")
            .build();

        List<ArticleResponse> content = List.of(response1, response2);
        PageRequest pageRequest = PageRequest.of(0, 20);

        given(articleQueryService.getArticles(anyString(), anyString(), any(Pageable.class)))
            .willReturn(new PageImpl<>(content, pageRequest, 100));

        mockMvc.perform(
                get("/articles")
                    .param("keyword", "돼지")
                    .param("term", "2023-09-07")
                    .param("pageNum", "1")
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("search-article",
                preprocessResponse(prettyPrint()),
                requestParameters(
                    parameterWithName("keyword")
                        .description("검색할 키워드"),
                    parameterWithName("term")
                        .description("검색할 기간"),
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
                    fieldWithPath("data.content[].articleId").type(JsonFieldType.NUMBER)
                        .description("기사 PK"),
                    fieldWithPath("data.content[].title").type(JsonFieldType.STRING)
                        .description("기사 타이틀"),
                    fieldWithPath("data.content[].publishedDate").type(JsonFieldType.STRING)
                        .description("기사 작성일"),
                    fieldWithPath("data.content[].content").type(JsonFieldType.STRING)
                        .description("기사 내용"),
                    fieldWithPath("data.content[].image").type(JsonFieldType.STRING)
                        .description("기사 썸네일"),
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

    @DisplayName("기사 상세 조회 API")
    @Test
    void getArticle() throws Exception {
        ArticleDetailResponse response = ArticleDetailResponse.builder()
            .title("행복, 우리 모두의 목표")
            .publishedDate("2023.03.15 15:07")
            .content(",풍요로움, 부유함, 평화로움, 즐거움, 건강함, 보람참, 존경받음, 사이좋음…. 물질적인 것부터 정신적인 것까지, 스스로 획득하는 것에서부터 사회가 제공하는 것까지. 이 많은 단어를 하나의 이름으")
            .writer("홍진식 기자")
            .images(List.of("http://image1.png", "http://image2.png"))
            .keywords(List.of("돼지", "금쪽이", "SSAFY"))
            .build();

        given(articleQueryService.getArticle(anyLong()))
            .willReturn(response);

        mockMvc.perform(
                get("/articles/{articleId}", 1L)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("search-detail-article",
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
                    fieldWithPath("data.title").type(JsonFieldType.STRING)
                        .description("기사제목"),
                    fieldWithPath("data.publishedDate").type(JsonFieldType.STRING)
                        .description("기사작성일"),
                    fieldWithPath("data.content").type(JsonFieldType.STRING)
                        .description("기사내용"),
                    fieldWithPath("data.writer").type(JsonFieldType.STRING)
                        .description("기사작성자"),
                    fieldWithPath("data.images[]").type(JsonFieldType.ARRAY)
                        .description("기사이미지"),
                    fieldWithPath("data.keywords[]").type(JsonFieldType.ARRAY)
                        .description("기사키워드")
                )
            ));

    }
}
