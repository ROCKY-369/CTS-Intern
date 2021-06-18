package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Country;
import com.cognizant.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	CountryRepository repository;
	
	
	@Override
	public List<Country> getAllCountries() {
		return repository.findAll();
	}

	@Override
	public Optional<Country> getCountry(String id) {
		return repository.findById(id);
	}

	@Override
	public Country createCountry(Country country) {
		return repository.save(country);
	}

	@Override
	public void deleteCountry(String id) {
		repository.deleteById(id);
	}
	
}
