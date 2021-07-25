package com.reactivewebfluxmongocrud.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "kisi")
public class Kisi {
    @Id
    private String id;

    @Field(value = "ad")
    private String ad;

    @Field(value = "soyad")
    private String soyad;

    @Field(value = "maas")
    private int maas;

    @Field(value = "dogum_tarihi")
    private LocalDate dogumTarihi;

    @Field(value = "kredi")
    private BigDecimal kredi;
}
