package com.elasticsearch.Repo;


import com.elasticsearch.Entity.Kisi;
import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KisiRepository extends ElasticsearchRepository<Kisi, String> {
    List<Kisi> findByAdLikeOrSoyadLike(String ad, String soyad);
}
