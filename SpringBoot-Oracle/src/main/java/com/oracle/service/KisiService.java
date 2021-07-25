package com.oracle.service;





import com.oracle.dto.KisiDto;
import com.oracle.model.Kisi;
import com.oracle.repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Kisi kisiGuncelle(int id, KisiDto kisiDto){
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

    public Kisi kisiGetir(int id){
        Optional<Kisi> returnedKisi=this.kisiRepository.findById(id);
        if(returnedKisi.isPresent()) {
            return returnedKisi.get();
        }
        return null;
    }

    public List<Kisi> kisiListele() {
        return this.kisiRepository.findAll();
    }

    public Boolean kisiSil(int id) {
        Optional<Kisi> returnedKisi=this.kisiRepository.findById(id);
        if(returnedKisi.isPresent()) {
            this.kisiRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
