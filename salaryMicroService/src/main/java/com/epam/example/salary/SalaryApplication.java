package com.epam.example.salary;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SalaryApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(SalaryApplication.class).run(args);
	}

}
