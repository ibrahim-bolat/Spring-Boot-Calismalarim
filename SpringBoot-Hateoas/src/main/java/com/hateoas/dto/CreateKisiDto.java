package com.hateoas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateKisiDto {
    private String ad;
    private String soyad;
    private Long maas;
    private LocalDate dogumTarihi;
}
