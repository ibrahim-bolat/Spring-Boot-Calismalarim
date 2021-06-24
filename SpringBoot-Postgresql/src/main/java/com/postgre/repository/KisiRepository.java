package com.postgre.repository;


import com.postgre.model.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KisiRepository extends JpaRepository<Kisi, Integer> {

}
