package com.eventlistener.controller;


import com.eventlistener.model.Kisi;
import com.eventlistener.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kisi")
public class KisiController {

    private final KisiService kisiService;

    @PostMapping("/save")
    public void save(@RequestBody Kisi kisi) throws InterruptedException {
        this.kisiService.publisher(kisi);
        System.out.println("İşlem Başlatıldı(Controller)==>>"+kisi.toString());
    }


}
