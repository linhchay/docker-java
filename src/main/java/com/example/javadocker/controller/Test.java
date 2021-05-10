package com.example.javadocker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/")
    public String home() {
        System.out.println("Welcome system 222");
        String visits = (String) redisTemplate.opsForValue().get("visits");
        if (visits == null) {
            visits = "0";
            redisTemplate.opsForValue().set("visits", visits);
        }
        int x = Integer.parseInt(visits) + 1;
        redisTemplate.opsForValue().set("visits", String.valueOf(x));
        return "Num of visit is: " + x;
    }
}
