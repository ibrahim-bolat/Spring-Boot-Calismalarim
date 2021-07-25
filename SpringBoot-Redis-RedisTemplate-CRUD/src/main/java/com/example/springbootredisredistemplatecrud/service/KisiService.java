package com.example.springbootredisredistemplatecrud.service;


import com.example.springbootredisredistemplatecrud.model.Kisi;
import com.example.springbootredisredistemplatecrud.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class KisiService {


    private final KisiRepository kisiRepository;

    public void save(Kisi kisi) {
        kisiRepository.save(kisi);
    }


    public Kisi get(String id) {
        Kisi returnResponse = kisiRepository.findById(id);
        return returnResponse;
    }


    public void update(Kisi kisi) {
        kisiRepository.save(kisi);
    }

    public void delete(String id) {
        kisiRepository.delete(id);
    }

}
