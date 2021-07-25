package com.logging.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Kisi {

    private int id;
    private String ad;
    private String soyad;
    private int maas;
    private LocalDate dogumTarihi;
    private BigDecimal kredi;
}
