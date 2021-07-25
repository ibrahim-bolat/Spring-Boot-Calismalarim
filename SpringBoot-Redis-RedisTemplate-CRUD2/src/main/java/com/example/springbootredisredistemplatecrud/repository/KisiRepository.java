package com.example.springbootredisredistemplatecrud.repository;





import com.example.springbootredisredistemplatecrud.model.Kisi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class KisiRepository {

    private static final String KEY = "Kisi";

    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, Kisi> hashOperations;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }


    public void save(Kisi kisi) {
        hashOperations.put(KEY, kisi.getId(), kisi);
    }


    public Kisi findById(String id) {
        return hashOperations.get(KEY, id);
    }


    public Map<String, Kisi> findAll() {
        return hashOperations.entries(KEY);
    }

    public void update(Kisi kisi) {
        hashOperations.put(KEY, kisi.getId(), kisi);
    }


    public void delete(String id) {
        hashOperations.delete(KEY, id);
    }

}
