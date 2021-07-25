package com.neo4j.service;

import com.neo4j.model.Film;
import com.neo4j.model.Kisi;
import com.neo4j.repo.FilmRepository;
import com.neo4j.repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KisiService {


    private final KisiRepository kisiRepository;
    private final FilmRepository filmRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        Film film1=new Film();
        film1.setAd("Yuzuklerin Efendisi");
        film1.setYonetmen("Peter Jackson");

        Film film2=new Film();
        film2.setAd("Esaretin Bedeli");
        film2.setYonetmen("Frank Darabont");

        Kisi kisi=new Kisi();
        kisi.setAd("beriş");
        kisi.setSoyad("go");
        kisi.setMaas(1000);
        kisi.setDogumTarihi(LocalDate.of(2015,05,12));
        kisi.setFilmler(List.of(film1,film2));
        this.kisiRepository.save(kisi);
    }

    public List<Kisi> getKisiler() {
        return  this.kisiRepository.findAll();
    }

    public Kisi saveKisi(Kisi kisi) {
        return this.kisiRepository.save(kisi);
    }

    public Kisi deleteKisi(Long id) {
        Optional<Kisi> kisi = kisiRepository.findById(id);
        List<Film> filmler = kisi.get().getFilmler();
        if (kisi.isPresent())
          this.kisiRepository.deleteById(id);

        filmler.forEach(film -> {
            this.filmRepository.deleteById(film.getId());
        });
        return kisi.get();
    }

    public Kisi getKisiById(Long id) {
        Optional<Kisi> kisi = this.kisiRepository.findById(id);
        return kisi.get();
    }

    public Kisi updateKisi(Long id, Kisi kisi) {
        Optional<Kisi> rKisi = this.kisiRepository.findById(id);
        Kisi kisiEntity = rKisi.get();
        updateKisiEntity(kisi, kisiEntity);
        return this.kisiRepository.save(kisiEntity);
    }

    private void updateKisiEntity(Kisi request, Kisi kisiEntity) {
        if(request.getAd() != null && !request.getAd().isEmpty())
            kisiEntity.setAd(request.getAd());
        if(request.getSoyad() != null && !request.getSoyad().isEmpty())
            kisiEntity.setSoyad(request.getSoyad());
        if(request.getMaas() != 0 )
            kisiEntity.setMaas(request.getMaas());
        if(request.getDogumTarihi() != null)
            kisiEntity.setDogumTarihi(request.getDogumTarihi());
        if(request.getFilmler() != null && !request.getFilmler().isEmpty()){
            List<Film> filmler = new ArrayList<>();
            filmler.addAll(kisiEntity.getFilmler());
            filmler.addAll(request.getFilmler());
            kisiEntity.setFilmler(filmler);
        }
    }
}
