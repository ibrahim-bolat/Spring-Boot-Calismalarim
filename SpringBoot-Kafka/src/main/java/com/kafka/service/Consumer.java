package com.kafka.service;


import com.kafka.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class Consumer {

    @KafkaListener(topics = "${kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(@Payload Message message) {
        log.info(String.format("# -> Consumer mesajı -> %s", message));
    }
}
