package com.neo4j.repo;

import com.neo4j.model.Film;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends Neo4jRepository<Film, Long> {

}
