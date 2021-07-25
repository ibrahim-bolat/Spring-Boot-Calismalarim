package com.mongock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "kisi")
public class Kisi {
    @Id
    private String id;

    @Field(name = "ad")
    private String ad;

    @Field(name = "soyad")
    private String soyad;

    @Field(name = "maas")
    private int maas;

    @Field(name = "dogum_tarihi")
    private LocalDate dogumTarihi;

    @Field(name = "adres_tipi")
    private AdresTip adresTip;

    @Field(name = "kredi")
    private BigDecimal kredi;
}
