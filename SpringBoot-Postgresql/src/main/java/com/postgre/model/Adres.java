package com.postgre.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="adres")
public class Adres implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_kisi_adres", allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi_adres", strategy = GenerationType.SEQUENCE)
    private Long id;

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
