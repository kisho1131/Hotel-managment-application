package com.cognizant.hotel_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


//@EnableJpaRepositories(repositoryBaseClass  = UserRepository.class)
@SpringBootApplication
@ComponentScan("com.*")
public class HotelManagementApplication{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(HotelManagementApplication.class, args);
	}

}
