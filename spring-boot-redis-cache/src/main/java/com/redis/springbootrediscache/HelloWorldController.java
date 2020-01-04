package com.redis.springbootrediscache;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hellow")
    public String helloWorld() {
        return "Hello";
    }
}
