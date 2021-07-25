package com.eventlistener.listener;

import com.eventlistener.event.AdresEventCreater;
import com.eventlistener.event.KisiEventCreater;
import com.eventlistener.model.Adres;
import com.eventlistener.model.Kisi;
import com.eventlistener.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.beans.IntrospectionException;

@Component
@RequiredArgsConstructor
public class KisiEventListener {

    private final ApplicationEventPublisher applicationEventPublisher;

    @EventListener(value = KisiEventCreater.class)
    @Async
    public void kisiYakala(KisiEventCreater kisiEventCreater)   {
        try {
            Thread.sleep(3000L);
            System.out.println("Kisi Eventi Yakaladık==>"+kisiEventCreater.getSource().toString());
        }catch (Exception ex){

        }
        Adres adres =new Adres();
        adres.setId("A5578");
        adres.setAdres("KEÇİÖREN");
        adres.setPostCode(06010);
        applicationEventPublisher.publishEvent(new AdresEventCreater(adres));//kisi objesini yayınlıyor
    }
}
