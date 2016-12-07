package com.epam.example.hrms.response;

import java.util.List;

import org.springframework.context.annotation.Profile;

import com.epam.example.hrms.model.Employee;

@Profile("dev")
public class MockEmployeeResponse {
	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
