package com.rabbitmq.listener;

import com.rabbitmq.model.Mesaj;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Listener {

    @RabbitListener(queues = "iboqueue")
    public void mesajListener(Mesaj mesaj){
        System.out.println("Mesa alındı");
        System.out.println(mesaj.toString());
    }

}
