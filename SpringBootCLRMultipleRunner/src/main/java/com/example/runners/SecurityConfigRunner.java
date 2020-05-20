package com.example.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(40)
public class SecurityConfigRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("from security runner");
		
	}

	
}
