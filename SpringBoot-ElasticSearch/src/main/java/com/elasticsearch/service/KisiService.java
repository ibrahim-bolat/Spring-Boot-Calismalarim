package com.elasticsearch.service;


import com.elasticsearch.dto.KisiDto;
import com.elasticsearch.entity.Kisi;
import com.elasticsearch.repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class KisiService {

    private final KisiRepository kisiRepository;

    public Kisi kisiEkle(KisiDto kisiDto) {
        Kisi kisi= new Kisi(kisiDto.getAd(),kisiDto.getSoyad(),kisiDto.getCocukSayisi(),
                kisiDto.getAdres(),kisiDto.getDogumTarihi());
        return this.kisiRepository.save(kisi);
    }

    public Kisi kisiGuncelle(String id, KisiDto kisiDto){
        Optional<Kisi> returnedKisi=this.kisiRepository.findById(id);
        if(returnedKisi.isPresent()) {
            final Kisi rkisi=returnedKisi.get();
            rkisi.setAd(kisiDto.getAd());
            rkisi.setSoyad(kisiDto.getSoyad());
            rkisi.setCocukSayisi(kisiDto.getCocukSayisi());
            rkisi.setAdres(kisiDto.getAdres());
            rkisi.setDogumTarihi(kisiDto.getDogumTarihi());
            return this.kisiRepository.save(rkisi);
        }
        return null;
    }

    public Kisi kisiGetir(String id){
        Optional<Kisi> returnedKisi=this.kisiRepository.findById(id);
        if(returnedKisi.isPresent()) {
            return returnedKisi.get();
        }
        return null;
    }

    public Iterable<Kisi> kisiListele() {
        return this.kisiRepository.findAll();
    }

    public Boolean kisiSil(String id) {
        Optional<Kisi> returnedKisi=this.kisiRepository.findById(id);
        if(returnedKisi.isPresent()) {
            this.kisiRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
