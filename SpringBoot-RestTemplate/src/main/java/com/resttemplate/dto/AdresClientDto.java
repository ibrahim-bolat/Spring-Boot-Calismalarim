package com.resttemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdresClientDto implements Serializable {
    private String adresBilgisi;
    private AdresTur adresTur;
    private boolean urban;
    public enum AdresTur{
        HOME,BUSINESS
    }
}
