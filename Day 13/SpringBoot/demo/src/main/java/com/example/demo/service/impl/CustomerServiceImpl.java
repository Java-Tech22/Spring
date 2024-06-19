package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.impl.CustomerRepositoryImpl;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository repository;

	@Override
	public Customer findCustomerById(int id) {
		Optional<Customer> cust= repository.findById(id);
		if(cust.isPresent()) {
			return cust.get();
		}else {
			throw new CustomerNotFoundException("Customer is not avaiable with the given ID : "+ id);
		}
	}

	/*
	 * @Override public List<Customer> findCustomerByFirstName(String firstName) {
	 * return repository.findByFirstName(firstName); }
	 */
	
	@Override
	public List<Customer> findCustomerByLastName(String lastName) {
		List<Customer> list= repository.findByLastName(lastName);
		if(!list.isEmpty()) {
			return list;
		}else {
			throw new CustomerNotFoundException("Customer is not avaiable with the given Last Name : "+ lastName);
		}
		
	}



	@Override
	public Customer saveCustomer(Customer customer) {
		if(customer.getFirstName().isBlank() || customer.getFirstName().isEmpty() || customer.getFirstName()==null) {
			throw new CustomerNotFoundException("Customer can not be saved in to the system");
		}else {
			return repository.save(customer);
		}
		
	}

	@Override
	public String deleteCustomerById(int id) {
		
		Customer customer = findCustomerById(id);
        if(customer!=null){
            repository.deleteById(id);
            return  "Customer Deleted Successfully";
        }else{
            throw new CustomerNotFoundException("Customer Id : " + id +  " does not exit ");
        }
		
	}

	public List<Customer> findAllCustomer() {
		Iterable<Customer> customers =repository.findAll();
		List<Customer> list = new ArrayList<>();
		customers.forEach(list::add);
		return list;
		
	}

	@Override
	public Customer updateCustomer(int id, Customer customer) {

		Customer cust = (Customer) findCustomerById(id);
       if(cust!=null) {
         	if(customer.getFirstName() != null)
         		cust.setFirstName(customer.getFirstName());
         	if(customer.getLastName() != null)
         		cust.setLastName(customer.getLastName());
           
            if(customer.getProduct() != null)
            	cust.setProduct(customer.getProduct());

            	repository.save(cust);
            	return  cust;
       }
        else{
            throw new CustomerNotFoundException("Customer with given id: " + id +  " is not available !!");
        }
	}

}
