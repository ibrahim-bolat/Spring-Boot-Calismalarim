package com.graphql.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ad")
    private String name;

    @Column(name = "soyad")
    private String surName;

    @Column(name = "mail")
    private String mail;

    @Column(name = "adres")
    private String address;

    @Column(name = "dogumtarihi")
    @CreatedDate
    private LocalDate birthofDate;

}
