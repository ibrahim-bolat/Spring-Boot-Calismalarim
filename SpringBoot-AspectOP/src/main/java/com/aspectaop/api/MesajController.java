package com.aspectaop.api;

import com.aspectaop.service.MesajService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesaj")
public class MesajController {

    final private MesajService mesajService;

    public MesajController(MesajService mesajService) {
        this.mesajService = mesajService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> mesajYaz(@RequestBody String mesaj){
        return ResponseEntity.ok(mesajService.mesajYaz(mesaj));
    }
}
