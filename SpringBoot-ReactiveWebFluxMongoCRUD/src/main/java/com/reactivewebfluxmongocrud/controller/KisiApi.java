package com.reactivewebfluxmongocrud.controller;



import com.reactivewebfluxmongocrud.model.Kisi;
import com.reactivewebfluxmongocrud.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiApi {

    private final KisiService kisiService;

    @PostMapping("/ekle")
    public Mono<Kisi> kisiEkle(@RequestBody Mono<Kisi> kisiMono) {
        return kisiMono.flatMap(this.kisiService::kisiEkle);
    }

    @PutMapping("/guncelle/{id}")
    public Mono<Kisi> kisiGuncelle(@PathVariable String id, @RequestBody Mono<Kisi> kisiMono){
        return this.kisiService.kisiGuncelle(id, kisiMono);
    }

    @GetMapping
    public Flux<Kisi> kisiListele() {
        return this.kisiService.kisiListele();
    }

    @GetMapping("/getir/{id}")
    public Mono<ResponseEntity<Kisi>> kisiGetir(@PathVariable String id){
        return this.kisiService.kisiGetir(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/sil/{id}")
    public Mono<Void> kisiSil(@PathVariable String id) {
        return this.kisiService.kisiSil(id);
    }

}
