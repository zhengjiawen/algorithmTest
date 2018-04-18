package com.example.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ConfigurationProperties
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false,defaultValue = "World!") String name){
        return "Hello "+name+" "+"you are in port:"+port;
    }


}
