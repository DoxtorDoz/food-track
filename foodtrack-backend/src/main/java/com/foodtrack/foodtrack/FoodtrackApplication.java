package com.foodtrack.foodtrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = { "com.foodtrack.foodtrack.entidades" })
public class FoodtrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodtrackApplication.class, args);
	}

}
