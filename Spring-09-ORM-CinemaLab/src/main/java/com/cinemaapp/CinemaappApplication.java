package com.cinemaapp;

import com.cinemaapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CinemaappApplication {

	@Autowired
	AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(CinemaappApplication.class, args);
	}

	@PostConstruct
	public void testAccount(){

		System.out.println(accountRepository.fetchAllJPQL());
		System.out.println(accountRepository.fetchAdminUsers());

		System.out.println(accountRepository.retrieveLessThanAge(45));

	}

}
