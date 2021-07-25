package com.springsecurityjwt.repo;




import com.springsecurityjwt.model.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, Integer> {

    Kullanici findByKullaniciAdi(String kullaniciAdi);
}
