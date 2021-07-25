package com.springsecurityjwt.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KullaniciDto {
    private int id;
    private String ad;
    private String soyad;
    private String email;
    private LocalDate dogumTarihi;
    private boolean aktif;
    private String kullaniciAdi;
}
