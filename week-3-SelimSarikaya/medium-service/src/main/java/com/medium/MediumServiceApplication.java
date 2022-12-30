package com.medium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.medium.service.UserService;

@SpringBootApplication
public class MediumServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediumServiceApplication.class, args);
	}
	


}
