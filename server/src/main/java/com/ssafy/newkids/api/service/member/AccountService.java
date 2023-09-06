package com.ssafy.newkids.api.service.member;

import com.ssafy.newkids.api.controller.member.response.MemberResponse;
import com.ssafy.newkids.domain.member.Member;
import com.ssafy.newkids.domain.member.repository.MemberQueryRepository;
import com.ssafy.newkids.domain.member.repository.MemberRepository;
import com.ssafy.newkids.security.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * 계정 서비스
 *
 * @author 임우택
 */
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class AccountService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final MemberQueryRepository memberQueryRepository;

    /**
     * 계정 로그인
     *
     * @param email    계정 이메일
     * @param password 계정 비밀번호
     * @return JWT 토큰 정보
     */
    public TokenInfo login(String email, String password) {
        return null;
    }

    /**
     * 계정 정보 조회
     *
     * @param email 계정 이메일
     * @return 조회된 계정 정보
     */
    public MemberResponse getMemberInfo(String email) {
        return memberQueryRepository.findByEmail(email)
            .orElseThrow(NoSuchElementException::new);
    }

    public Boolean checkEmail(String email) {
        return null;
    }

    public Boolean checkNickname(String nickname) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member> findMember = memberRepository.findByEmail(email);

        if (findMember.isEmpty()) {
            throw new UsernameNotFoundException("등록되지 않은 사용자입니다.");
        }

        Member member = findMember.get();
        return new User(member.getEmail(), member.getEncryptedPwd(),
            true, true, true, true,
            List.of(new SimpleGrantedAuthority("MEMBER")));
    }

    public Member getUserDetailsByEmail(String email) {
        Optional<Member> findMember = memberRepository.findByEmail(email);

        if (findMember.isEmpty()) {
            throw new UsernameNotFoundException("등록되지 않은 사용자입니다.");
        }

        return findMember.get();
    }
}
