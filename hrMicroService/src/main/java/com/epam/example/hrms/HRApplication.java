package com.epam.example.hrms;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableEurekaClient
public class HRApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(HRApplication.class).run(args);
	}
}
