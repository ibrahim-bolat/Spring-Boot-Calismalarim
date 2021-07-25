package com.validation.service;




import com.validation.dto.KisiDto;
import com.validation.model.Kisi;
import com.validation.repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
@RequiredArgsConstructor
public class KisiService {

    private final KisiRepository kisiRepository;
    private final ModelMapper mapper;


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        if (kisiRepository.count() == 0) {
            IntStream.range(0, 100)
                    .mapToObj(this::olustur)
                    .map(kisiRepository::save)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
        }
    }

    private Kisi olustur(int i) {
        return Kisi.builder()
                .ad(i+".Kisi")
                .soyad("kisi"+i)
                .email("bolatcanbolat@emil.com")
                .parola("KPFPFVEAC")
                .cinsiyet("Erkek")
                .dogumTarihi(LocalDate.of(1987,02,20))
                .iliskiDurumu(true)
                .cocukSayisi(5)
                .krediKartNumarasi("4445555576894456")
                .gelir(20_000L)
                .aciklama("Bu Kişi böyle birisidir")
                .build();
    }

    public KisiDto kisiEkle(KisiDto kisidto) {
        Kisi kisi=mapper.map(kisidto,Kisi.class);
        return mapper.map(this.kisiRepository.save(kisi),KisiDto.class);
    }

    public KisiDto kisiGuncelle(String id, KisiDto kisidto){
        Optional<Kisi> returnedKisi=this.kisiRepository.findById(id);
        if(returnedKisi.isPresent()) {
            returnedKisi.get().setAd(kisidto.getAd());
            returnedKisi.get().setSoyad(kisidto.getSoyad());
            returnedKisi.get().setEmail(kisidto.getEmail());
            returnedKisi.get().setParola(kisidto.getParola());
            returnedKisi.get().setCinsiyet(kisidto.getCinsiyet());
            returnedKisi.get().setDogumTarihi(kisidto.getDogumTarihi());
            returnedKisi.get().setIliskiDurumu(kisidto.isIliskiDurumu());
            returnedKisi.get().setCocukSayisi(kisidto.getCocukSayisi());
            returnedKisi.get().setKrediKartNumarasi(kisidto.getKrediKartNumarasi());
            returnedKisi.get().setGelir(kisidto.getGelir());
            returnedKisi.get().setAciklama(kisidto.getAciklama());
            return mapper.map(this.kisiRepository.save(returnedKisi.get()),KisiDto.class);
        }
         return null;
    }

    public KisiDto kisiGetir(String id){
        Optional<Kisi> returnedKisi=this.kisiRepository.findById(id);
        if(returnedKisi.isPresent()) {
            return mapper.map(returnedKisi.get(),KisiDto.class);
        }
        return null;
    }

    public List<KisiDto> kisiListele() {
        List<Kisi> kisiList=this.kisiRepository.findAll();
        List<KisiDto> kisiDtoList=kisiList.stream().map(kisi->mapper.map(kisi,KisiDto.class)).collect(Collectors.toList());
        return kisiDtoList;
    }

    public Boolean kisiSil(String id) {
        Optional<Kisi> returnedKisi=this.kisiRepository.findById(id);
        if(returnedKisi.isPresent()) {
            this.kisiRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
