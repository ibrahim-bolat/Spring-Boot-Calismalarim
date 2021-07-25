package com.hazelcastcache.model;


import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "kisi")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Kisi implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_kisi", allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthOfDate")
    @Temporal(TemporalType.DATE)
    private Date birthOfDate;

}
