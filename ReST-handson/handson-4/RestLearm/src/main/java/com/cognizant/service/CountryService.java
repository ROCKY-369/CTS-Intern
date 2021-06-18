package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import com.cognizant.model.Country;

public interface CountryService {
	public List<Country> getAllCountries();
	public Optional<Country> getCountry(String id);
	public Country createCountry(Country country);
	public void deleteCountry(String id);
}
