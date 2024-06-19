package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProductService;

@RestController
public class ShoppingController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerService customerService;

	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers() {
		return new ResponseEntity<>(customerService.findAllCustomer(),HttpStatus.OK);
		
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.saveCustomer(customer),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/customer/{id}")
	    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer){
	        return new ResponseEntity<>(customerService.updateCustomer(id,customer),HttpStatus.ACCEPTED);
	    }

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
		return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK);
		
	}

	
	  @GetMapping("/customers/{name}") 
	  public ResponseEntity<List<Customer>> getCustomerByLastName(@PathVariable String name) { 
		  return new ResponseEntity<>(customerService.findCustomerByLastName(name), HttpStatus.OK);
	  }
	 
	

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable int id) {
		 return new ResponseEntity<>(customerService.deleteCustomerById(id), HttpStatus.ACCEPTED);
	}
	
	

	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
		
	}
	@PostMapping("/product")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);
		
	}
	

	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable int id) {
		return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.OK);
			
			
	}
	 @PutMapping("/product/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product){
	        return new ResponseEntity<Product>(productService.updateProduct(id,product),HttpStatus.ACCEPTED);
	    }
	
		 
}
