package com.epam.example.hrms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.epam.example.hrms.dao.IEmployeeDAO;
import com.epam.example.hrms.model.Employee;
import com.epam.example.hrms.response.MockEmployeeResponse;

@Repository
@Profile("dev")
public class MockEmployeeDAOImpl implements IEmployeeDAO {
	@Autowired
	private MockEmployeeResponse employeesResponse;
	
	@Autowired
	private Employee employee;

	@Override
	public Employee find(String employeeId) {
		return employeesResponse.getEmployees()
				.stream()
				.filter(emp -> emp.getEmployeeId().equals(employeeId)).findFirst()
				.orElse(employee);
	}

	@Override
	public List<Employee> findAll() {
		return employeesResponse.getEmployees();
	}
}
