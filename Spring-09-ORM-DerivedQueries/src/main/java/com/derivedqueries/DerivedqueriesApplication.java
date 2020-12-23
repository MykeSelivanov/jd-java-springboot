package com.derivedqueries;

import com.derivedqueries.repository.DepartmentRepository;
import com.derivedqueries.repository.EmployeeRepository;
import com.derivedqueries.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@SpringBootApplication
public class DerivedqueriesApplication {

	RegionRepository regionRepository;
	DepartmentRepository departmentRepository;
	EmployeeRepository employeeRepository;

	@Autowired
	public DerivedqueriesApplication(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
		this.regionRepository = regionRepository;
		this.departmentRepository = departmentRepository;
		this.employeeRepository = employeeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DerivedqueriesApplication.class, args);
	}

	@PostConstruct
	public void testRegions(){
		System.out.println("------------Regions start------------");

		System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
		System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));
		System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
		System.out.println("findByCountryContainingOrderByRegionAsc: " + regionRepository.findByCountryContainingOrderByRegionAsc("United"));
		System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("Canada"));

		System.out.println("------------Regions end------------");

	}

	@PostConstruct
	public void testDepartments(){

		System.out.println("------------Department start------------");

		System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Toys"));
		System.out.println("findByDivision: " + departmentRepository.findByDivision("Outdoors"));
		System.out.println("findByDivisionEndingWith: " + departmentRepository.findByDivisionEndingWith("ics"));
		System.out.println("findDistinctTop3ByDivisionContains: " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));

		System.out.println("------------Department End------------");

	}

	@PostConstruct
	public void testEmployees(){
		System.out.println("------------Employee start------------");

		System.out.println("findByEmail: " + employeeRepository.findByEmail("amcnee1@google.es"));
		System.out.println("findByFirstNameAndLastNameOrEmail: " + employeeRepository.findByFirstNameAndLastNameOrEmail("Berrie","Manueau","jhookd@booking.com"));
		System.out.println("findBySalaryGreaterThan: " + employeeRepository.findBySalaryGreaterThan(new BigDecimal(100000)));
		System.out.println("findDistinctTop3BySalaryLessThanEqual: " + employeeRepository.findDistinctTop3BySalaryLessThanEqual(new BigDecimal(50000)));
		System.out.println("findByEmailIsNull: " + employeeRepository.findByEmailIsNull());

		System.out.println("------------Employee End------------");

	}



}
