package com.pagination.repo;

import com.pagination.model.Kisi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KisiRepository extends MongoRepository<Kisi,String> {


}
