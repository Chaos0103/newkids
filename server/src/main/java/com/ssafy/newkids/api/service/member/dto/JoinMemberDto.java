package com.ssafy.newkids.api.service.member.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class JoinMemberDto {

    private String email;
    private String password;
    private String name;
    private Integer age;
    private String nickname;

    @Builder
    private JoinMemberDto(String email, String password, String name, Integer age, String nickname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.nickname = nickname;
    }
}
