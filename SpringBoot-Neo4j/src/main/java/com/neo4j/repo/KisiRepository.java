package com.neo4j.repo;

import com.neo4j.model.Kisi;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KisiRepository extends Neo4jRepository<Kisi, Long> {

}
