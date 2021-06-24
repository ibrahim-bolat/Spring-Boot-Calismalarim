package com.aspectaop.service;

import org.springframework.stereotype.Service;

@Service
public class MesajService {

    public String mesajYaz(String mesaj){
        System.out.println("Gelen Mesaj:"+mesaj);
        return mesaj;
    }
}
