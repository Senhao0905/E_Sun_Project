package com.example.E_Sun_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ESunProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ESunProjectApplication.class, args);
	}

}
