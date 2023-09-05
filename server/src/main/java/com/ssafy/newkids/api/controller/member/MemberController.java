package com.ssafy.newkids.api.controller.member;

import com.ssafy.newkids.api.ApiResponse;
import com.ssafy.newkids.api.controller.member.request.JoinRequest;
import com.ssafy.newkids.api.controller.member.request.WithdrawalRequest;
import com.ssafy.newkids.api.controller.member.response.JoinMemberResponse;
import com.ssafy.newkids.api.controller.member.response.MemberResponse;
import com.ssafy.newkids.api.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 회원 API 컨트롤러
 *
 * @author 임우택
 */
@RequiredArgsConstructor
@RestController
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ApiResponse<JoinMemberResponse> join(@Valid @RequestBody JoinRequest request) {
        log.debug("call MemberController#join");
        log.debug("JoinRequest={}", request);

        JoinMemberResponse response = memberService.join(request.toJoinMemberDto());
        log.debug("JoinMemberResponse={}", response);

        return ApiResponse.ok(response);
    }

    @DeleteMapping("/withdrawal")
    public ApiResponse<Boolean> withdrawal(@Valid @RequestBody WithdrawalRequest request) {
        log.debug("call MemberController#withdrawal");
        log.debug("WithdrawalRequest={}", request);

        // TODO: 2023-09-05 임우택 JWT에서 회원 정보 추출
        String email = "ssafy@ssafy.com";
        log.info("access email={}", email);

        Boolean result = memberService.withdrawal(email, request.getPassword());
        log.debug("result={}", result);

        return ApiResponse.ok(result);
    }
}
