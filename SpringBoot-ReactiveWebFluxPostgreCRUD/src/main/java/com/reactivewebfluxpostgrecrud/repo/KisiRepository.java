package com.reactivewebfluxpostgrecrud.repo;


import com.reactivewebfluxpostgrecrud.model.Kisi;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KisiRepository extends R2dbcRepository<Kisi, Integer> {

}
