package com.exceptionhandling.controller;

import com.exceptionhandling.exception.KisiNotFoundException;
import com.exceptionhandling.model.Kisi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kisi")
public class KisiApi {

	@GetMapping("/{id}")//Global Exception
	public ResponseEntity<Kisi> getKisi(@PathVariable String id) {
		Kisi kisi=new Kisi("M558979","mehmet","tas",1875);
		if (id.equals(kisi.getId()))
			return ResponseEntity.ok(kisi);
		else
			throw  new IllegalArgumentException("Kayıt Bulunamadı");
	}

	@GetMapping("/custom/{name}") //Custom Exception
	public ResponseEntity<Kisi> getKisiException2(@PathVariable String name) {
		Kisi kisi=new Kisi("A558979","Ali","Tamer",2000);
		if (name.equals(kisi.getName()))
			return ResponseEntity.ok(kisi);
		else
			throw  new KisiNotFoundException("Kayıt Bulunamadı");
	}

	@GetMapping("/exception/{maas}") // Exception (Tüm)
	public ResponseEntity<Kisi> getKisiException3(@PathVariable int maas) {
		Kisi kisi=new Kisi("B5557860","Berat","Yol",2500);
		if (maas>2000)
			return ResponseEntity.ok(kisi);
		else
			throw  new RuntimeException("Kayıt Bulunamadı");//Her Exception Sınıfı Olabilir
	}


}
