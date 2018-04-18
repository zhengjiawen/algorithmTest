package com.example.eurekaribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {


    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false,defaultValue = "World!") String name){
        return consumerService.hello(name);
    }
}
