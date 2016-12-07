package com.epam.example.hrms;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class HRApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(HRApplication.class).run(args);
	}
}
