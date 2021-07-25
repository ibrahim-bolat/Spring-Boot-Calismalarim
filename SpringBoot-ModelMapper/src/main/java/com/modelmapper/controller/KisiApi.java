package com.modelmapper.controller;


import com.modelmapper.service.KisiService;
import com.validation.dto.KisiDto;
import com.modelmapper.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiApi {

    private final KisiService kisiService;

    @PostMapping("/ekle")
    public KisiDto kisiEkle( @RequestBody KisiDto kisidto) {
        return this.kisiService.kisiEkle(kisidto);
    }

    @PutMapping("/guncelle/{id}")
    public KisiDto kisiGuncelle(@PathVariable String id, @RequestBody KisiDto kisiDto){
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
