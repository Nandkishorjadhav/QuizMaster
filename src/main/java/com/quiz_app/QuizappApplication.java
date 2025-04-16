package com.quiz_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.quiz_app")
@SpringBootApplication
public class QuizappApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuizappApplication.class, args);
	}
}
