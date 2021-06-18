package com.cognizant.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ExceptionHandler.CountryNotFoundException;
import com.cognizant.model.Country;
import com.cognizant.service.CountryService;

@RestController
@RequestMapping("countries")
public class CountryController {
	
	@Autowired
	private CountryService service;
	
	@PostMapping
	public Country addCountry(@RequestBody @Valid Country country) {
		return service.createCountry(country);
	}
	
	@GetMapping("{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		Optional<Country> country= service.getCountry(code);
		if(country.isEmpty())throw new CountryNotFoundException();
		return country.get();
	}
	
	
	@GetMapping
	public List<Country> getAllCountries(){
		return service.getAllCountries();
	}
	
	@DeleteMapping("{code}")
	public void deleteCountry( @PathVariable  String code) throws CountryNotFoundException {
		Country country = getCountry(code);
		if(country!=null)
		service.deleteCountry(code);
	}
	
	@PutMapping
	public Country updateCountry(@RequestBody @Valid Country country) throws CountryNotFoundException {
		Country toBeUpdated = getCountry(country.getCode());
		if(toBeUpdated !=null)
			toBeUpdated.setName(country.getName());
		return service.createCountry(toBeUpdated);
	}
}
