package com.epam.example.salary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.example.salary.service.ISalaryService;

@RestController
public class SalaryController {
	@Autowired
	private ISalaryService salaryService;

	@PostMapping("/salary/{employeeId}")
	public double retrieveSalary(@PathVariable String employeeId){
		return salaryService.getSalary(employeeId);
	}
}
