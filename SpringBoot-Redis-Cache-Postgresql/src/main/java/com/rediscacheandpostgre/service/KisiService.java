package com.rediscacheandpostgre.service;

import com.rediscacheandpostgre.model.Kisi;
import com.rediscacheandpostgre.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KisiService {


    private final KisiRepository kisiRepository;

    @Transactional
    @CachePut(value = "kisi", key = "#kisi.id")
    public Kisi save(Kisi kisi) {
        Kisi returnResponse = kisiRepository.save(kisi);
        return returnResponse;
    }

    @Transactional
    @Cacheable(value = "kisi", key = "#id")
    public Kisi get(int id) {
        Kisi kisi = null;
        Optional<Kisi> returnResponse = kisiRepository.findById(id);
        if (returnResponse.isPresent()) {
            kisi = returnResponse.get();
        } else {
            throw new RuntimeException("Kayıt Bulunamadı");
        }
        return kisi;
    }

    @Transactional
    @Cacheable(cacheNames = "kisiler")
    public List<Kisi> getAll() {
        List<Kisi> returnedResponse = kisiRepository.findAll();
        return returnedResponse;
    }

    @Transactional
    @CachePut(value = "kisi", key = "#kisi.id")
    public Kisi update(Kisi kisi) {
        Kisi returnResponse = kisiRepository.save(kisi);
        return returnResponse;
    }

    @Transactional
    @CacheEvict(value = "kisi", key = "#kisi.id")
    public void delete(Kisi kisi) {
        kisiRepository.delete(kisi);
    }
}
