package com.modelmapper.repo;


import com.modelmapper.model.Kisi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KisiRepository extends MongoRepository<Kisi, String> {

}
