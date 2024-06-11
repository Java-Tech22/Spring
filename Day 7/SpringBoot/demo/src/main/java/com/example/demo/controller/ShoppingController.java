package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.service.impl.CustomerServiceImpl;
import com.example.demo.service.impl.ProductServiceImpl;

@RestController
public class ShoppingController {
	
	@Autowired
	ProductServiceImpl productService;
	
	@Autowired
	CustomerServiceImpl customerService;

	@GetMapping("/product")
	public List<Product> getProduct() {
		return productService.getProducts();
		
	}
	
	@GetMapping("/customer")
	public List<Customer> getCustomer() {
		return customerService.findAllCustomer();
		
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
}
