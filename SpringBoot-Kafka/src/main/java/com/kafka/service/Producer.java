package com.kafka.service;


import com.kafka.model.Message;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Value("${kafka.topic}")
    private String TOPIC;

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public void sendMessage(Message message){
        logger.info(String.format("# -> Producer mesajı -> %s", message));
        this.kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(), message);
    }
}
