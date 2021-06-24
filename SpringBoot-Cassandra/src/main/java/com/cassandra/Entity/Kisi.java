package com.cassandra.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("kisi")
public class Kisi {

    @PrimaryKey
    private int id;

    @Column("ad")
    private String ad;

    @Column("soyad")
    private String soyad;

    @CassandraType(type = CassandraType.Name.INT)//istege baglı
    @Column("price")
    private int price;

    @CassandraType(type = CassandraType.Name.VARCHAR)//istege baglı
    @Column("adres")
    private String adres;

    @Column("dogumTarihi")
    @CassandraType(type = CassandraType.Name.TIMESTAMP)
    private Date dogumTarihi;
}
