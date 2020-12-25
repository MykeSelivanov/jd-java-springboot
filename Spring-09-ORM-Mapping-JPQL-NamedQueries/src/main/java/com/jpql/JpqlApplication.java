package com.jpql;

import com.jpql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JpqlApplication {

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpqlApplication.class, args); }

		@PostConstruct
		public void testEmployee(){

			System.out.println(employeeRepository.getEmployeeDetail());
			System.out.println(employeeRepository.getEmployeeSalary());

		}



}
