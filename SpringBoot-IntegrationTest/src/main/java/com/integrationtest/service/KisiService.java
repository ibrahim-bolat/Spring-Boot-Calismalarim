package com.integrationtest.service;


import com.integrationtest.dto.KisiDto;
import com.integrationtest.model.Kisi;
import com.integrationtest.repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class KisiService {

    private final KisiRepository kisiRepository;

    public Kisi kisiEkle(KisiDto kisiDto) {
        Kisi kisi= new Kisi(kisiDto.getAd(),kisiDto.getSoyad(),kisiDto.getMail(),
                kisiDto.getDogumTarihi(),kisiDto.getGelir());
       return this.kisiRepository.save(kisi);
    }

    public Kisi kisiGuncelle(String id, KisiDto kisiDto){
        Optional<Kisi> returnedKisi=this.kisiRepository.findById(id);
        if(returnedKisi.isPresent()) {
            final Kisi rkisi=returnedKisi.get();
            rkisi.setAd(kisiDto.getAd());
            rkisi.setSoyad(kisiDto.getSoyad());
            rkisi.setMail(kisiDto.getMail());
            rkisi.setGelir(kisiDto.getGelir());
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

    public List<Kisi> kisiListele() {
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
