package com.postgre.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties({"hibernateLazyInitializer","adresler"})//sonsuz döngüye girmesin diye
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "kisi")
public class Kisi {

    @Id
    @SequenceGenerator(name = "seq_kisi", allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "ad", nullable = false, length = 25)
    private String ad;

    @Column(name = "soyad", nullable = false)
    private String soyad;

    @Column(name = "fiyat")
    private int price;

    @Column(name = "dogum_tarihi")
    @Temporal(TemporalType.DATE)
    private Date dogumTarihi;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "kisi")
    private List<Adres> adresler;
}
