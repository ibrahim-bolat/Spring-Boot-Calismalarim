package com.reactivewebfluxmongocrud.repo;


import com.reactivewebfluxmongocrud.model.Kisi;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KisiRepository extends ReactiveMongoRepository<Kisi, String> {

}
