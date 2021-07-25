package com.hateoas.controller;

import com.hateoas.dto.CreateKisiDto;
import com.hateoas.dto.KisiHateoasDto;
import com.hateoas.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiController {

   private final KisiService kisiService;


    @GetMapping("/kisiler")
    public ResponseEntity<List<KisiHateoasDto>> getKisiList() {
        List<KisiHateoasDto> list = this.kisiService.getKisiList();
        list.forEach(kisi -> {
            kisi.add(WebMvcLinkBuilder
                    .linkTo(WebMvcLinkBuilder.methodOn(KisiController.class).getKisiById(kisi.getId()))
                    .withRel("kisi-by-id"));
        });
        return ResponseEntity.ok(list);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<KisiHateoasDto> getKisiById(@PathVariable int id) {
        KisiHateoasDto kisiHateoasDto = this.kisiService.getKisiById(id);

        kisiHateoasDto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(KisiController.class).getKisiList())
                .withRel("kisi-list"));
        kisiHateoasDto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(KisiController.class).getKisiById(id))
                .withRel("kisi-by-id"));

        return ResponseEntity.ok(kisiHateoasDto);
    }


    @PostMapping("/save")
    public ResponseEntity<Void> saveKisi(@RequestBody CreateKisiDto createKisiDto) {
        this.kisiService.saveKisi(createKisiDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateKisi(@RequestBody KisiHateoasDto kisiHateoasDto) {
        this.kisiService.updateKisi(kisiHateoasDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteKisi(@PathVariable int id) {
        this.kisiService.deleteKisiById(id);

        return ResponseEntity.ok().build();
    }
}
