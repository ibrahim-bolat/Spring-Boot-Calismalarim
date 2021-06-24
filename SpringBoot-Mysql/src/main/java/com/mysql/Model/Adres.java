package com.mysql.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="adres")
public class Adres implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "adres_bilgisi")
    private String adresBilgisi;

    @Enumerated
    private AdresTur adresTur;

    @Column(name = "urban")
    private boolean urban;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "kisi_id", nullable = false)
    private Kisi kisi;

    public enum AdresTur{
        HOME,BUSINESS
    }
}
