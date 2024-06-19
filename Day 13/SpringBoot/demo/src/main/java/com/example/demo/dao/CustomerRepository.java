package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	 public List<Customer> findByLastName(String lastName);

	  //public Customer findById(int id);

	  //public List<Customer> findByFirstName(String firstName);
	  
	  }
