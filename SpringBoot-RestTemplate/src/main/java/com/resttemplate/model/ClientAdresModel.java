package com.resttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientAdresModel implements Serializable {

    private String id;
    private String adresBilgisi;
    private String adresTur;
    private boolean urban;
}
