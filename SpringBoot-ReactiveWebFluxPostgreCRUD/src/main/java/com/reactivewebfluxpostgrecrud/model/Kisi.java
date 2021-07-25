package com.reactivewebfluxpostgrecrud.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(value = "kisi")
public class Kisi {
    @Id
    private int id;

    @Column(value = "ad")
    private String ad;

    @Column(value = "soyad")
    private String soyad;

    @Column(value = "maas")
    private int maas;

    @Column(value = "dogum_tarihi")
    private LocalDate dogumTarihi;

    @Column(value = "kredi")
    private BigDecimal kredi;
}
