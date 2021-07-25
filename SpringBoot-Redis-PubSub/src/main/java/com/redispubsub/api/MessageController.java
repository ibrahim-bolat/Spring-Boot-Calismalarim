package com.redispubsub.api;




import com.redispubsub.model.Message;
import com.redispubsub.publisher.MessagePublisher;
import com.redispubsub.subscriber.MessageSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {


    private final MessagePublisher messagePublisher;

    @PostMapping("/publish")
    public void publish(@RequestBody Message message) {
        System.out.println(String.format(">> publishing : %s", message));
        messagePublisher.publish(message.toString());
    }

    @GetMapping("/subscribe")
    public List<String> getMessages(){
        return MessageSubscriber.messageList;
    }

}
