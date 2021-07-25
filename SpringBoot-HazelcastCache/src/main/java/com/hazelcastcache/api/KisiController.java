package com.hazelcastcache.api;



import com.hazelcastcache.model.Kisi;
import com.hazelcastcache.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiController {

    private final KisiService kisiService;


    @PostMapping("/save")
    public Kisi save(@RequestBody Kisi kisi) {
        Kisi returnedResponse = kisiService.save(kisi);
        return returnedResponse;
    }

    @PutMapping("/update")
    public Kisi update(@RequestBody Kisi kisi) {
        Kisi returnedResponse = kisiService.save(kisi);
        return returnedResponse;
    }

    @GetMapping("/{id}")
    public Kisi get(@PathVariable int id) {
        Kisi returnedResponse = kisiService.get(id);
        return returnedResponse;
    }

    @GetMapping()
    public List<Kisi> getAll() {
        List<Kisi> returnedResponse = kisiService.getAll();
        return returnedResponse;
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestBody Kisi kisi) {
        kisiService.delete(kisi);
        return "Kayıt Başarıyla Silindi";
    }
}

