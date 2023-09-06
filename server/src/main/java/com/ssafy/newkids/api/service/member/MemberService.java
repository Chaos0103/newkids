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

import java.util.NoSuchElementException;

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

    /**
     * 회원 가입
     *
     * @param dto 회원의 정보
     * @return 가입을 성공한 회원의 기본 정보
     * @throws DuplicateException 이미 사용중인 이메일, 닉네임인 경우
     */
    public JoinMemberResponse join(JoinMemberDto dto) {
        duplicationCheckByEmail(dto.getEmail());
        duplicationCheckByNickname(dto.getNickname());

        Member savedMember = createMember(dto);

        return JoinMemberResponse.of(savedMember);
    }

    /**
     * 회원 탈퇴
     *
     * @param email 탈퇴할 계정 이메일
     * @param password 탈퇴할 계정 비밀번호
     * @return 탈퇴 성공 여부(성공: true, 실패: false)
     * @throws NoSuchElementException 계정 이메일이 일치하는 회원이 존재하지 않을 경우
     */
    public boolean withdrawal(String email, String password) {
        Member member = getMemberEntity(email);

        if (isMatchPassword(password, member)) {
            member.deActive();
            return true;
        }

        return false;
    }

    /**
     * 이메일 중복 체크
     *
     * @param email 중복 체크할 이메일
     * @throws DuplicateException 이미 사용중인 이메일인 경우
     */
    private void duplicationCheckByEmail(String email) {
        boolean checkEmail = memberQueryRepository.existEmail(email);
        if (checkEmail) {
            throw new DuplicateException("이미 사용중인 이메일입니다.");
        }
    }

    /**
     * 닉네임 중복 체크
     *
     * @param nickname 중복 체크할 닉네임
     * @throws DuplicateException 이미 사용중인 닉네임인 경우
     */
    private void duplicationCheckByNickname(String nickname) {
        boolean checkNickname = memberQueryRepository.existNickname(nickname);
        if (checkNickname) {
            throw new DuplicateException("이미 사용중인 닉네임입니다.");
        }
    }

    /**
     * 회원 엔티티 생성 및 DB 저장
     *
     * @param dto 회원 정보
     * @return 가입된 회원 엔티티
     */
    private Member createMember(JoinMemberDto dto) {
        String encryptedPwd = passwordEncoder.encode(dto.getPassword());

        Member member = dto.toEntity(encryptedPwd);
        return memberRepository.save(member);
    }

    /**
     * 계정 이메일로 회원 엔티티 조회
     *
     * @param email 조회할 계정 이메일
     * @return 조회된 회원 엔티티
     * @throws NoSuchElementException 계정 이메일이 일치하는 회원이 존재하지 않을 경우
     */
    private Member getMemberEntity(String email) {
        return memberRepository.findByEmail(email)
            .orElseThrow(NoSuchElementException::new);
    }

    /**
     * 비밀번호 일치 여부
     *
     * @param password 입력받은 계정 비밀번호
     * @param member 일치 여부를 판별할 회원 엔티티
     * @return 비밀번호 일치 여부(일치: true, 불일치: false)
     */
    private boolean isMatchPassword(String password, Member member) {
        return passwordEncoder.matches(password, member.getEncryptedPwd());
    }
}
