package com.elasticsearch.Entity;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "kisiler")
public class Kisi {
    @Id
    private String id;

    @Field(name = "ad", type = FieldType.Text)
    private String ad;

    @Field(name = "soyad", type = FieldType.Text)
    private String soyad;

    @Field(name = "adres", type = FieldType.Text)
    private String adres;

    @Field(name = "dogumtarihi", type = FieldType.Date)
    private Date dogumTarihi;

    public Kisi() {
    }

    public Kisi(final String id, final String ad, final String soyad, final String adres, final Date dogumTarihi) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.adres = adres;
        this.dogumTarihi = dogumTarihi;
    }

    public String getId() {
        return this.id;
    }

    public String getAd() {
        return this.ad;
    }

    public String getSoyad() {
        return this.soyad;
    }

    public String getAdres() {
        return this.adres;
    }

    public Date getDogumTarihi() {
        return this.dogumTarihi;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setAd(final String ad) {
        this.ad = ad;
    }

    public void setSoyad(final String soyad) {
        this.soyad = soyad;
    }

    public void setAdres(final String adres) {
        this.adres = adres;
    }

    public void setDogumTarihi(final Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }


    public String toString() {
        String var10000 = this.getId();
        return "Kisi(id=" + var10000 + ", ad=" + this.getAd() + ", soyad=" + this.getSoyad() + ", adres=" + this.getAdres() + ", dogumTarihi=" + this.getDogumTarihi() + ")";
    }

}

