package com.resttemplate.api;


import com.resttemplate.dto.KisiClientDto;
import com.resttemplate.model.ClientKisiModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/mongoClient")
@RequiredArgsConstructor
public class ClientKisiController {

    private static String url="http://localhost:8080/kisi";

    private final RestTemplate restTemplate;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ClientKisiModel> ekle(@RequestBody ClientKisiModel clientKisiModel) {
        KisiClientDto kisiClientDto=modelMapper.map(clientKisiModel,KisiClientDto.class);
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
}
