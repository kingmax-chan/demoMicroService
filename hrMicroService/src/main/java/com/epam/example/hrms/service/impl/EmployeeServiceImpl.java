package com.epam.example.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.example.hrms.dao.IEmployeeDAO;
import com.epam.example.hrms.model.Employee;
import com.epam.example.hrms.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDAO employeeDao;

	@Override
	public Employee findEmployee(String employeeId) {
		return employeeDao.find(employeeId);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeDao.findAll();
	}

}
