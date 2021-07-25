package com.eventlistener.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kisi implements Serializable {


    private String id;
    private String name;
    private String surname;
    private int price;
    private LocalDate birthOfDate;

}
