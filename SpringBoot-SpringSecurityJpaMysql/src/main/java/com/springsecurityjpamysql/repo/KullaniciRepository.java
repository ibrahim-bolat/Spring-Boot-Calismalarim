package com.springsecurityjpamysql.repo;



import com.springsecurityjpamysql.model.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, Integer> {

    @Query("SELECT k from Kullanici k Where k.kullaniciAdi = :kullaniciAdi")
    public Kullanici getKullaniciByKullaniciAdi(@Param("kullaniciAdi") String kullaniciAdi);
}
