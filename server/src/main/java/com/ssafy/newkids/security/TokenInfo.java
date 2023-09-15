package com.ssafy.newkids.security;

import lombok.Builder;
import lombok.Data;

/**
 * 토큰 정보 DTO
 *
 * @author 임우택
 */
@Data
public class TokenInfo {

    private String grantType;
    private String accessToken;
    private String refreshToken;

    @Builder
    private TokenInfo(String grantType, String accessToken, String refreshToken) {
        this.grantType = grantType;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
