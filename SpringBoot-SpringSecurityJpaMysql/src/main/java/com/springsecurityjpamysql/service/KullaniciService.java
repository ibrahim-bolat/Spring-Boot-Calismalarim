package com.springsecurityjpamysql.service;


import ch.qos.logback.classic.joran.ReconfigureOnChangeTaskListener;
import com.springsecurityjpamysql.model.KullaniciDetaylar;
import com.springsecurityjpamysql.model.Kullanici;
import com.springsecurityjpamysql.model.Rol;
import com.springsecurityjpamysql.repo.KullaniciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class KullaniciService implements UserDetailsService {

    private KullaniciRepository kullaniciRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public KullaniciService(KullaniciRepository kullaniciRepository, @Lazy BCryptPasswordEncoder passwordEncoder) {
        this.kullaniciRepository = kullaniciRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String kullaniciAdi) throws UsernameNotFoundException {
        Kullanici kullanici =this.kullaniciRepository.getKullaniciByKullaniciAdi(kullaniciAdi);
        if(kullanici==null) {
            throw new UsernameNotFoundException(kullaniciAdi+" adında bir kullanıcı Bulanamadı");
        }
        return new KullaniciDetaylar(kullanici);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void init(){
        Kullanici kullanici=new Kullanici();
        Rol rol=new Rol();
        rol.setRolName("ROLE_ADMIN");
        kullanici.setAd("Ahmet");
        kullanici.setSoyad("narin");
        kullanici.setParola(passwordEncoder.encode("12345"));
        kullanici.setEmail("makarna@gmail.com");
        kullanici.setDogumTarihi(LocalDate.of(1985,05,07));
        kullanici.setKullaniciAdi("secur");
        kullanici.setRoller(Set.of(rol));
        kullanici.setAktif(true);
        this.kullaniciRepository.save(kullanici);
    }
}
