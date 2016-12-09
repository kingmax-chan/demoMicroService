package com.epam.example.salary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.example.salary.dao.ISalaryDao;
import com.epam.example.salary.service.ISalaryService;

@Service
public class SalaryServiceImpl implements ISalaryService {
	@Autowired
	private ISalaryDao salaryDao;

	@Override
	public double getSalary(String employeeId) {
		return salaryDao.find(employeeId);
	}

}
