package com.example.springbootredisredistemplatecrud.repository;





import com.example.springbootredisredistemplatecrud.model.Kisi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


import java.util.*;


@Component
@RequiredArgsConstructor
public class KisiRepository {

    private final RedisTemplate<String, Kisi> redisTemplate;

    public Kisi findById(String id) {
        return redisTemplate.opsForValue().get(id);
    }

    public void save(Kisi kisi) {
        redisTemplate.opsForValue().set(kisi.getId(), kisi);
    }

    public void delete(String id) {
        redisTemplate.delete(id);
    }

}
