package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Country;
import com.cognizant.exception.CountryNotFoundException;

@RestController
public class CountryController {

	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

	@GetMapping("country")
	public Country getCountryIndia() {
		return context.getBean("in", Country.class);
	}

	@GetMapping("countries")
	public List<Country> getCountries() {
		return context.getBean("countryList", List.class);
	}

	@GetMapping("country/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		List<Country> countries = context.getBean("countryList", List.class);
		Optional<Country> optional = countries.stream().filter(c -> c.getCode().equalsIgnoreCase(code)).findAny();
		if (optional.isPresent())
			return optional.get();
		else
			throw new CountryNotFoundException();
	}
}
