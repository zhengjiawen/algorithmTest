package com.example.eurekaconsumer;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface HelloFeignService {

    @GetMapping("/hello")
    String hello(@RequestParam(required = false, defaultValue = "World!") String name);
}
