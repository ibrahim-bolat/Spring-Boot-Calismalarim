package com.eventlistener.listener;

import com.eventlistener.event.AdresEventCreater;
import com.eventlistener.event.KisiEventCreater;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AdresEventListener {

    @EventListener(value = AdresEventCreater.class)
    @Async
    public void adresYakala(AdresEventCreater adresEventCreater) {
        try {
            Thread.sleep(3000L);
            System.out.println("Adres Eventi Yakaladık==>" + adresEventCreater.getSource().toString());
        } catch (Exception ex) {

        }
    }
}
