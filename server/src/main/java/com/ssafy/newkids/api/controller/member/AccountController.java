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

    /**
     * 계정 정보 조회 API
     *
     * @return 200 조회된 계정 정보
     */
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

    /**
     * 회원 가입시 이메일 중복 체크 API
     *
     * @param request 중복 체크할 이메일
     * @return 200 존재하면 true, 존재하지 않으면 false
     */
    @PostMapping("/check/email")
    public ApiResponse<Boolean> checkEmail(@Valid @RequestBody CheckEmailRequest request) {
        log.debug("call AccountController#checkEmail");
        log.debug("CheckEmailRequest={}", request);

        Boolean result = accountService.checkEmail(request.getEmail());
        log.debug("result={}", result);

        return ApiResponse.ok(result);
    }

    /**
     * 회원 가입시 닉네임 중복 체크 API
     *
     * @param request 중복 체크할 닉네임
     * @return 200 존재하면 true, 존재하지 않으면 false
     */
    @PostMapping("/check/nickname")
    public ApiResponse<Boolean> checkNickname(@Valid @RequestBody CheckNicknameRequest request) {
        log.debug("call AccountController#checkNickname");
        log.debug("CheckNicknameRequest={}", request);

        Boolean result = accountService.checkNickname(request.getNickname());
        log.debug("result={}", result);

        return ApiResponse.ok(result);
    }
}
