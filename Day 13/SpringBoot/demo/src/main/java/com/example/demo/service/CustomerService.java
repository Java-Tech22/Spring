package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerService {
	
	public Customer findCustomerById(int id);
	
	public List<Customer> findCustomerByLastName(String lastName) ;
	
	//public List<Customer> findCustomerByFirstName(String firstName);
	
	public Customer saveCustomer(Customer customer) ;
	
	public String deleteCustomerById(int id) ;

	public List<Customer> findAllCustomer();

	public Customer updateCustomer(int id, Customer customer);
	
}
