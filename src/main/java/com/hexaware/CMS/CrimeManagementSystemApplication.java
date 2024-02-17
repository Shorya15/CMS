package com.hexaware.CMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="Crime Management System",
				version="1.0.0",
				description="This project is used to reporting crimes ",
				termsOfService = "Not yet decided",
				contact=@Contact(
						name="Shorya and Sachin",
						email="Shorya885@gmail.com,@gmail.com"

						),
				license=@License(
						name="License",
						url="http://localhost:8082")
				)
		)

public class CrimeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrimeManagementSystemApplication.class, args);
	}

}
