package com.mongodb.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KisiDto {
    private String ad;
    private String soyad;
    private int cocukSayisi;
    private String adres;
    private LocalDate dogumTarihi;
}
