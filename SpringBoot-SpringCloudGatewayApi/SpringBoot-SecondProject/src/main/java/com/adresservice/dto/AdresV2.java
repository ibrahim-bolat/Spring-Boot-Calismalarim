package com.adresservice.dto;

public class AdresV2 {
    private String adres;
    private String zipCode;


    public AdresV2() {
    }

    public AdresV2(String name, String zipCode) {
        this.adres = name;
        this.zipCode = zipCode;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "AdresV2{" +
                "adres='" + adres + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
