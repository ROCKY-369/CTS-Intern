package com.cognizant.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Employee;
import com.cognizant.service.EmployeeService;


@RequestMapping("/employees")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public List<Employee> getEmployees(){
		return service.getAllEmployees();
	}
	
}
