package com.mpc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.mpc.demo.entity"})
@EnableJpaRepositories(basePackages = {"com.mpc.demo.repo"})
@ComponentScan(basePackages = {"com.mpc.demo"})
@EnableTransactionManagement
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
		System.out.println("Spring Boot web Application in run successfully.......");
	}

}