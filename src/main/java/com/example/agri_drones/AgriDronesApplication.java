package com.example.agri_drones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan
public class AgriDronesApplication {

	public static void main(String[] args) {

		SpringApplication.run(AgriDronesApplication.class, args);
	}

}
