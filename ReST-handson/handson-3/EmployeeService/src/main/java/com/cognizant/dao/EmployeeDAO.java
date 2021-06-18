package com.cognizant.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.model.Employee;

@Component
public class EmployeeDAO {
	private static List<Employee> EMPLOYEE_LIST;
	
	public EmployeeDAO() {
		ApplicationContext context= new ClassPathXmlApplicationContext("employeeConfig.xml");
		EMPLOYEE_LIST=context.getBean("employeeList",List.class);
	}

	public static List<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}
	
}
