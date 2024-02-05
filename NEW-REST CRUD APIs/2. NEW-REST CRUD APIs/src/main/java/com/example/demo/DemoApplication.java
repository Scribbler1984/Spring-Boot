package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
Dataflow:
	1. DemoApplication
	2. EmployeeRestController
	3. EmployeeDAOImpl
	4. Employee
*/

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
