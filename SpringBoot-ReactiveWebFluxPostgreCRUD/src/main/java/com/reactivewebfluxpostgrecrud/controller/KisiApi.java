package com.reactivewebfluxpostgrecrud.controller;




import com.reactivewebfluxpostgrecrud.model.Kisi;
import com.reactivewebfluxpostgrecrud.service.KisiService;
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
    public Mono<Kisi> kisiGuncelle(@PathVariable int id, @RequestBody Mono<Kisi> kisiMono){
        return this.kisiService.kisiGuncelle(id, kisiMono);
    }

    @GetMapping
    public Flux<Kisi> kisiListele() {
        return this.kisiService.kisiListele();
    }

    @GetMapping("/getir/{id}")
    public Mono<ResponseEntity<Kisi>> kisiGetir(@PathVariable int id){
        return this.kisiService.kisiGetir(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/sil/{id}")
    public Mono<Void> kisiSil(@PathVariable int id) {
        return this.kisiService.kisiSil(id);
    }

}
