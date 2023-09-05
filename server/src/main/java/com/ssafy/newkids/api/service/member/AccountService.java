package com.ssafy.newkids.api.service.member;

import com.ssafy.newkids.security.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
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
}
