package com.epam.example.hrms;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import com.epam.example.hrms.model.Employee;
import com.epam.example.hrms.response.MockEmployeeResponse;

@Configuration
@EnableConfigurationProperties
@Profile("dev")
public class HRConfiguration {

	@Bean
	@ConfigurationProperties
	public MockEmployeeResponse employeesFactory() {
		return new MockEmployeeResponse();
	}

	@Bean
	@ConfigurationProperties("employee")
	public Employee employeeFactory() {
		return new Employee();
	}
	
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
