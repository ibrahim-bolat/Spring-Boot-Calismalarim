package com.springsecurityjwt.controller;




import com.springsecurityjwt.config.JwtTokenUtil;
import com.springsecurityjwt.dto.KullaniciDto;
import com.springsecurityjwt.model.JwtRequest;
import com.springsecurityjwt.model.JwtResponse;
import com.springsecurityjwt.model.Kullanici;
import com.springsecurityjwt.service.KullaniciService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequiredArgsConstructor
public class KullaniciApi {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final KullaniciService kullaniciService;

    @RequestMapping(value = "/dogrula", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getKullaniciAdi(), authenticationRequest.getParola());

        final UserDetails userDetails = kullaniciService.loadUserByUsername(authenticationRequest.getKullaniciAdi());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/kaydet", method = RequestMethod.POST)
    public ResponseEntity<KullaniciDto> saveKullanici(@RequestBody Kullanici kullanici) throws Exception {
        return ResponseEntity.ok(kullaniciService.kullaniciKaydet(kullanici));
    }

    @RequestMapping(value = "/getir", method = RequestMethod.GET)
    public List<KullaniciDto> tumunuListele() {
       return this.kullaniciService.tumunuListele();
    }

    private void authenticate(String kullaniciAdi, String parola) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(kullaniciAdi, parola));
        } catch (DisabledException e) {
            throw new Exception("Kullanıcı Engellendi", e);
        } catch (BadCredentialsException e) {
            throw new Exception("Geçersiz Bilgi", e);
        }
    }
}
