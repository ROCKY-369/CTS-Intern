package com.cognizant.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Country {
	@Id
	@NotNull
	@Size(min=2,max = 2,message = "country code should be 2 characters")
	private String code;
	@NotNull
	private String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
}
