package com.cinemaapp;

import com.cinemaapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CinemaappApplication {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CinemaRepository cinemaRepository;
	@Autowired
	MovieCinemaRepository movieCinemaRepository;
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CinemaappApplication.class, args);
	}

	@PostConstruct
	public void testAccount(){

		System.out.println("--------------------------------");
		System.out.println(accountRepository.fetchAllJPQL());
		System.out.println(accountRepository.fetchAdminUsers());
		System.out.println(accountRepository.retrieveLessThanAge(45));

		System.out.println("--------------------------------");
		System.out.println(cinemaRepository.distinctCinemaBySponsoredName());

		System.out.println("--------------------------------");
		System.out.println(movieCinemaRepository.countByCinemaIdNativeQuery(4L));
		System.out.println(movieCinemaRepository.retrieveAllByLocationName("AMC Empire 25"));

		System.out.println("--------------------------------");
		System.out.println(ticketRepository.retrieveAllBySearchCriteria("it"));

		System.out.println("--------------------------------");
		System.out.println(userRepository.findByEmail("bernard@email.com"));
		System.out.println(userRepository.findByUsername("faith"));
		System.out.println(userRepository.findAllByUsernameContaining("ait"));
		System.out.println(userRepository.findAllByUsernameContainingIgnoreCase("JOHNNIE"));
		System.out.println(userRepository.findAllByAccountAgeIsGreaterThanEqual(36));
		System.out.println(userRepository.fetchUserByEmail("bernard@email.com"));
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


	}

}
