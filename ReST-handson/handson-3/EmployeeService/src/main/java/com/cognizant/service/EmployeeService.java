package com.cognizant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.EmployeeDAO;
import com.cognizant.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;
	
	@Transactional
	public List<Employee> getAllEmployees(){
		return dao.getAllEmployees();
	}
}


