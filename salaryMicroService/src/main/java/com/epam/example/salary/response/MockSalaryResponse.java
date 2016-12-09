package com.epam.example.salary.response;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.epam.example.salary.model.Salary;

@ConfigurationProperties()
@Component
public class MockSalaryResponse {
	private List<Salary> salaries;

	public List<Salary> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}
	
	
}
