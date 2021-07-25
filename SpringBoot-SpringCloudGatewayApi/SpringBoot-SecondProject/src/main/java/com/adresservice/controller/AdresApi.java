package com.adresservice.controller;


import com.adresservice.dto.AdresV2;
import com.adresservice.model.Adres;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adres")
public class AdresApi {

	@GetMapping("/v1/adres")
	public ResponseEntity<Adres> getAdresV1() {
		return ResponseEntity.ok(new Adres("K5578AB","ANKARA","06100"));
	}

	@GetMapping("/v2/adres")
	public ResponseEntity<AdresV2> getAdresV2() {
		return ResponseEntity.ok(new AdresV2("İSTANBUL","34550"));
	}

}
