package com.unittest.service;

import com.unittest.dto.KisiDto;
import com.unittest.model.Kisi;
import com.unittest.repo.KisiRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class KisiServiceTest {

    @InjectMocks
    private KisiService kisiService;

    @Mock
    private KisiRepository kisiRepository;

    @Test
    void whenkisiEkleCalledWithKisiDto_itShouldReturnKisiDto() {

        when(kisiRepository.save(ArgumentMatchers.any(Kisi.class))).thenReturn(createKisi());


        assertEquals(kisiDtoCreate(), kisiService.kisiEkle(kisiDtoCreate()));
        verify(kisiRepository, times(1)).save(createKisiWithoutId());
    }

    @Test
    void whenkisiGuncelleCalledWithTrueIdAndKisiDto_itShouldReturnKisiDto() {


        when(kisiRepository.findById(ArgumentMatchers.eq("IB"))).thenReturn(Optional.of(createKisi()));
        when(kisiRepository.save(ArgumentMatchers.any(Kisi.class))).thenReturn(createKisi());

        assertEquals(kisiDtoCreate(), kisiService.kisiGuncelle(createKisi().getId(),kisiDtoCreate()));
        verify(kisiRepository, times(1)).findById(createKisi().getId());
        verify(kisiRepository, times(1)).save(createKisi());
    }

    @Test
    void whenkisiGuncelleCalledWithFalseIdAndKisiDto_itShouldReturnNull() {


        when(kisiRepository.findById(ArgumentMatchers.eq("BL"))).thenReturn(Optional.ofNullable(null));

        assertEquals(null, kisiService.kisiGuncelle("BL",null));
        verify(kisiRepository, times(1)).findById("BL");
        verify(kisiRepository, times(0)).save(createKisi());
    }

    @Test
    void whenkisiGetirCalledWithTrueId_itShouldReturnKisiDto() {


        when(kisiRepository.findById(ArgumentMatchers.eq("IB"))).thenReturn(Optional.of(createKisi()));

        assertEquals(kisiDtoCreate(), kisiService.kisiGetir(createKisi().getId()));
        verify(kisiRepository, times(1)).findById(createKisi().getId());

    }

    @Test
    void whenkisiGetirCalledWithFalseId_itShouldReturnKisiDto() {

        when(kisiRepository.findById(ArgumentMatchers.eq("BL"))).thenReturn(Optional.ofNullable(null));

        assertEquals(null, kisiService.kisiGetir("BL"));
        verify(kisiRepository, times(1)).findById("BL");

    }

    @Test
    void whenkisiListeleCalled_itShouldReturnAllKisiDtoList() {

        when(kisiRepository.findAll()).thenReturn(createKisiList());

        assertEquals(createKisiDtoList(), kisiService.kisiListele());
        verify(kisiRepository, times(1)).findAll();
    }

    @Test
    void whenkisiSilCalledWithTrueId_itShouldReturnTrue(){

        when(kisiRepository.findById(ArgumentMatchers.eq("IB"))).thenReturn(Optional.of(createKisi()));

        assertEquals(true, kisiService.kisiSil(createKisi().getId()));
        verify(kisiRepository, times(1)).deleteById(createKisi().getId());

    }
    @Test
    void whenkisiSilCalledWithFalseId_itShouldReturnFalse(){

        when(kisiRepository.findById(ArgumentMatchers.eq("BL"))).thenReturn(Optional.ofNullable(null));

        assertEquals(false, kisiService.kisiSil("BL"));
        verify(kisiRepository, times(0)).deleteById(createKisi().getId());

    }

    private  Kisi createKisiWithoutId(){
        return new Kisi(kisiDtoCreate().getAd(),kisiDtoCreate().getSoyad(),kisiDtoCreate().getDogumTarihi(),kisiDtoCreate().getGelir());
    }
    private  Kisi createKisi(){
        return new Kisi("IB",kisiDtoCreate().getAd(),kisiDtoCreate().getSoyad(),kisiDtoCreate().getDogumTarihi(),kisiDtoCreate().getGelir());
    }
    private  KisiDto kisiDtoCreate(){
        KisiDto kisiDto=new KisiDto();
        kisiDto.setAd("Ali");
        kisiDto.setSoyad("DemirKan");
        kisiDto.setDogumTarihi(LocalDate.of(1996,06,02));
        kisiDto.setGelir(50_000L);
        return kisiDto;
    }

    private  List<Kisi> createKisiList(){
        return List.of(createKisi(),createKisi());
    }
    private  List<KisiDto> createKisiDtoList(){
        return List.of(kisiDtoCreate(),kisiDtoCreate());
    }
}