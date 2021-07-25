package com.flyway.api;




import com.flyway.model.Kisi;
import com.flyway.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiController {

    private final KisiRepository kisiRepository;

    @GetMapping("/kisiler")
     public ResponseEntity<List<Kisi>> tumKisiler(){
        return ResponseEntity.ok(kisiRepository.findAll());
    }

    @GetMapping("/kisi/{id}")
    public ResponseEntity<Kisi> kisi(@PathVariable int id){
        return ResponseEntity.ok(kisiRepository.findById(id).get());
    }

    @PostMapping("/save")
    public ResponseEntity<Kisi> save(@RequestBody Kisi kisi){
        return ResponseEntity.ok(kisiRepository.save(kisi));
    }
}

