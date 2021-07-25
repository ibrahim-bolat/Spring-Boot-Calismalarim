package com.elasticsearch.repo;


import com.elasticsearch.entity.Kisi;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KisiRepository extends ElasticsearchRepository<Kisi, String> {
}
