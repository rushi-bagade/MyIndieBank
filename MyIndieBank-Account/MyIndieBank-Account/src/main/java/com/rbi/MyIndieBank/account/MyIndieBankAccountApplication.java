package com.rbi.MyIndieBank.account;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyIndieBankAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyIndieBankAccountApplication.class, args);
		System.out.println("started............");
		
		  
	}

	    @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
}
