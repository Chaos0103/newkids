package com.ssafy.newkids.api.controller.member.response;

import lombok.Builder;
import lombok.Data;

@Data
public class JoinMemberResponse {

    private String email;
    private String name;
    private int age;
    private String nickname;

    @Builder
    public JoinMemberResponse(String email, String name, int age, String nickname) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.nickname = nickname;
    }
}
