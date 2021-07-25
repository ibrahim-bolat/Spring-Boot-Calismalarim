package com.springsecurityjpamysql.controller;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class KullaniciApi {

    @GetMapping("/")
    public String girisSayfasi(){
        return ("<h1>Burası herkesin girebildiği sayfa</>");
    }

    @GetMapping("/user")
    public String kullaniciSayfasi(){
        return ("<h1>Burası Kullanıcı Sayfası</>");
    }

    @GetMapping("/admin")
    public String yoneticiSayfasi(){
        return ("<h1>Burası Yönetici Sayfası</>");
    }
}
