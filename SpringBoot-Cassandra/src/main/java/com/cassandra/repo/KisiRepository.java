package com.cassandra.repo;


import com.cassandra.model.Kisi;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KisiRepository extends CassandraRepository<Kisi, UUID> {

}
