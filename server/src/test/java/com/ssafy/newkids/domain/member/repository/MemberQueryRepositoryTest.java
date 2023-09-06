package com.ssafy.newkids.domain.member.repository;

import com.ssafy.newkids.IntegrationTestSupport;
import com.ssafy.newkids.domain.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

/**
 * 회원 쿼리용 저장소 테스트
 *
 * @author 임우택
 */
class MemberQueryRepositoryTest extends IntegrationTestSupport {

    @Autowired
    private MemberQueryRepository memberQueryRepository;

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("이미 등록된 이메일이라면 true를 반환한다.")
    @Test
    void existEmailWithTrue() {
        //given
        Member member = createMember();

        //when
        boolean result = memberQueryRepository.existEmail("ssafy@ssafy.com");

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("사용 가능한 이메일이라면 false를 반환한다.")
    @Test
    void existEmailWithFalse() {
        //given

        //when
        boolean result = memberQueryRepository.existEmail("ssafy@ssafy.com");

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("이미 사용중인 닉네임이라면 true를 반환한다.")
    @Test
    void existNicknameWithTrue() {
        //given
        Member member = createMember();

        //when
        boolean result = memberQueryRepository.existNickname("광주C205");

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("사용 가능한 닉네임이라면 false를 반환한다.")
    @Test
    void existNicknameWithFalse() {
        //given

        //when
        boolean result = memberQueryRepository.existNickname("광주C205");

        //then
        assertThat(result).isFalse();
    }

    private Member createMember() {
        Member member = Member.builder()
            .email("ssafy@ssafy.com")
            .encryptedPwd("encryptedPwd")
            .name("김싸피")
            .age(10)
            .level(1)
            .exp(0)
            .nickname("광주C205")
            .active(true)
            .build();
        return memberRepository.save(member);
    }
}