package com.example.eurekaribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class ConsumerService {
    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloFallback")
    @CacheResult
    public String hello(@CacheKey("name") String name){
        return restTemplate.getForObject("http://eureka-client/hello?name={name}",String.class,name);
    }

    @HystrixCommand(fallbackMethod = "helloFallback")
    public Future<String> helloAsync(String name){
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForObject("http://eureka-client/hello?name={name}",String.class,name);
            }
        };
    }

    public String helloFallback(String name , Throwable e)
    {
        e.printStackTrace();
        return "fallback"+name+e.toString();
    }
}
