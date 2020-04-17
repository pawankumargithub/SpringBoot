package com.example.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessRestController {

	@GetMapping("/")
	public String access() {
		return "access";
	}
	
	@GetMapping("/user")
	public String user() {
		return "welcome user";
	}
	
	
	@GetMapping("/admin")
	public String admin() {
		return "welcome admin";
	}
}
