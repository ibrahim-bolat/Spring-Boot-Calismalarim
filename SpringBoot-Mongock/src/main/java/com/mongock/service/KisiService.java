package com.mongock.service;

import com.mongock.model.Kisi;
import com.mongock.repo.KisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class KisiService {

    private final KisRepository kisRepository;

    public void kisiEkle(Kisi kisi) {
        kisRepository.insert(kisi);
    }

    public void kisiGuncelle(Kisi kisi) {
        Kisi kayitliKisi = kisRepository.findById(kisi.getId())
                .orElseThrow(() -> new RuntimeException(String.format("%s li kişi bulanamadı", kisi.getId())));
        kayitliKisi.setAd(kisi.getAd());
        kayitliKisi.setSoyad(kisi.getSoyad());
        kayitliKisi.setMaas(kisi.getMaas());
        kayitliKisi.setDogumTarihi(kisi.getDogumTarihi());
        kayitliKisi.setAdresTip(kisi.getAdresTip());
        kisRepository.save(kayitliKisi);
    }

    public Kisi adaGoreKisiGetir(String ad) {
        return kisRepository.findByName(ad)
                .orElseThrow(() -> new RuntimeException(String.format("%s isimde bir kişi bulunamadı", ad)));
    }

    public List<Kisi> kisiListele() {
        return kisRepository.findAll();
    }

    public void kisiSil(String id) {
        kisRepository.deleteById(id);
    }
}
