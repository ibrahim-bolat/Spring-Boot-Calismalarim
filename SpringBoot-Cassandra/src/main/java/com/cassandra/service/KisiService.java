package com.cassandra.service;

import com.cassandra.dto.KisiDto;
import com.cassandra.model.Kisi;
import com.cassandra.repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.datastax.driver.core.utils.UUIDs;

@Service
@RequiredArgsConstructor
public class KisiService {

    private final KisiRepository kisiRepository;

    public Kisi kisiEkle(KisiDto kisiDto) {
        Kisi kisi= new Kisi(UUIDs.timeBased(),kisiDto.getAd(),kisiDto.getSoyad(),kisiDto.getCocukSayisi(),
                kisiDto.getAdres(),kisiDto.getDogumTarihi());
        return this.kisiRepository.save(kisi);
    }

    public Kisi kisiGuncelle(UUID id, KisiDto kisiDto){
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

    public Kisi kisiGetir(UUID id){
        Optional<Kisi> returnedKisi=this.kisiRepository.findById(id);
        if(returnedKisi.isPresent()) {
            return returnedKisi.get();
        }
        return null;
    }

    public List<Kisi> kisiListele() {
        return this.kisiRepository.findAll();
    }

    public Boolean kisiSil(UUID id) {
        Optional<Kisi> returnedKisi=this.kisiRepository.findById(id);
        if(returnedKisi.isPresent()) {
            this.kisiRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
