package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.dao.EmployeeDAO;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);

	}

}
