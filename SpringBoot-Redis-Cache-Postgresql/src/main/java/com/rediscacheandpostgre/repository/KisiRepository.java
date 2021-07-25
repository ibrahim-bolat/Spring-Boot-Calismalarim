package com.rediscacheandpostgre.repository;



import com.rediscacheandpostgre.model.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface KisiRepository extends JpaRepository<Kisi, Integer> {

}
