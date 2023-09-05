package com.ssafy.newkids.api.controller.member;

import com.ssafy.newkids.api.ApiResponse;
import com.ssafy.newkids.api.controller.member.request.LoginRequest;
import com.ssafy.newkids.api.service.member.AccountService;
import com.ssafy.newkids.security.TokenInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 계정 관련 API 컨트롤러
 *
 * @author 임우택
 */
@RequiredArgsConstructor
@RestController
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/login")
    public ApiResponse<TokenInfo> login(@Valid @RequestBody LoginRequest request) {
        log.debug("call AccountController#login");
        log.debug("LoginRequest={}", request);

        TokenInfo token = accountService.login(request.getEmail(), request.getPassword());
        log.debug("TokenInfo={}", token);

        return ApiResponse.ok(token);
    }
}
