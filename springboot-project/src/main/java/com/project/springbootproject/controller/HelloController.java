package com.project.springbootproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// json 반환하는 컨트롤러로 만들어 줌(@Controller와 @ResponseBody를 합친 어노테이션)
public class HelloController {

    @GetMapping("/test") // HTTP method인 Get의 요청을 받을 수 있는 API를 만들어 줌.
    public String test() {
        return "Hello World!!!";
    }
}
