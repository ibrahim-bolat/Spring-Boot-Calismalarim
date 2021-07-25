package com.validation.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KisiDto {

    @Size(min = 3, max = 50,message = "Lütfen ad alanı için en az 3 en fazla 50 karakter girmelisiniz")
    private String ad;

    @Size(min = 3, max = 50,message = "Lütfen soyad alanı için en az 3 en fazla 50 karakter girmelisiniz")
    private String soyad;

    @NotBlank
    @Email(message = "Lütfen geçerli bir e-mail adresi giriniz")
    private String email;

    @NotBlank
    @Size(min = 8, max = 15,message = "Lütfen parola alanı için en az 8 en fazla 15 karakter girmelisiniz")
    private String parola;

    @NotBlank(message = "Cinsiyet alanı boş geçilemez")
    private String cinsiyet;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Past
    private LocalDate dogumTarihi;

    @AssertTrue
    private boolean iliskiDurumu;

    @PositiveOrZero(message = "Çocuk sayısı için 0 dan küçük bir değer girilemez")
    private int cocukSayisi;

    @Pattern(regexp = "^4[0-9]{12}(?:[0-9]{3})?$", message = "Sadece Visa kart geçerlidir")
    private String krediKartNumarasi;

    @Min(value = 20_000)
    @Max(value = 200_000)
    private Long gelir;

    @Size(max = 100)
    private String aciklama;

}
