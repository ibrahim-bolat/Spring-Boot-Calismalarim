package com.mongodb.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "kisi")
public class Kisi implements Serializable {

    @Id
    private String id;

    @Field(name = "ad")
    private String ad;

    @Field(name = "soyad")
    private String soyad;

    @Field(name= "cocuk_sayisi")
    private Integer cocukSayisi;

    @Field(name = "adres")
    private String adres;

    @Field(name= "dogum_tarihi")
    private LocalDate dogumTarihi;

    public Kisi(String ad, String soyad, int cocukSayisi, String adres, LocalDate dogumTarihi) {
        this.ad = ad;
        this.soyad = soyad;
        this.cocukSayisi = cocukSayisi;
        this.adres = adres;
        this.dogumTarihi = dogumTarihi;
    }
}
