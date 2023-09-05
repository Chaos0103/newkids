package com.ssafy.newkids.api.controller.member.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckEmailRequest {

    private String email;

    @Builder
    private CheckEmailRequest(String email) {
        this.email = email;
    }
}
