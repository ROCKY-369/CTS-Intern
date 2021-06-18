package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path="api2")
public class Restapi {
	
	@Autowired
	private RestTemplate restTemplate;
	
	 @GetMapping
	 public String display() {
		 String msg = restTemplate.getForObject("http://FIRST-MS/api1",String.class);
		 return "Welcome to second micro service calling"+msg;
	 }

}
