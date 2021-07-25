package com.hazelcastcache.service;

import com.hazelcastcache.model.Kisi;
import com.hazelcastcache.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Service
public class KisiService {


    private final KisiRepository kisiRepository;

    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        Long count = kisiRepository.count();
        if (count == 0) {
            List<String> genders = List.of("Male", "Famale");
            List<Kisi> kisiList = new ArrayList<>();
            for (int i = 0; i < 500; i++) {
                kisiList.add(Kisi.builder().name("Ahmet")
                        .surname("Can")
                        .gender(genders.get(i % 2))
                        .birthOfDate(new Date())
                        .build()
                );
            }
            kisiRepository.saveAll(kisiList);
        }
    }
    @Transactional
    public Kisi save(Kisi kisi) {
        Kisi returnResponse = kisiRepository.save(kisi);
        return returnResponse;
    }

    @Transactional
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
    public List<Kisi> getAll() {
        List<Kisi> returnedResponse = kisiRepository.findAll();
        return returnedResponse;
    }

    @Transactional
    public Kisi update(Kisi kisi) {
        Kisi returnResponse = kisiRepository.save(kisi);
        return returnResponse;
    }

    @Transactional
    public void delete(Kisi kisi) {
        kisiRepository.delete(kisi);
    }
}
