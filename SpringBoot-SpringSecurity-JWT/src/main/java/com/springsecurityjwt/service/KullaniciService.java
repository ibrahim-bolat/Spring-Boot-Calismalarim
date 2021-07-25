package com.springsecurityjwt.service;

import com.springsecurityjwt.dto.KullaniciDto;
import com.springsecurityjwt.model.Kullanici;
import com.springsecurityjwt.repo.KullaniciRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class KullaniciService implements UserDetailsService {

    @Autowired
    private KullaniciRepository kullaniciRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String kullaniciAdi) throws UsernameNotFoundException {
        Kullanici kullanici = this.kullaniciRepository.findByKullaniciAdi(kullaniciAdi);
        if (kullanici == null) {
            throw new UsernameNotFoundException(kullaniciAdi+ "adında bir kullanıcı bulunamadı");
        }
        return new org.springframework.security.core.userdetails.User(kullanici.getKullaniciAdi(), kullanici.getParola(),
                new ArrayList<>());
    }

    public KullaniciDto kullaniciKaydet(Kullanici kullanici){
        String par=kullanici.getParola();
        kullanici.setParola(bcryptEncoder.encode(par));
        Kullanici rKullanici=this.kullaniciRepository.save(kullanici);
        KullaniciDto kullaniciDto=this.convert(rKullanici);
        return kullaniciDto;
    }

    public List<KullaniciDto> tumunuListele() {
        List<Kullanici> list = this.kullaniciRepository.findAll();
        return list.stream()
                .map(this::convert)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private KullaniciDto convert(Kullanici kullanici) {
        KullaniciDto kDto=new KullaniciDto();
        kDto.setId(kullanici.getId());
        kDto.setAd(kullanici.getAd());
        kDto.setSoyad(kullanici.getSoyad());
        kDto.setEmail(kullanici.getEmail());
        kDto.setDogumTarihi(kullanici.getDogumTarihi());
        kDto.setAktif(kullanici.isAktif());
        kDto.setKullaniciAdi(kullanici.getKullaniciAdi());
        return kDto;
    }
}
