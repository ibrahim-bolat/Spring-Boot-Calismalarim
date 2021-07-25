package com.mongock.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongock.model.AdresTip;
import com.mongock.model.Kisi;
import com.mongock.repo.KisRepository;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ChangeLog(order = "001")
public class DatabaseInitChangeLog {
    @ChangeSet(order = "001", id = "veritabaniOlustur", author = "ibo")
    public void veritabaniOlustur(KisRepository kisRepository) {
        List<Kisi> kisiList= new ArrayList<>();
        kisiList.add(Kisi.builder().ad("Ahmet").soyad("DOĞAN").maas(1500).adresTip(AdresTip.EV).dogumTarihi(LocalDate.of(1987,05,25)).build());
        kisiList.add(Kisi.builder().ad("Mehmet").soyad("ALTAŞ").maas(2500).adresTip(AdresTip.IS).dogumTarihi(LocalDate.of(1985,06,12)).build());
        kisiList.add(Kisi.builder().ad("Ali").soyad("TATLI").maas(2500).adresTip(AdresTip.DİGER).dogumTarihi(LocalDate.of(1990,04,18)).build());
        kisiList.add(Kisi.builder().ad("Veli").soyad("TURK").maas(2750).adresTip(AdresTip.EV).dogumTarihi(LocalDate.of(1998,03,13)).build());
        kisiList.add(Kisi.builder().ad("Recai").soyad("ŞAHİN").maas(1285).adresTip(AdresTip.IS).dogumTarihi(LocalDate.of(1987,07,10)).build());
        kisRepository.insert(kisiList);
    }
}
