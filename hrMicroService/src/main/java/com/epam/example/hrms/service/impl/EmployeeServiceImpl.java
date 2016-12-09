package com.epam.example.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epam.example.hrms.dao.IEmployeeDAO;
import com.epam.example.hrms.model.Employee;
import com.epam.example.hrms.service.IEmployeeService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDAO employeeDao;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Employee findEmployee(String employeeId) {
		Employee employee = employeeDao.find(employeeId);
		employee.setSalary(getSalary(employeeId));
		return employee;
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeDao.findAll();
	}
	
	private double getSalary(String employeeId){
		double result = 0;
		Application app = eurekaClient.getApplications().getRegisteredApplications()
				.stream()
				.filter(application -> application.getName().equalsIgnoreCase("salarySystem"))
				.findFirst()
				.orElse(null);
		if(app != null){
			InstanceInfo instanceInfo = app.getInstances()
					.stream()
					.filter(instance -> instance.getAppName().equalsIgnoreCase("salarySystem"))
					.findFirst()
					.orElse(null);
			
			if(instanceInfo != null){
				ResponseEntity<Double> response = restTemplate.postForEntity(instanceInfo.getHealthCheckUrl().replace("health", "salary") + "/" + employeeId, null, Double.class);
				result = response.getBody().doubleValue();
			}
		}
		
		
		return result;
	}

}
