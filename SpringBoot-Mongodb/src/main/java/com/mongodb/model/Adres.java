package com.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "adres")
public class Adres implements Serializable {

    @Id
    private String id= UUID.randomUUID().toString();

    @Field(name = "adresBilgisi")
    private String adresBilgisi;

    private AdresTur adresTur;

    @Field(name = "urban")
    private boolean urban;

    public enum AdresTur{
        HOME,BUSINESS
    }
}
