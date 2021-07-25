package com.reactivewebfluxmongocrud.service;



import com.reactivewebfluxmongocrud.model.Kisi;
import com.reactivewebfluxmongocrud.repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
@RequiredArgsConstructor
public class KisiService {

    private final KisiRepository kisiRepository;


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        if (kisiRepository.count().block() == 0) {
            IntStream.range(0, 100)
                    .mapToObj(this::olustur)
                    .map(kisiRepository::save)
                    .collect(Collectors.toList())
                    .forEach(item -> item.subscribe(System.out::println));
        }
    }

    private Kisi olustur(int i) {
        return Kisi.builder()
                .ad(i+".Kisi")
                .soyad("kisi"+i)
                .maas(2780)
                .dogumTarihi(LocalDate.of(1987,05,15))
                .kredi(new BigDecimal("300.000"))
                .build();
    }

    public Mono<Kisi> kisiEkle(final Kisi kisi) {
        return this.kisiRepository.save(kisi);
    }

    public Mono<Kisi> kisiGuncelle(String id, final Mono<Kisi> kisiMono){
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

    public Mono<Kisi> kisiGetir(String id){
        return this.kisiRepository.findById(id);
    }

    public Flux<Kisi> kisiListele() {
        return this.kisiRepository.findAll();
    }

    public Mono<Void> kisiSil(final String id) {
       return this.kisiRepository.deleteById(id);
    }
}
