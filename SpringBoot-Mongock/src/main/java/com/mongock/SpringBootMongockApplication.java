package com.mongock;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class SpringBootMongockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongockApplication.class, args);
    }

}
