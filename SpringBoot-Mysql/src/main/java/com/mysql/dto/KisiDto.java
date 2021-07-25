package com.mysql.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KisiDto {
    private String ad;
    private String soyad;
    private int cocukSayisi;
    private String adres;
    private Date dogumTarihi;
}
