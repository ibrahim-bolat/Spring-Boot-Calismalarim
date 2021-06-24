package com.rabbitmq.producer;

import com.rabbitmq.model.Mesaj;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.routing-key.name}")
    private String routingName;

    @Value("${sp.rabbitmq.exchange.name}")
    private String exchangeName;

    @PostConstruct
    public void init(){
        Mesaj mesaj=new Mesaj();
        mesaj.setMesajId(UUID.randomUUID().toString());
        mesaj.setCount(100);
        mesaj.setCreatedAt(new Date());
        mesaj.setSeen(false);
        mesaj.setMessage("naber canım nasılsın");
        sendMessage(mesaj);
    }

    public void sendMessage(Mesaj mesaj){
        System.out.println("Mesaj id: "+mesaj.getMesajId());
      rabbitTemplate.convertAndSend(exchangeName,routingName,mesaj);
    }
}
