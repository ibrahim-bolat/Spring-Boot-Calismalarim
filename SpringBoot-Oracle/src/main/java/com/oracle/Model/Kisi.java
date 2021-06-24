package com.oracle.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer","adresler"})//sonsuz döngüye girmesin diye
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "fiyat")
    private int price;

    @Column(name = "dogum_tarihi")
    @Temporal(TemporalType.DATE)
    private Date dogumTarihi;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "kisi")
    private List<Adres> adresler;
}
