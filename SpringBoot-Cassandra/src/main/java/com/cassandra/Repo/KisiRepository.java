package com.cassandra.Repo;


import com.cassandra.Entity.Kisi;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KisiRepository extends CassandraRepository<Kisi, Integer> {

    List<Kisi> findByAdLikeOrSoyadLike(String search, String search1);
}
