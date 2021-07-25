package com.apiversiyoning.controller;

import com.apiversiyoning.dto.KisiV1;
import com.apiversiyoning.dto.KisiV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kisi")
public class KisiApi {

	@GetMapping("/v1/kisi")
	public ResponseEntity<KisiV1> getKisiV1() {
		return ResponseEntity.ok(new KisiV1("mehmet","tas"));
	}

	@GetMapping("/v2/kisi")
	public ResponseEntity<KisiV2> getKisiV2() {
		return ResponseEntity.ok(new KisiV2("ahmet","kaya",2780));
	}

}
