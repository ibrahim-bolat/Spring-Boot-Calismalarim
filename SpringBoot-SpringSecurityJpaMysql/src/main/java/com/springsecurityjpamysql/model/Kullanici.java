package com.springsecurityjpamysql.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name= "kullanici")
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "soyad")
    private String soyad;

    @Column(name = "parola")
    private String parola;

    @Column(name = "email")
    private String email;

    @Column(name = "dogum_tarihi")
    private LocalDate dogumTarihi;

    @Column(name = "durumu")
    private boolean aktif;

    @Column(name = "kullanici_adi")
    private String kullaniciAdi;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name ="kullanici_rol", joinColumns = @JoinColumn (name="kullanici_id"), inverseJoinColumns = @JoinColumn (name="rol_id"))
    private Set<Rol> roller=new HashSet<>();

}
