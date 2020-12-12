package com.cybertek;

import com.cybertek.entity.Car;
import com.cybertek.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CybertekApplication {

	CarRepository carRepository;

	@Autowired
	public CybertekApplication(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CybertekApplication.class, args);
	}

	@PostConstruct
	public void dataInit(){
		List<Car> carList = new ArrayList<>(
				Arrays.asList(new Car("BMW", "M5"),
						new Car("Kia", "Sorento"),
						new Car("Mercedes", "S500")));

		carRepository.saveAll(carList);
	}

}
