package com.example.eurekafeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloFeignService helloFeignService;

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false,defaultValue = "world") String name)
    {
        return helloFeignService.hello(name);
    }

}
