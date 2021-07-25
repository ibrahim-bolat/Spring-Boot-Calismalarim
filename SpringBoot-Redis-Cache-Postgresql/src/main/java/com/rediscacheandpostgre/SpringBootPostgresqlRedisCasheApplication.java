package com.rediscacheandpostgre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootPostgresqlRedisCasheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPostgresqlRedisCasheApplication.class, args);
    }

}
