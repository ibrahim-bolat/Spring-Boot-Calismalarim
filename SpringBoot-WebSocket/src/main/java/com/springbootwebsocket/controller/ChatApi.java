package com.springbootwebsocket.controller;

import com.springbootwebsocket.model.Message;
import com.springbootwebsocket.model.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@CrossOrigin
@RequiredArgsConstructor
public class ChatApi {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")//mes bodyden alıp /chat adresinde karşılıyoruz
    public void chatEndPoint(@Payload Message message){
        String time = new SimpleDateFormat("HH:mm dd/MM/yyyy").format(new Date());
        MessageDto messageDto=new MessageDto();
        messageDto.setNickName(message.getNickName());
        messageDto.setMessageText(message.getMessageText());
        messageDto.setTime(time);
        simpMessagingTemplate.convertAndSend("/topic",messageDto);//ve /topic adresine gönderiyoruz

    }
}
