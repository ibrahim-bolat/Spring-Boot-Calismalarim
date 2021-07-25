package com.integrationtest.controller;

import com.integrationtest.dto.KisiDto;
import com.integrationtest.service.KisiService;
import org.junit.jupiter.api.*;

import com.integrationtest.SpringBootIntegrationTestApplication;
import com.integrationtest.model.Kisi;
import com.integrationtest.repo.KisiRepository;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpringBootIntegrationTestApplication.class,
        webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
class KisiApiTest {

    @LocalServerPort
    private int port;

    HttpHeaders headers = new HttpHeaders();

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private KisiRepository kisiRepository;


    @BeforeEach//her test metodundan önce çalışıyor
    public void setup(){
        kisiRepository.saveAll(List.of(createKisi(),createKisi()));
    }
    @AfterEach//her test metodundan sonra çalışıyor
    public void finish(){
        kisiRepository.deleteAll();
    }

    @Test
    void kisiEkleIntegratinTest() {
        ResponseEntity<Kisi> responseEntity = this.restTemplate
                .postForEntity( createURLWithPort("/kisi/ekle"), createKisiDto(), Kisi.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertTrue(responseEntity.getBody().getId()!=null);
    }

    @Test
    void kisiGuncelleIntegratinTest() {
        Kisi kisi=kisiRepository.findAll().stream().findFirst().get();
        HttpEntity<KisiDto> httpEntity = new HttpEntity<KisiDto>(createKisiDtoGuncelle(), headers);
        ResponseEntity<Kisi> responseEntity =
                restTemplate.exchange(
                        createURLWithPort("/kisi/guncelle/"+kisi.getId()+"/"),
                        HttpMethod.PUT,
                        httpEntity,
                        Kisi.class
                );
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(kisi, responseEntity.getBody());

    }

    @Test
    void kisiGetirIntegratinTest() {
        Kisi kisi=kisiRepository.findAll().stream().findFirst().get();
        HttpEntity<KisiDto> httpEntity = new HttpEntity<KisiDto>(null, headers);
        ResponseEntity<Kisi> responseEntity =
                restTemplate.exchange(
                        createURLWithPort("/kisi/getir/"+kisi.getId()+"/"),
                        HttpMethod.GET,
                        httpEntity,
                        Kisi.class
                );
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(kisi, responseEntity.getBody());

    }

    @Test
    void kisiListeleIntegratinTest() {
        List<Kisi> kisiList=kisiRepository.findAll();
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<List<Kisi>> responseEntity =
                restTemplate.exchange(
                        createURLWithPort("/kisi"),
                        HttpMethod.GET,
                        httpEntity,
                        new ParameterizedTypeReference<List<Kisi>>() {}
                );
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(kisiList, responseEntity.getBody());
    }

    @Test
    void kisiSilIntegratinTest() {
        Kisi kisi=kisiRepository.findAll().stream().findFirst().get();
        HttpEntity<KisiDto> httpEntity = new HttpEntity<KisiDto>(null, headers);
        ResponseEntity<Boolean> responseEntity =
                restTemplate.exchange(
                        createURLWithPort("/kisi/sil/"+kisi.getId()+"/"),
                        HttpMethod.DELETE,
                        httpEntity,
                        Boolean.class
                );
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(true, responseEntity.getBody());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    private Kisi createKisi() {
        return new Kisi(createKisiDto().getAd(), createKisiDto().getSoyad(), createKisiDto().getMail(),
                createKisiDto().getDogumTarihi(), createKisiDto().getGelir());
    }


    private KisiDto createKisiDto() {
        KisiDto kisiDto = new KisiDto();
        kisiDto.setAd("Ali");
        kisiDto.setSoyad("DemirKan");
        kisiDto.setMail("bolatcan66@hotmail.com");
        kisiDto.setDogumTarihi(LocalDate.of(1996, 06, 02));
        kisiDto.setGelir(50_000L);
        return kisiDto;
    }

    private KisiDto createKisiDtoGuncelle() {
        KisiDto kisiDto = new KisiDto();
        kisiDto.setAd("Ahmet");
        kisiDto.setSoyad("Kral");
        kisiDto.setMail("bolatcan@hotmail.com");
        kisiDto.setDogumTarihi(LocalDate.of(2001, 06, 02));
        kisiDto.setGelir(25_000L);
        return kisiDto;
    }

}