package com.example.firstSpringproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON을 반환
public class FirstApiController {

    @GetMapping("/api/hello")
    public String hello() {
        return "hello word!";
    }
}
