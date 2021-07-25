package com.hateoas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.hateoas.EntityModel;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KisiHateoasDto extends EntityModel<KisiHateoasDto> {

    private int id;
    private String ad;
    private String soyad;
    private Long maas;
    private LocalDate dogumTarihi;
}
