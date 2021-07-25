package com.hateoas.service;

import com.hateoas.dto.CreateKisiDto;
import com.hateoas.dto.KisiHateoasDto;
import com.hateoas.model.Kisi;
import com.hateoas.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiService {

    private final KisiRepository kisiRepository;

    @PostConstruct
    public void init(){
        Kisi kisi=new Kisi();
        kisi.setAd("beriş");
        kisi.setSoyad("go");
        kisi.setMaas(2780L);
        kisi.setDogumTarihi(LocalDate.of(2015,05,12));
        this.kisiRepository.save(kisi);
    }

    public List<KisiHateoasDto> getKisiList() {
        List<Kisi> kisiler = this.kisiRepository.findAll();

        return kisiler.stream().map(k -> {
            KisiHateoasDto kisiHateoasDto = new KisiHateoasDto();
            kisiHateoasDto.setId(k.getId());
            kisiHateoasDto.setAd(k.getAd());
            kisiHateoasDto.setSoyad(k.getSoyad());
            kisiHateoasDto.setDogumTarihi(k.getDogumTarihi());
            kisiHateoasDto.setMaas(k.getMaas());
            return kisiHateoasDto;
        }).collect(Collectors.toList());
    }

    public KisiHateoasDto getKisiById(int id) {
        KisiHateoasDto kisiHateoasDto = new KisiHateoasDto();
        Kisi kisi = this.kisiRepository.findById(id).get();

        kisiHateoasDto.setId(kisi.getId());
        kisiHateoasDto.setAd(kisi.getAd());
        kisiHateoasDto.setSoyad(kisi.getSoyad());
        kisiHateoasDto.setDogumTarihi(kisi.getDogumTarihi());
        kisiHateoasDto.setMaas(kisi.getMaas());

        return kisiHateoasDto;
    }

    public void saveKisi(CreateKisiDto createKisiDto) {
        Kisi kisi = new Kisi();

        kisi.setAd(createKisiDto.getAd());
        kisi.setSoyad(createKisiDto.getSoyad());
        kisi.setDogumTarihi(createKisiDto.getDogumTarihi());
        kisi.setMaas(createKisiDto.getMaas());

        this.kisiRepository.save(kisi);
    }

    public void updateKisi(KisiHateoasDto kisiHateoasDto) {
        Optional<Kisi> kisi = this.kisiRepository.findById(kisiHateoasDto.getId());
        if (kisi.isPresent()) {
            kisi.get().setAd(kisiHateoasDto.getAd());
            kisi.get().setSoyad(kisiHateoasDto.getSoyad());
            kisi.get().setDogumTarihi(kisiHateoasDto.getDogumTarihi());
            kisi.get().setMaas(kisiHateoasDto.getMaas());
        }
        this.kisiRepository.save(kisi.get());
    }

    public void deleteKisiById(int id) {
        this.kisiRepository.deleteById(id);
    }
}
