package com.elasticsearch.controller;


import com.elasticsearch.dto.KisiDto;
import com.elasticsearch.entity.Kisi;
import com.elasticsearch.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<Iterable<Kisi>> kisiListele() {
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
