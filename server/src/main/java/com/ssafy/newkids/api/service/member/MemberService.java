package com.ssafy.newkids.api.service.member;

import com.ssafy.newkids.api.controller.member.response.JoinMemberResponse;
import com.ssafy.newkids.api.service.member.dto.JoinMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 회원 서비스
 *
 * @author 임우택
 */
@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {

    public JoinMemberResponse join(JoinMemberDto dto) {
        return null;
    }

    public Boolean withdrawal(String email, String password) {
        return null;
    }
}
