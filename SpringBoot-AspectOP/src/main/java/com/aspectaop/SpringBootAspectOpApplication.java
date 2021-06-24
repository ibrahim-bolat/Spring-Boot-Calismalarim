package com.aspectaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBootAspectOpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAspectOpApplication.class, args);
    }

}
