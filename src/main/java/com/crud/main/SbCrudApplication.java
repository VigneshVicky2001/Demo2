package com.crud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.crud")
@EntityScan("com.crud.model")
@EnableJpaRepositories("com.crud.repository")		//to connect with repository interface where the method can be accessed through enabling it
public class SbCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbCrudApplication.class, args);
	}

}
