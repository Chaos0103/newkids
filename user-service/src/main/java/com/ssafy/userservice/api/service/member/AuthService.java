package com.ssafy.userservice.api.service.member;

import com.ssafy.userservice.domain.member.repository.MemberQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class AuthService {

    private final MemberQueryRepository memberQueryRepository;

    /**
     * 이메일 중복 체크
     *
     * @param email 중복 체크할 대상 이메일
     * @return 존재하면 true, 존재하지 않으면 false
     */
    public boolean checkEmail(String email) {
        return memberQueryRepository.existEmail(email);
    }

    /**
     * 닉네임 중복 체크
     *
     * @param nickname 중복 체크할 대상 닉네임
     * @return 존재하면 true, 존재하지 않으면 false
     */
    public boolean checkNickname(String nickname) {
        return memberQueryRepository.existNickname(nickname);
    }
}
