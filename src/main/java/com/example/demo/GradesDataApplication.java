package com.example.demo;

import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.GradeRepository;
import com.example.demo.services.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class GradesDataApplication {
	@Bean

	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(GradesDataApplication.class, args);
	}
	}
