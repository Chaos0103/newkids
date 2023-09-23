package com.ssafy.vocabularyservice.api.controller.docs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class RestDocsController {

    @GetMapping("/vocabulary-service/docs/index")
    public String restDocs() {
        return "index";
    }
}
