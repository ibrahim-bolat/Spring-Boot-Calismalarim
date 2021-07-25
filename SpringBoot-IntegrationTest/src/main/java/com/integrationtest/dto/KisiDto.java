package com.integrationtest.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class KisiDto {
    private String ad;
    private String soyad;
    private String mail;
    private LocalDate dogumTarihi;
    private Long gelir;
}
