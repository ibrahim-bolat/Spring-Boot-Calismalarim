package com.validation.controller;


import com.validation.dto.KisiDto;
import com.validation.model.Kisi;
import com.validation.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiApi {

    private final KisiService kisiService;

    @PostMapping("/ekle")
    public KisiDto kisiEkle(@Valid @RequestBody KisiDto kisidto) {
        return this.kisiService.kisiEkle(kisidto);
    }

    @PutMapping("/guncelle/{id}")
    public KisiDto kisiGuncelle(@PathVariable String id,@Valid @RequestBody KisiDto kisiDto){
        return this.kisiService.kisiGuncelle(id, kisiDto);
    }

    @GetMapping
    public List<KisiDto> kisiListele() {
        return this.kisiService.kisiListele();
    }

    @GetMapping("/getir/{id}")
    public KisiDto kisiGetir(@PathVariable String id){
        return this.kisiService.kisiGetir(id);
    }


    @DeleteMapping("/sil/{id}")
    public Boolean kisiSil(@PathVariable String id) {
        return this.kisiService.kisiSil(id);
    }

}
