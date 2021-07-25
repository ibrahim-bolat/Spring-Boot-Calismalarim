package com.mongock.controller;



import com.mongock.model.Kisi;
import com.mongock.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiApi {

    private final KisiService kisiService;

    @PostMapping
    public ResponseEntity kisiEkle(@RequestBody Kisi kisi) {
        kisiService.kisiEkle(kisi);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity kisiGuncelle(@RequestBody Kisi kisi) {
        kisiService.kisiGuncelle(kisi);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<Kisi>> kisiListele() {
        return ResponseEntity.ok(kisiService.kisiListele());
    }

    @GetMapping("/{ad}")
    public ResponseEntity adaGoreKisiGetir(@PathVariable String ad) {
        return ResponseEntity.ok(kisiService.adaGoreKisiGetir(ad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity kisiSil(@PathVariable String id) {
        kisiService.kisiSil(id);
        return ResponseEntity.noContent().build();
    }

}
