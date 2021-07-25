package com.springsecurityjpamysql.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;



public class KullaniciDetaylar implements UserDetails {

    private Kullanici kullanici;
    public KullaniciDetaylar(Kullanici kullanici) {
        this.kullanici=kullanici;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Rol> roller=kullanici.getRoller();
        List<SimpleGrantedAuthority> yetkiler = new ArrayList<>();

        for(Rol rol:roller) {
            yetkiler.add(new SimpleGrantedAuthority(rol.getRolName()));
        }

        return yetkiler;
    }

    @Override
    public String getPassword() {
        return kullanici.getParola();
    }

    @Override
    public String getUsername() {
        return kullanici.getKullaniciAdi();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return kullanici.isAktif();
    }
}
