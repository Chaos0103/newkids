package com.ssafy.userservice.api.controller.member;

import com.ssafy.userservice.api.controller.ApiResponse;
import com.ssafy.userservice.api.controller.member.request.CheckEmailRequest;
import com.ssafy.userservice.api.controller.member.request.CheckNicknameRequest;
import com.ssafy.userservice.api.controller.member.response.MemberResponse;
import com.ssafy.userservice.api.service.member.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 계정 정보 조회 API
     *
     * @param memberKey 조회할 회원 고유키
     * @return 200 조회된 계정 정보
     */
    @GetMapping("/{memberKey}/info")
    public ApiResponse<MemberResponse> getMemberInfo(@PathVariable String memberKey) {
        log.debug("call AccountController#getMemberInfo");
        log.debug("memberKey={}", memberKey);

        MemberResponse response = accountService.getMemberInfo(memberKey);
        log.debug("MemberResponse={}", response);

        return ApiResponse.ok(response);
    }

    /**
     * 회원 가입시 이메일 중복 체크 API
     *
     * @param request 중복 체크할 이메일
     * @return 200 존재하면 true, 존재하지 않으면 false
     */
    @PostMapping("/auth/email")
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
    @PostMapping("/auth/nickname")
    public ApiResponse<Boolean> checkNickname(@Valid @RequestBody CheckNicknameRequest request) {
        log.debug("call AccountController#checkNickname");
        log.debug("CheckNicknameRequest={}", request);

        Boolean result = accountService.checkNickname(request.getNickname());
        log.debug("result={}", result);

        return ApiResponse.ok(result);
    }
}
