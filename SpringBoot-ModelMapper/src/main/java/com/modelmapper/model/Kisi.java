package com.modelmapper.model;

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
@Document(collection = "kisi")
public class Kisi {
    @Id
    private String id;

    @Field(value = "ad")
    private String ad;

    @Field(value = "soyad")
    private String soyad;

    @Field(value = "email")
    private String email;

    @Field(value = "parola")
    private String parola;

    @Field(value = "cinsiyet")
    private String cinsiyet;

    @Field(value = "dogum_tarihi")
    private LocalDate dogumTarihi;

    @Field(value = "iliski_durumu")
    private boolean iliskiDurumu;

    @Field(value = "cocuk_sayisi")
    private int cocukSayisi;

    @Field(value = "kredikart_numarasi")
    private String krediKartNumarasi;

    @Field(value = "gelir")
    private Long gelir;

    @Field(value = "aciklama")
    private String aciklama;

}
