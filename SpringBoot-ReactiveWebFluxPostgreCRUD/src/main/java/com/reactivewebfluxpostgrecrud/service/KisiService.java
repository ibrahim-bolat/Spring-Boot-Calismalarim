package com.reactivewebfluxpostgrecrud.service;


import com.reactivewebfluxpostgrecrud.model.Kisi;
import com.reactivewebfluxpostgrecrud.repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class KisiService {

    private final KisiRepository kisiRepository;

    public Mono<Kisi> kisiEkle(final Kisi kisi) {
        return this.kisiRepository.save(kisi);
    }

    public Mono<Kisi> kisiGuncelle(int id, final Mono<Kisi> kisiMono){
        return this.kisiRepository.findById(id).
                flatMap(returnedKisi -> kisiMono.map(kisi -> {
                    returnedKisi.setAd(kisi.getAd());
                    returnedKisi.setSoyad(kisi.getSoyad());
                    returnedKisi.setMaas(kisi.getMaas());
                    returnedKisi.setDogumTarihi(kisi.getDogumTarihi());
                    returnedKisi.setKredi(kisi.getKredi());
                    return returnedKisi;
                }))
                .flatMap(returnedKisi -> this.kisiRepository.save(returnedKisi));
    }

    public Mono<Kisi> kisiGetir(int id){
        return this.kisiRepository.findById(id);
    }

    public Flux<Kisi> kisiListele() {
        return this.kisiRepository.findAll();
    }

    public Mono<Void> kisiSil(final int id) {
       return this.kisiRepository.deleteById(id);
    }
}
