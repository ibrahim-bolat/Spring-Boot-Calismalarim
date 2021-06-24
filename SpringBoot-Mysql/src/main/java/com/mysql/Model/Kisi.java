package com.mysql.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer","adresler"})//sonsuz döngüye girmesin diye
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kisi")
public class Kisi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "kisi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Adres> adresler;
}
