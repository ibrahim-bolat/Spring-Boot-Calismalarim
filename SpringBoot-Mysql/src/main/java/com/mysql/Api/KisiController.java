package com.mysql.Api;


import com.mysql.Model.Adres;
import com.mysql.Model.Kisi;
import com.mysql.Repo.AdresRepository;
import com.mysql.Repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Address;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiController {

    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        Kisi kisi = new Kisi();
        kisi.setAd("ibrahim");
        kisi.setSoyad("Bolat");
        kisi.setPrice(1000);
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        this.kisiRepository.save(kisi);

        Adres adres1=new Adres();
        adres1.setAdresBilgisi("Ankara");
        adres1.setAdresTur(Adres.AdresTur.BUSINESS);
        adres1.setUrban(true);
        adres1.setKisi(kisi);

        Adres adres2=new Adres();
        adres2.setAdresBilgisi("Yozgat");
        adres2.setAdresTur(Adres.AdresTur.HOME);
        adres2.setUrban(false);
        adres2.setKisi(kisi);

        this.adresRepository.saveAll(List.of(adres1,adres2));


    }
    @GetMapping("/kisiler")
     public ResponseEntity<List<Kisi>> tumKisiler(){
        return ResponseEntity.ok(kisiRepository.findAll());
    }

    @GetMapping("/kisi/{id}")
    public ResponseEntity<Kisi> kisi(@PathVariable int id){
        return ResponseEntity.ok(kisiRepository.findById(id).get());
    }

    @PostMapping("/save")
    public ResponseEntity<Kisi> save(@RequestBody Kisi kisi){
        return ResponseEntity.ok(kisiRepository.save(kisi));
    }
}

