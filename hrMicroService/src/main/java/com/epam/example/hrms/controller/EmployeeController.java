package com.epam.example.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.example.hrms.model.Employee;
import com.epam.example.hrms.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/{employeeId}")
	public Employee findEmployeeById(@PathVariable String employeeId){
		discoveryClient.getServices().forEach(System.out::println);
		String serviceId = discoveryClient.getLocalServiceInstance().getServiceId();
		System.out.println("serviceId:" + serviceId);
	
		return employeeService.findEmployee(employeeId);
	}
	
	@GetMapping("/all")
	public List<Employee> findEmployees(){
		return employeeService.findAllEmployees();
	}
}
