package com.epam.example.hrms.dao;

import java.util.List;

import com.epam.example.hrms.model.Employee;

public interface IEmployeeDAO {
	Employee find(String employeeId);
	
	List<Employee> findAll();
}
