package com.cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("kisi")
public class Kisi {

    @PrimaryKey
    private UUID id;

    @Column("ad")
    private String ad;

    @Column("soyad")
    private String soyad;

    @CassandraType(type = CassandraType.Name.INT)//istege baglı
    @Column("cocukSayisi")
    private int cocukSayisi;

    @CassandraType(type = CassandraType.Name.VARCHAR)//istege baglı
    @Column("adres")
    private String adres;

    @Column("dogumTarihi")
    @CassandraType(type = CassandraType.Name.TIMESTAMP)
    private Date dogumTarihi;

}
