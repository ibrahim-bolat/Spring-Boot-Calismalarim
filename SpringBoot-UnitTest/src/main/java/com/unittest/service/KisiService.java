package com.unittest.service;



import com.unittest.dto.KisiDto;
import com.unittest.model.Kisi;
import com.unittest.repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class KisiService {

    private final KisiRepository kisiRepository;

    public KisiDto kisiEkle(KisiDto kisidto) {
       final Kisi rkisi=this.kisiRepository.save(new Kisi(kisidto.getAd(),kisidto.getSoyad(),kisidto.getDogumTarihi(),kisidto.getGelir()));
       return (new KisiDto(rkisi.getAd(),rkisi.getSoyad(),rkisi.getDogumTarihi(),rkisi.getGelir()));
    }

    public KisiDto kisiGuncelle(String id, KisiDto kisidto){
        Optional<Kisi> returnedKisi=this.kisiRepository.findById(id);
        if(returnedKisi.isPresent()) {
            returnedKisi.get().setAd(kisidto.getAd());
            returnedKisi.get().setSoyad(kisidto.getSoyad());
            returnedKisi.get().setDogumTarihi(kisidto.getDogumTarihi());
            returnedKisi.get().setGelir(kisidto.getGelir());
            final Kisi rkisi=this.kisiRepository.save(returnedKisi.get());
            return (new KisiDto(rkisi.getAd(),rkisi.getSoyad(),rkisi.getDogumTarihi(),rkisi.getGelir()));
        }
         return null;
    }

    public KisiDto kisiGetir(String id){
        Optional<Kisi> returnedKisi=this.kisiRepository.findById(id);
        if(returnedKisi.isPresent()) {
            return (new KisiDto(returnedKisi.get().getAd(),returnedKisi.get().getSoyad(),returnedKisi.get().getDogumTarihi(),returnedKisi.get().getGelir()));
        }
        return null;
    }

    public List<KisiDto> kisiListele() {
        List<Kisi> kisiList=this.kisiRepository.findAll();
        List<KisiDto> kisiDtoList=new ArrayList<>();
        kisiList.stream().forEach(kisi -> {
            KisiDto kisiDto=new KisiDto();
            kisiDto.setAd(kisi.getAd());
            kisiDto.setSoyad(kisi.getSoyad());
            kisiDto.setDogumTarihi(kisi.getDogumTarihi());
            kisiDto.setGelir(kisi.getGelir());
            kisiDtoList.add(kisiDto);
        });
        return kisiDtoList;
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
