package com.springbootwebsocket.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
public class Message {
    private String nickName;
    private String messageText;
}
