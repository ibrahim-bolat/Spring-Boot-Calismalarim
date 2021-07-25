package com.neo4j.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Node(value = "kisi")
public class Kisi {


        @Id
        @GeneratedValue
        private Long id;

        @Property("ad")
        private String ad;

        @Property("soyad")
        private String soyad;

        @Property("maas")
        private int maas;

        @Property("dogum_tarihi")
        private LocalDate dogumTarihi;

        @Relationship(type = "ROL_AL", direction = Relationship.Direction.INCOMING)
        private List<Film> filmler;
}
