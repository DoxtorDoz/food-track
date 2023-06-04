package com.foodtrack.foodtrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.foodtrack.foodtrack.entidades.Dia;

@SpringBootApplication
@EntityScan(basePackages = { "com.foodtrack.foodtrack.entidades" })
public class FoodtrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodtrackApplication.class, args);
	}

	// @Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		config.exposeIdsFor(Dia.class);
	}
}
