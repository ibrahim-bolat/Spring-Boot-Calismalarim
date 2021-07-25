package com.unittest;

import com.unittest.model.Kisi;
import com.unittest.repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootUnitTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootUnitTestApplication.class, args);
    }


}
