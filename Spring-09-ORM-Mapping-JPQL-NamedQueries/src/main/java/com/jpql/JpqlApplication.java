package com.jpql;

import com.jpql.repository.DepartmentRepository;
import com.jpql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@SpringBootApplication
public class JpqlApplication {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpqlApplication.class, args); }

		@PostConstruct
		public void testEmployee(){

			System.out.println(employeeRepository.getEmployeeDetail());
			System.out.println(employeeRepository.getEmployeeSalary());
			System.out.println("--------------------");

			System.out.println(employeeRepository.getEmployeeByEmail("myakovlivf@ucsd.edu").get());
			System.out.println(employeeRepository.getEmployeeByEmailAndSalary("myakovlivf@ucsd.edu", new BigDecimal(78141.00)).get());
			System.out.println("--------------------");

			System.out.println(employeeRepository.getEmployeeBySalary(new BigDecimal(75283.00)));
			System.out.println(employeeRepository.getEmployeeByFirstNameOrSalary("Jodi", new BigDecimal(77173.00)));

			System.out.println("--------------------");
			employeeRepository.updateEmployeeJPQL((long) 1);
			System.out.println(employeeRepository.retrieveEmployeeSalaryGreaterThan(new BigDecimal(100000)));

			System.out.println("--------------------");
			System.out.println(departmentRepository.findMykeDepartment("Kids"));
			System.out.println(departmentRepository.countAllDepartments());


		}



}
