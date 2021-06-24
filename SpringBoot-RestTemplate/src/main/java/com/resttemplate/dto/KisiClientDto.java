package com.resttemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KisiClientDto implements Serializable {

    private String ad;
    private String soyad;
    private int price;
    private Date dogumTarihi;
    private List<AdresClientDto> adresler;
}
