package com.ssafy.newkids.api.service.member;

import com.ssafy.newkids.api.controller.member.response.JoinMemberResponse;
import com.ssafy.newkids.api.service.member.dto.JoinMemberDto;
import com.ssafy.newkids.api.service.member.exception.DuplicateException;
import com.ssafy.newkids.domain.member.Member;
import com.ssafy.newkids.domain.member.repository.MemberQueryRepository;
import com.ssafy.newkids.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    private final MemberRepository memberRepository;
    private final MemberQueryRepository memberQueryRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public JoinMemberResponse join(JoinMemberDto dto) {
        //이메일 중복 체크
        boolean checkEmail = memberQueryRepository.existEmail(dto.getEmail());
        if (checkEmail) {
            throw new DuplicateException("이미 사용중인 이메일입니다.");
        }

        boolean checkNickname = memberQueryRepository.existNickname(dto.getNickname());
        if (checkNickname) {
            throw new DuplicateException("이미 사용중인 닉네임입니다.");
        }

        //닉네임 중복 체크
        String encryptedPwd = passwordEncoder.encode(dto.getPassword());

        Member member = dto.toEntity(encryptedPwd);
        Member savedMember = memberRepository.save(member);

        return JoinMemberResponse.of(savedMember);
    }

    public Boolean withdrawal(String email, String password) {
        return null;
    }
}
