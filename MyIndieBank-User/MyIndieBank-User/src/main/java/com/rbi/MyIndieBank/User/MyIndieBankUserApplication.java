package com.rbi.MyIndieBank.User;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyIndieBankUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyIndieBankUserApplication.class, args);
		System.out.println("User App started .  .  .  .");
	}
	
	
	 @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
	
}
