package com.pagination.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "kisi")
public class Kisi implements Serializable {

    @Id
    private String id;

    @Field(name = "ad")
    private String name;

    @Field(name = "soyad")
    private String surname;

    @Field(name = "fiyat")
    private int price;

    @Field(name = "dogum_tarihi")
    private LocalDate birthOfDate;

}
