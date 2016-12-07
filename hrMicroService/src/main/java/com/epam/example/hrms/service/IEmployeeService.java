package com.epam.example.hrms.service;

import java.util.List;

import com.epam.example.hrms.model.Employee;

public interface IEmployeeService {
	Employee findEmployee(String employeeId);
	
	List<Employee> findAllEmployees();
}
