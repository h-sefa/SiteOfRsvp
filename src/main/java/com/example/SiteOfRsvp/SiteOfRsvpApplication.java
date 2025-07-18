package com.example.SiteOfRsvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class SiteOfRsvpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiteOfRsvpApplication.class, args);
	}

}
