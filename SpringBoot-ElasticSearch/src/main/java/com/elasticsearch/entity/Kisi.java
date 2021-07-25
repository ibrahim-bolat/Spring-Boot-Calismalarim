package com.elasticsearch.entity;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "kisi")
public class Kisi {
    @Id
    private String id;

    @Field(name = "ad", type = FieldType.Text)
    private String ad;

    @Field(name = "soyad", type = FieldType.Text)
    private String soyad;

    @Field(name= "cocuk_sayisi",type = FieldType.Integer)
    private Integer cocukSayisi;

    @Field(name = "adres", type = FieldType.Text)
    private String adres;

    @Field(name= "dogum_tarihi",type=FieldType.Date, pattern="uuuu-MM-dd")
    private LocalDate dogumTarihi;

    public Kisi(String ad, String soyad, int cocukSayisi, String adres, LocalDate dogumTarihi) {
        this.ad = ad;
        this.soyad = soyad;
        this.cocukSayisi = cocukSayisi;
        this.adres = adres;
        this.dogumTarihi = dogumTarihi;
    }
}

