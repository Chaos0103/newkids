package com.ssafy.newkids.api.service.member;

import com.ssafy.newkids.api.controller.member.response.MemberResponse;
import com.ssafy.newkids.security.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 계정 서비스
 *
 * @author 임우택
 */
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class AccountService {

    /**
     * 계정 로그인
     *
     * @param email 계정 이메일
     * @param password 계정 비밀번호
     * @return JWT 토큰 정보
     */
    public TokenInfo login(String email, String password) {
        return null;
    }

    /**
     *  계정 정보 조회
     *
     * @param email 계정 이메일
     * @return 조회된 계정 정보
     */
    public MemberResponse getMemberInfo(String email) {
        return null;
    }

    public Boolean checkEmail(String email) {
        return null;
    }

    public Boolean checkNickname(String nickname) {
        return null;
    }
}
