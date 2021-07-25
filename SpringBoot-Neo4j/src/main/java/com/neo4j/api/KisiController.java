package com.neo4j.api;

import com.neo4j.model.Kisi;
import com.neo4j.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/kisi")
public class KisiController {


    private final KisiService kisiService;


    @GetMapping
    private List<Kisi> getKisiler(){
        return this.kisiService.getKisiler();
    }

    @GetMapping("/{id}")
    private Kisi getKisiById(@PathVariable Long id){
        return this.kisiService.getKisiById(id);
    }

    @PostMapping("/save")
    private Kisi saveKisi(@RequestBody Kisi kisi){
        return this.kisiService.saveKisi(kisi);
    }

    @PutMapping("/update/{id}")
    private Kisi updateKisi(@PathVariable Long id, @RequestBody Kisi kisi){
        return this.kisiService.updateKisi(id, kisi);
    }

    @DeleteMapping("/delete/{id}")
    private Kisi deleteKisi(@PathVariable Long id){
        return kisiService.deleteKisi(id);
    }
}
