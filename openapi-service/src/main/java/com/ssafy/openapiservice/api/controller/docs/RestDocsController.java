package com.ssafy.openapiservice.api.controller.docs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestDocsController {

    @GetMapping("/openapi-controller/docs/index")
    public String restDocs() {
        return "index";
    }
}
