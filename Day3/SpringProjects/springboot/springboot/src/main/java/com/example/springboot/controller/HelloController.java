package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String helloMessaage() {
		return "Hello ! Everyone. ";
	}
	
	
	
	
	
	
}
