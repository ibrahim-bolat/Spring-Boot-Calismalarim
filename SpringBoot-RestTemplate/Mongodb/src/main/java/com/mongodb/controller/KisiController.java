package com.mongodb.controller;

import com.mongodb.model.Adres;
import com.mongodb.model.Kisi;
import com.mongodb.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiController {

   private final KisiRepository kisiRepository;

   @PostConstruct
   public void init(){
       Kisi kisi=new Kisi();
       kisi.setAd("beril");
       kisi.setSoyad("Nisa");
       kisi.setPrice(100);
       kisi.setDogumTarihi(new Date());
       Adres adres=new Adres();
       adres.setAdresBilgisi("ankara");
       adres.setAdresTur(Adres.AdresTur.BUSINESS);
       adres.setUrban(true);
       kisi.setAdresler(List.of(adres));
       this.kisiRepository.save(kisi);
   }
   @PostMapping
    public ResponseEntity<Kisi> ekle(@RequestBody Kisi kisi) {
        return ResponseEntity.ok(kisiRepository.save(kisi));
    }

    @GetMapping
    public ResponseEntity<List<Kisi>> tumunuListele() {
        return ResponseEntity.ok(kisiRepository.findAll());
    }
}
