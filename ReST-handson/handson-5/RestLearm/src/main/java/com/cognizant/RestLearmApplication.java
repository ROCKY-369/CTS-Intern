package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class RestLearmApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestLearmApplication.class, args);
	}

}
