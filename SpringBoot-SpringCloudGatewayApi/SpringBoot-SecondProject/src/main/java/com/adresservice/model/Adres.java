package com.adresservice.model;

public class Adres {
    private String id;
    private String adress;
    private String zipCode;

    public Adres() {

    }

    public Adres(String id, String adress, String zipCode) {
        this.id = id;
        this.adress = adress;
        this.zipCode = zipCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdres(String adres) {
        this.adress = adres;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "id='" + id + '\'' +
                ", adres='" + adress + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}

