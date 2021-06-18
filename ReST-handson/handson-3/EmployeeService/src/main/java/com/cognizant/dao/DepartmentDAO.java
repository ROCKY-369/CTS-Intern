package com.cognizant.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.model.Department;

@Component
public class DepartmentDAO {
private static List<Department> DEPARTMENT_LIST;
	
	public DepartmentDAO() {
		ApplicationContext context= new ClassPathXmlApplicationContext("employeeConfig.xml");
		DEPARTMENT_LIST=context.getBean("departmentList",List.class);
	}

	public static List<Department> getAllDepartments() {
		return DEPARTMENT_LIST;
	}
}
