package com.rediscacheandpostgre.api;




import com.rediscacheandpostgre.model.Kisi;
import com.rediscacheandpostgre.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiController {

    private final KisiService kisiService;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Kisi kisi = new Kisi();
        kisi.setAd("ibrahim");
        kisi.setSoyad("Bolat");
        kisi.setPrice(1000);
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        this.kisiService.save(kisi);
    }

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

