package com.example.springbootredisredistemplatecrud.api;



import com.example.springbootredisredistemplatecrud.model.Kisi;
import com.example.springbootredisredistemplatecrud.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiController {

    private final KisiService kisiService;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Kisi kisi = new Kisi();
        kisi.setId("K57763");
        kisi.setAd("ibrahim");
        kisi.setSoyad("Bolat");
        kisi.setPrice(1000);
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        this.kisiService.save(kisi);
    }

    @PostMapping("/save")
    public String save(@RequestBody Kisi kisi) {
        kisiService.save(kisi);
        return "Kisi Kaydedildi";
    }


    @GetMapping("/get/{id}")
    public Kisi get(@PathVariable String id) {
        Kisi returnedResponse = kisiService.get(id);
        return returnedResponse;
    }

    @PutMapping("/update")
    public String update(@RequestBody Kisi kisi) {
        kisiService.save(kisi);
        return "Kisi güncellendi";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        kisiService.delete(id);
        return "Kayıt Başarıyla Silindi";
    }
}

