package com.restapi.employeemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class EmployeemicroserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeemicroserviceApplication.class, args);
	}

}
