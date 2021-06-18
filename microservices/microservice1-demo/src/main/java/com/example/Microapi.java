package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api1")
public class Microapi {
	
	@GetMapping
	public String display() {
		return "Welcome to first micro service";
	}

}
