package com.oracle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "kisi")
public class Kisi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ad",nullable = false,length = 25)
    private String ad;

    @Column(name = "soyad",nullable = false)
    private String soyad;

    @Column(name = "cocuk_sayisi")
    private int cocukSayisi;

    @Column(name = "adres")
    private String adres;

    @Column(name = "dogum_tarihi",length = 50)
    @Temporal(TemporalType.DATE)
    private Date dogumTarihi;

    public Kisi(String ad, String soyad, int cocukSayisi, String adres, Date dogumTarihi) {
        this.ad = ad;
        this.soyad = soyad;
        this.cocukSayisi = cocukSayisi;
        this.adres = adres;
        this.dogumTarihi = dogumTarihi;
    }
}
