package com.resttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientKisiModel implements Serializable {
    private String id;
    private String ad;
    private String soyad;
    private int price;
    private Date dogumTarihi;
    private List<ClientAdresModel> adresler;
}
