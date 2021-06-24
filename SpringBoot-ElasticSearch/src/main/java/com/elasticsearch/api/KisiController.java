package com.elasticsearch.api;


import com.elasticsearch.Entity.Kisi;
import com.elasticsearch.Repo.KisiRepository;
import java.util.Calendar;
import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/kisi"})
public class KisiController {
    private final KisiRepository kisiRepository;

    @EventListener({ApplicationReadyEvent.class})
    public void init() {
        Kisi kisi = new Kisi();
        kisi.setId("12345678");
        kisi.setAd("ibrahim");
        kisi.setSoyad("Bolat");
        kisi.setAdres("Ankara");
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        this.kisiRepository.save(kisi);
    }

    @GetMapping({"/kisiler"})
    public ResponseEntity<Iterable<Kisi>> tumKisiler() {
        Iterable<Kisi> kisiler = this.kisiRepository.findAll();
        return ResponseEntity.ok(kisiler);
    }

    @GetMapping({"/{search}"})
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        List<Kisi> kisiler = this.kisiRepository.findByAdLikeOrSoyadLike(search, search);
        return ResponseEntity.ok(kisiler);
    }

    @PostMapping({"/save"})
    public ResponseEntity<Kisi> save(@RequestBody Kisi kisi) {
        return ResponseEntity.ok((Kisi)this.kisiRepository.save(kisi));
    }

    public KisiController(final KisiRepository kisiRepository) {
        this.kisiRepository = kisiRepository;
    }
}
