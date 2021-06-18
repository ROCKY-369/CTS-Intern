package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class RestApi {

	@PostMapping(value = "/save")
	public String store() {
		return "store called";
	}
	
	@GetMapping(value = "/find")
	public String fetch() {
		return "fetch called";
	}
}