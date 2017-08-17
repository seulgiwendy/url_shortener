package com.wheejuni.spring;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableDynamoDBRepositories("com.wheejuni.spring.repositories")
public class UrlShortenerApplication {
	
	
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerApplication.class, args);
	}
}
