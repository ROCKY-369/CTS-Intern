package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Microservice1DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservice1DemoApplication.class, args);
	}

}
