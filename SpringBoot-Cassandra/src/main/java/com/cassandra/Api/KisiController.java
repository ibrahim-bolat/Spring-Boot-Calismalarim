package com.cassandra.Api;

import com.cassandra.Entity.Kisi;
import com.cassandra.Repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiController {

    private final KisiRepository kisiRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Kisi kisi = new Kisi();
        kisi.setId(10);
        kisi.setAd("ibrahim");
        kisi.setSoyad("Bolat");
        kisi.setPrice(1000);
        kisi.setAdres("Ankara");
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        this.kisiRepository.save(kisi);
    }
    @GetMapping("/kisiler")
     public ResponseEntity<List<Kisi>> tumKisiler(){
        return ResponseEntity.ok(kisiRepository.findAll());
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        return ResponseEntity.ok(kisiRepository.findByAdLikeOrSoyadLike(search, search));
    }
    @PostMapping("/save")
    public ResponseEntity<Kisi> save(@RequestBody Kisi kisi){
        return ResponseEntity.ok(kisiRepository.save(kisi));
    }
}

