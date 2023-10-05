package com.ssafy.newkids.domain.member.repository;

import com.ssafy.newkids.IntegrationTestSupport;
import com.ssafy.newkids.domain.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 회원 저장소 테스트
 *
 * @author 임우택
 */
class MemberRepositoryTest extends IntegrationTestSupport {

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("이메일로 회원 엔티티를 조회할 수 있다.")
    @Test
    void findByEmail() {
        //given
        Member member = createMember();

        //when
        Optional<Member> findMember = memberRepository.findByEmail("ssafy@ssafy.com");

        //then
        assertThat(findMember).isPresent();
        assertThat(findMember.get().getNickname()).isEqualTo("광주C205");
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