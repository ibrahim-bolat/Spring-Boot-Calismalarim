package com.mongodb.controller;


import com.mongodb.dto.KisiDto;
import com.mongodb.model.Kisi;
import com.mongodb.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiApi {

    private final KisiService kisiService;

    @PostMapping("/ekle")
    public ResponseEntity<Kisi> kisiEkle(@RequestBody KisiDto kisiDto) {
        return ResponseEntity.ok(this.kisiService.kisiEkle(kisiDto));
    }

    @PutMapping("/guncelle/{id}")
    public ResponseEntity<Kisi> kisiGuncelle(@PathVariable String id, @RequestBody KisiDto kisiDto) {
        return ResponseEntity.ok(this.kisiService.kisiGuncelle(id, kisiDto));
    }

    @GetMapping
    public ResponseEntity<List<Kisi>> kisiListele() {
        return ResponseEntity.ok(this.kisiService.kisiListele());
    }

    @GetMapping("/getir/{id}")
    public ResponseEntity<Kisi> kisiGetir(@PathVariable String id) {
        return ResponseEntity.ok(this.kisiService.kisiGetir(id));
    }


    @DeleteMapping("/sil/{id}")
    public ResponseEntity<Boolean> kisiSil(@PathVariable String id) {
        return ResponseEntity.ok(this.kisiService.kisiSil(id));
    }

}
