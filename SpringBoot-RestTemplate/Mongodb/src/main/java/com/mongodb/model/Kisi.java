package com.mongodb.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "kisi")
public class Kisi implements Serializable {

    @Id
    private String id;

    @Field(name = "ad")
    private String ad;

    @Field(name = "soyad")
    private String soyad;

    @Field(name = "fiyat")
    private int price;

    @Field(name = "dogum_tarihi")
    private Date dogumTarihi;

    @Field(name = "adresler")
    private List<Adres> adresler;
}
