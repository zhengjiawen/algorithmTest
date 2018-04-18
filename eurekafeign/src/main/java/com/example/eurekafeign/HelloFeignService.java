package com.example.eurekafeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-client")
public interface HelloFeignService {

    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
}
