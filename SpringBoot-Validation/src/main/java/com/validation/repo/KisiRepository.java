package com.validation.repo;


import com.validation.model.Kisi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KisiRepository extends MongoRepository<Kisi, String> {

}
