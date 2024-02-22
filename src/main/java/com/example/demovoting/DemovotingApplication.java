package com.example.demovoting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemovotingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemovotingApplication.class, args);
	}

}
