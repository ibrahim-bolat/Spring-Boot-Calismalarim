package com.mongock.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongock.repo.KisRepository;


import java.math.BigDecimal;



@ChangeLog(order = "002")
public class DatabaseUpdateChangeLog {
        @ChangeSet(order = "001", id = "veritabaniSutunEkle", author = "ibo")
        public void veritabaniSutunEkle(KisRepository kisRepository) {
            kisRepository.findAll().forEach(kisi -> {
                kisi.setKredi(new BigDecimal("150000000"));
                kisRepository.save(kisi);
                });
            }
        }


