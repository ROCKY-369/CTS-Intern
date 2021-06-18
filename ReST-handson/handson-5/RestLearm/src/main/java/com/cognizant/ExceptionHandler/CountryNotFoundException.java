package com.cognizant.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Country Not Found with given id",value = HttpStatus.NOT_FOUND)
public class CountryNotFoundException extends Exception {

	public CountryNotFoundException() {
		
	}
	
}
