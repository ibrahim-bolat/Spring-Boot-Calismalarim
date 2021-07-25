package com.unittest.repo;



import com.unittest.model.Kisi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KisiRepository extends MongoRepository<Kisi, String> {

}
