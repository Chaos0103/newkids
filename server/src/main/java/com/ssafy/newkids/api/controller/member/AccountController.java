package com.ssafy.newkids.api.controller.member;

import com.ssafy.newkids.api.ApiResponse;
import com.ssafy.newkids.api.controller.member.request.CheckEmailRequest;
import com.ssafy.newkids.api.controller.member.request.CheckNicknameRequest;
import com.ssafy.newkids.api.controller.member.request.LoginRequest;
import com.ssafy.newkids.api.controller.member.response.MemberResponse;
import com.ssafy.newkids.api.service.member.AccountService;
import com.ssafy.newkids.security.TokenInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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

//    @PostMapping("/login")
    public ApiResponse<TokenInfo> login(@Valid @RequestBody LoginRequest request) {
        log.debug("call AccountController#login");
        log.debug("LoginRequest={}", request);

        TokenInfo token = accountService.login(request.getEmail(), request.getPassword());
        log.debug("TokenInfo={}", token);

        return ApiResponse.ok(token);
    }

    @GetMapping("/info")
    public ApiResponse<MemberResponse> getMemberInfo() {
        log.debug("call AccountController#getMemberInfo");

        // TODO: 2023-09-05 임우택 JWT에서 회원 정보 추출
        String email = "ssafy@ssafy.com";
        log.info("access email={}", email);

        MemberResponse response = accountService.getMemberInfo(email);
        log.debug("MemberResponse={}", response);

        return ApiResponse.ok(response);
    }

    @PostMapping("/check/email")
    public ApiResponse<Boolean> checkEmail(@Valid @RequestBody CheckEmailRequest request) {
        Boolean result = accountService.checkEmail(request.getEmail());
        return ApiResponse.ok(result);
    }

    @PostMapping("/check/nickname")
    public ApiResponse<Boolean> checkNickname(@Valid @RequestBody CheckNicknameRequest request) {
        Boolean result = accountService.checkNickname(request.getNickname());
        return ApiResponse.ok(result);
    }
}
