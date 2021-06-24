package com.oracle.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="adres")
public class Adres {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "adres_bilgisi")
    private String adresBilgisi;

    @Enumerated
    private AdresTur adresTur;

    @Column(name = "urban")
    private boolean urban;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kisi_id", nullable = false)
    private Kisi kisi;

    public enum AdresTur{
        HOME,BUSINESS
    }
}
