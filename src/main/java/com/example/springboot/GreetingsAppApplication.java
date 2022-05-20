package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingsAppApplication {

	public static void main(String[] args) {
		System.out.println("greeting app");
		SpringApplication.run(GreetingsAppApplication.class, args);
	}

}
