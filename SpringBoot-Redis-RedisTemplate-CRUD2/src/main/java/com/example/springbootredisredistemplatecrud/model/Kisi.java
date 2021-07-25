package com.example.springbootredisredistemplatecrud.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash(value = "kisi")
public class Kisi implements Serializable {

    @Id
    @Indexed
    private String id;
    private String ad;
    private String soyad;
    private int price;
    private Date dogumTarihi;

}
