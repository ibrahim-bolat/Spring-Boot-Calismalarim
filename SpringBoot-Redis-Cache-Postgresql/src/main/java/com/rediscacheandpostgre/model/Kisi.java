package com.rediscacheandpostgre.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "kisi")
public class Kisi implements Serializable {

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

}
