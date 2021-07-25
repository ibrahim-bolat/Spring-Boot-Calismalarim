package com.integrationtest.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Document(collection = "kisi")
public class Kisi {

    @Id
    private String id;

    @Field(value = "ad")
    private String ad;

    @Field(value = "soyad")
    private String soyad;

    @Field(value = "mail")
    private String mail;

    @Field(value = "dogum_tarihi")
    private LocalDate dogumTarihi;

    @Field(value = "gelir")
    private Long gelir;

    public Kisi(String ad, String soyad, String mail , LocalDate dogumTarihi, Long gelir) {
        this.ad = ad;
        this.soyad = soyad;
        this.mail = mail;
        this.dogumTarihi = dogumTarihi;
        this.gelir = gelir;
    }
}
