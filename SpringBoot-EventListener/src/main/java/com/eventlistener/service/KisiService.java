package com.eventlistener.service;

import com.eventlistener.event.KisiEventCreater;
import com.eventlistener.model.Kisi;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class KisiService {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void publisher(Kisi  kisi) throws InterruptedException {
        System.out.println("İşlem Yapılıyor(Service)");
        Thread.sleep(3000L);
        applicationEventPublisher.publishEvent(new KisiEventCreater(kisi));//kisi objesini yayınlıyor
    }

}
