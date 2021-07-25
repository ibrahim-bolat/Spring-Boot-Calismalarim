package com.unittest.controller;



import com.unittest.dto.KisiDto;
import com.unittest.service.KisiService;
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
    public ResponseEntity<KisiDto> kisiEkle(@RequestBody KisiDto kisidto) {
        return ResponseEntity.ok(this.kisiService.kisiEkle(kisidto));
    }

    @PutMapping("/guncelle/{id}")
    public ResponseEntity<KisiDto> kisiGuncelle(@PathVariable String id, @RequestBody KisiDto kisiDto){
        return ResponseEntity.ok(this.kisiService.kisiGuncelle(id, kisiDto));
    }

    @GetMapping
    public ResponseEntity<List<KisiDto>> kisiListele() {
        return ResponseEntity.ok(this.kisiService.kisiListele());
    }

    @GetMapping("/getir/{id}")
    public ResponseEntity<KisiDto> kisiGetir(@PathVariable String id){
        return ResponseEntity.ok(this.kisiService.kisiGetir(id));
    }


    @DeleteMapping("/sil/{id}")
    public ResponseEntity<Boolean> kisiSil(@PathVariable String id) {
        return ResponseEntity.ok(this.kisiService.kisiSil(id));
    }

}
