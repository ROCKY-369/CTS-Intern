package com.cognizant.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Department;
import com.cognizant.service.DepartmentService;

@RestController
@RequestMapping("departments")
public class DepartmentController {
	@Autowired
	private DepartmentService service;
	
	@GetMapping
	public List<Department> getDepartments() {
		return service.getAllDepartments();
	}
}
