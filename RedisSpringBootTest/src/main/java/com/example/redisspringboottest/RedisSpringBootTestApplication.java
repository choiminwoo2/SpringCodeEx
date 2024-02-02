package com.example.redisspringboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class RedisSpringBootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisSpringBootTestApplication.class, args);
    }

}
