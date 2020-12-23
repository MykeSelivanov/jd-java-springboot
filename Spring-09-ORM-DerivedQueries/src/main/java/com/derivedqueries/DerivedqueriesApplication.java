package com.derivedqueries;

import com.derivedqueries.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedqueriesApplication {

	RegionRepository regionRepository;

	@Autowired
	public DerivedqueriesApplication(RegionRepository regionRepository) {
		this.regionRepository = regionRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DerivedqueriesApplication.class, args);
	}

	@PostConstruct
	public void testRegions(){
		System.out.println("----------Regions start----------");

		System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
		System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));
		System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
		System.out.println("findByCountryContainingOrderByRegionAsc: " + regionRepository.findByCountryContainingOrderByRegionAsc("United"));
		System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("Canada"));

		System.out.println("----------Regions end----------");

	}

}
