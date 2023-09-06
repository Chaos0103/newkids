package com.ssafy.newkids.api.service.member;

import com.ssafy.newkids.IntegrationTestSupport;
import com.ssafy.newkids.api.controller.member.response.JoinMemberResponse;
import com.ssafy.newkids.api.service.member.dto.JoinMemberDto;
import com.ssafy.newkids.api.service.member.exception.DuplicateException;
import com.ssafy.newkids.domain.member.Member;
import com.ssafy.newkids.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 회원 서비스 테스트
 *
 * @author 임우택
 */
class MemberServiceTest extends IntegrationTestSupport {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("회원 가입시 입력된 이메일이 이미 사용 중 이라면 예외가 발생한다.")
    @Test
    void joinWithDuplicatedEmail() {
        //given
        JoinMemberDto dto = JoinMemberDto.builder()
            .email("ssfay@ssafy.com")
            .password("encryptedPwd")
            .name("김싸피")
            .age(10)
            .nickname("광주C205")
            .build();
        Member member = createMember(dto.getEmail(), "광주");

        //when //then
        assertThatThrownBy(() -> memberService.join(dto))
            .isInstanceOf(DuplicateException.class)
            .hasMessage("이미 사용중인 이메일입니다.");
    }

    @DisplayName("회원 가입시 입력된 닉네임이 이미 사용 중 이라면 예외가 발생한다.")
    @Test
    void joinWithDuplicatedNickname() {
        //given
        JoinMemberDto dto = JoinMemberDto.builder()
            .email("ssfay@ssafy.com")
            .password("encryptedPwd")
            .name("김싸피")
            .age(10)
            .nickname("광주C205")
            .build();
        Member member = createMember("newssafy@ssafy.com", dto.getNickname());

        //when //then
        assertThatThrownBy(() -> memberService.join(dto))
            .isInstanceOf(DuplicateException.class)
            .hasMessage("이미 사용중인 닉네임입니다.");
    }

    @DisplayName("모든 사용자는 회원 가입을 할 수 있다.")
    @Test
    void join() {
        //given
        JoinMemberDto dto = JoinMemberDto.builder()
            .email("ssafy@ssafy.com")
            .password("encryptedPwd")
            .name("김싸피")
            .age(10)
            .nickname("광주C205")
            .build();

        //when
        JoinMemberResponse response = memberService.join(dto);

        //then
        assertThat(response)
            .extracting("email", "name", "age", "nickname")
            .containsExactlyInAnyOrder("ssafy@ssafy.com", "김싸피", 10, "광주C205");
    }

    private Member createMember(String email, String nickname) {
        Member member = Member.builder()
            .email(email)
            .encryptedPwd("encryptedPwd")
            .name("김싸피")
            .age(10)
            .level(1)
            .exp(0)
            .nickname(nickname)
            .active(true)
            .build();
        return memberRepository.save(member);
    }
}
