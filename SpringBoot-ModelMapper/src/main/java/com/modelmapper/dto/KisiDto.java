package com.validation.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KisiDto {

    private String ad;
    private String soyad;
    private String email;
    private String parola;
    private String cinsiyet;
    private LocalDate dogumTarihi;
    private boolean iliskiDurumu;
    private int cocukSayisi;
    private String krediKartNumarasi;
    private Long gelir;
    private String aciklama;

}
