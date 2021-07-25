package com.kafka.controller;


import com.kafka.model.Message;
import com.kafka.service.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final Producer producer;

    @PostMapping
    public void sendMessageToKafkaTopic(@RequestBody Message message) {
        this.producer.sendMessage(message);
    }

}
