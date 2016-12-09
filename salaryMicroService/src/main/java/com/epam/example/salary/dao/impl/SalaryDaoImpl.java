package com.epam.example.salary.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.example.salary.dao.ISalaryDao;
import com.epam.example.salary.model.Salary;
import com.epam.example.salary.response.MockSalaryResponse;

@Repository
public class SalaryDaoImpl implements ISalaryDao {
	@Autowired
	private MockSalaryResponse salaryReponse;

	@Override
	public double find(String employeeId) {
		return salaryReponse.getSalaries()
				.stream()
				.filter(salary->salary.getEmployeeId().equals(employeeId))
				.findFirst()
				.orElse(new Salary())
				.getAmount();
	}

}
