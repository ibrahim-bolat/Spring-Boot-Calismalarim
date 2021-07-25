package com.logging.controller;


import com.logging.model.Kisi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/kisi")
public class KisiApi {


    @GetMapping("/{name}")
    public Kisi getKisi(@PathVariable String name) {
        Kisi kisi=new Kisi(12,"ahmet","koş",1200, LocalDate.of(1985,05,17),new BigDecimal("300.000"));
        if (name.equals(kisi.getAd())){
            log.info("Kisi Bilgisi gönderildi");
            return kisi;
        }
        else{
            this.logla();
            return new Kisi(10,"Mehmet","atla",1800, LocalDate.of(1978,06,18),new BigDecimal("250.000"));
        }

    }

    private void logla() {
        try {
            log.debug("Ahmeti bulamadık haberiniz olsun");
        } catch (Exception e) {
            log.error("Hata : {}", e);
        }
    }

}
