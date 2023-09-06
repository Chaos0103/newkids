package com.ssafy.newkids.api.controller.member.response;

import com.ssafy.newkids.domain.member.Member;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberResponse {

    private String name;
    private int age;
    private int level;
    private int exp;
    private String nickname;

    @Builder
    public MemberResponse(String name, int age, int level, int exp, String nickname) {
        this.name = name;
        this.age = age;
        this.level = level;
        this.exp = exp;
        this.nickname = nickname;
    }

    public static MemberResponse of(Member member) {
        return MemberResponse.builder()
            .name(member.getName())
            .age(member.getAge())
            .level(member.getLevel())
            .exp(member.getExp())
            .nickname(member.getNickname())
            .build();
    }
}
