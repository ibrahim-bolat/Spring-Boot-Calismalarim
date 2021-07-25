package com.manuelapiversiyoning.controller;



import com.manuelapiversiyoning.dto.KisiV1;
import com.manuelapiversiyoning.dto.KisiV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kisi")
public class KisiApi {

	@GetMapping(value = "/v1/kisi")
	public ResponseEntity<KisiV1> pathKisiV1() {
		return ResponseEntity.ok(new KisiV1("mehmet","tas"));
	}

	@GetMapping(value="/v2/kisi")
	public ResponseEntity<KisiV2> pathKisiV2() {
		return ResponseEntity.ok(new KisiV2("ahmet","kaya",2780));
	}

	@GetMapping(value="/param/kisi",params = "apiVersion=1")
	public ResponseEntity<KisiV1> paramKisiV1() {
		return ResponseEntity.ok(new KisiV1("mehmet","tas"));
	}

	@GetMapping(value="/param/kisi",params = "apiVersion=2")
	public ResponseEntity<KisiV2> paramKisiV2() {
		return ResponseEntity.ok(new KisiV2("ahmet","kaya",2780));
	}

	@GetMapping(value="/header/kisi",headers = "X-API-VERSION=1")
	public ResponseEntity<KisiV1> headerKisiV1() {
		return ResponseEntity.ok(new KisiV1("mehmet","tas"));
	}

	@GetMapping(value="/header/kisi",headers = "X-API-VERSION=2")
	public ResponseEntity<KisiV2> headerKisiV2() {
		return ResponseEntity.ok(new KisiV2("ahmet","kaya",2780));
	}

}
