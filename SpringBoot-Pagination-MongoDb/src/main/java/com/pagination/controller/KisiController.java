package com.pagination.controller;

import com.pagination.model.Kisi;
import com.pagination.repo.KisiRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.awt.print.Book;
import java.time.LocalDate;
import java.util.Random;
import java.util.stream.IntStream;


@RestController
@RequiredArgsConstructor
@RequestMapping("/kisi")
public class KisiController {

    private final KisiRepository kisiRepository;

    @PostConstruct
    private void ekle(){
        if (this.kisiRepository.count()<=0) {
            IntStream.rangeClosed(1, 12).forEach(i ->
            {
                Kisi kisi = new Kisi();
                kisi.setName(i + ".ibrahim");
                kisi.setSurname("bolat");
                kisi.setPrice(new Random().nextInt(1000));
                kisi.setBirthOfDate(LocalDate.of(2000 + i, i, i));
                this.kisiRepository.save(kisi);
            });
        }
    }

    @GetMapping("/page")
    public Page<Kisi> page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size,
                                 @RequestParam(defaultValue = "price") String sort,@RequestParam(defaultValue = "asc") String direction){
        //Sort sort1=direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sort).ascending():Sort.by(sort).descending();
        //Pageable pageable= PageRequest.of(page, size, sort1));
        //Alttaki kod üst iki satırın aynısı
        Pageable pageable= PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction),sort));
        return kisiRepository.findAll(pageable);
    }

    @GetMapping("/pagination")
    public Page<Kisi> pagination(Pageable pageable){
        return kisiRepository.findAll(pageable);
    }

    @GetMapping("/slice")
    public Slice<Kisi> paginaslicetion(Pageable pageable){
        return kisiRepository.findAll(pageable);
    }
}
