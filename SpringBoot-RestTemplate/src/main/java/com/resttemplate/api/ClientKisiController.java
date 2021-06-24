package com.resttemplate.api;

import com.resttemplate.dto.AdresClientDto;
import com.resttemplate.dto.KisiClientDto;
import com.resttemplate.model.ClientKisiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/mongoClient")
@RequiredArgsConstructor
public class ClientKisiController {

    private static String url="http://localhost:8080/kisi";

    private final RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<ClientKisiModel> ekle(@RequestBody ClientKisiModel clientKisiModel) {
        KisiClientDto kisiClientDto=convertToDto(clientKisiModel);
        ResponseEntity<ClientKisiModel> clientKisiModel1=restTemplate.postForEntity(url,kisiClientDto,ClientKisiModel.class);
        ClientKisiModel body=clientKisiModel1.getBody();
        return ResponseEntity.ok(body);
    }

    @GetMapping
    public ResponseEntity<List<ClientKisiModel>> tumunuListele() {
        ResponseEntity<List> getList=restTemplate.getForEntity(url,List.class);
        List<ClientKisiModel> lists=getList.getBody();
        return ResponseEntity.ok(lists);
    }

    private KisiClientDto convertToDto(ClientKisiModel clientKisiModel) {
        KisiClientDto kisiClientDto=new KisiClientDto();
        List<AdresClientDto> adresList=new ArrayList<>();
        kisiClientDto.setAd(clientKisiModel.getAd());
        kisiClientDto.setSoyad(clientKisiModel.getSoyad());
        kisiClientDto.setPrice(clientKisiModel.getPrice());
        kisiClientDto.setDogumTarihi(clientKisiModel.getDogumTarihi());
        clientKisiModel.getAdresler().forEach(adres->
        {
            AdresClientDto adresClientDto=new AdresClientDto();
            adresClientDto.setAdresBilgisi(adres.getAdresBilgisi());
            adresClientDto.setAdresTur(AdresClientDto.AdresTur.valueOf(adres.getAdresTur()));
            adresClientDto.setUrban(adres.isUrban());
            adresList.add(adresClientDto);
        });
        kisiClientDto.setAdresler(adresList);
        return kisiClientDto;
    }
}
