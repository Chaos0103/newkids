package com.ssafy.userservice.api.controller.member;

import com.ssafy.userservice.api.controller.ApiResponse;
import com.ssafy.userservice.api.controller.member.request.EditNicknameRequest;
import com.ssafy.userservice.api.controller.member.request.EditPasswordRequest;
import com.ssafy.userservice.api.controller.member.request.JoinRequest;
import com.ssafy.userservice.api.controller.member.request.WithdrawalRequest;
import com.ssafy.userservice.api.controller.member.response.JoinMemberResponse;
import com.ssafy.userservice.api.controller.member.response.MemberResponse;
import com.ssafy.userservice.api.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 회원 API 컨트롤러
 *
 * @author 임우택
 */
@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/")
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 가입 API
     *
     * @param request 가입할 회원의 정보
     * @return 가입된 회원의 정보
     */
    @PostMapping("/join")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<JoinMemberResponse> join(@Valid @RequestBody JoinRequest request) {
        log.debug("call MemberController#join");
        log.debug("JoinRequest={}", request);

        JoinMemberResponse response = memberService.join(request.toJoinMemberDto());
        log.debug("JoinMemberResponse={}", response);

        return ApiResponse.created(response);
    }

    /**
     * 계정 비밀번호 변경 API
     *
     * @param request 변경할 계정 비밀번호 정보
     * @return 비밀번호 변경된 계정 정보
     */
    @PatchMapping("/password")
    @ResponseStatus(HttpStatus.FOUND)
    public ApiResponse<MemberResponse> editPassword(@Valid @RequestBody EditPasswordRequest request) {
        log.debug("call MemberController#editPassword");
        log.debug("EditPasswordRequest={}", request);

        // TODO: 2023-09-05 임우택 JWT에서 회원 정보 추출
        String email = "ssafy@ssafy.com";
        log.info("access email={}", email);

        MemberResponse response = memberService.editPassword(email, request.getCurrentPwd(), request.getNewPwd());
        log.debug("MemberResponse={}", response);

        return ApiResponse.found(response);
    }

    @PatchMapping("/nickname")
    @ResponseStatus(HttpStatus.FOUND)
    public ApiResponse<MemberResponse> editNickname(@Valid @RequestBody EditNicknameRequest request) {
        log.debug("call MemberController#editNickname");
        log.debug("EditPasswordRequest={}", request);

        // TODO: 2023-09-05 임우택 JWT에서 회원 정보 추출
        String email = "ssafy@ssafy.com";
        log.info("access email={}", email);

        MemberResponse response = memberService.editNickname(email, request.getNewNickname());
        log.debug("MemberResponse={}", response);

        return ApiResponse.found(response);
    }

    /**
     * 회원 탈퇴 API
     *
     * @param request 탈퇴할 계정 비밀번호
     * @return 탈퇴 성공 여부(성공: true, 실패: false)
     */
    @DeleteMapping("/withdrawal")
    @ResponseStatus(HttpStatus.FOUND)
    public ApiResponse<Boolean> withdrawal(@Valid @RequestBody WithdrawalRequest request) {
        log.debug("call MemberController#withdrawal");
        log.debug("WithdrawalRequest={}", request);

        // TODO: 2023-09-05 임우택 JWT에서 회원 정보 추출
        String email = "ssafy@ssafy.com";
        log.info("access email={}", email);

        Boolean result = memberService.withdrawal(email, request.getPassword());
        log.debug("result={}", result);

        return ApiResponse.found(result);
    }
}
