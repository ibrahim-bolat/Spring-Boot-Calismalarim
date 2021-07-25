package com.mongock.repo;


import com.mongock.model.Kisi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface KisRepository extends MongoRepository<Kisi, String> {
    @Query("{'ad': ?0}")
    Optional<Kisi> findByName(String ad);
}
