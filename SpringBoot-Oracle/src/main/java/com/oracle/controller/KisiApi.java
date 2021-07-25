package com.oracle.controller;



import com.oracle.dto.KisiDto;
import com.oracle.model.Kisi;
import com.oracle.service.KisiService;
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
    public ResponseEntity<Kisi> kisiGuncelle(@PathVariable int id, @RequestBody KisiDto kisiDto) {
        return ResponseEntity.ok(this.kisiService.kisiGuncelle(id, kisiDto));
    }

    @GetMapping
    public ResponseEntity<List<Kisi>> kisiListele() {
        return ResponseEntity.ok(this.kisiService.kisiListele());
    }

    @GetMapping("/getir/{id}")
    public ResponseEntity<Kisi> kisiGetir(@PathVariable int id) {
        return ResponseEntity.ok(this.kisiService.kisiGetir(id));
    }


    @DeleteMapping("/sil/{id}")
    public ResponseEntity<Boolean> kisiSil(@PathVariable int id) {
        return ResponseEntity.ok(this.kisiService.kisiSil(id));
    }

}
