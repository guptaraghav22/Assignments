package com.nagarro.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.nagarro.training.Controller"})
public class Assignment51Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment51Application.class, args);
	}

}
