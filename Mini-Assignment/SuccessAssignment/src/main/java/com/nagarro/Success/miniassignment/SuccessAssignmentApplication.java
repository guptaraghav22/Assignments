package com.nagarro.Success.miniassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SuccessAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuccessAssignmentApplication.class, args);
	}

}
