package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.DepartmentDAO;
import com.cognizant.model.Department;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentDAO dao;
	
	public List<Department> getAllDepartments(){
		return dao.getAllDepartments();
	}
	
}
