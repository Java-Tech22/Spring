package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.service.impl.CustomerServiceImpl;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	
	 @InjectMocks
	    private CustomerServiceImpl customerService;

	    @Mock
	    private CustomerRepository customerRepository;

	   
	    

	    @Test
	    @DisplayName("Get all Customers test case success")
	    public void CustomerService_findAllCustomer_success(){

	    	Customer customer1 = new Customer();
			customer1.setId(1);
			customer1.setFirstName("Ana");
			customer1.setLastName("Dalvi");
			customer1.setProduct(Stream.of( new Product(1, "TV", "Smart TV", customer1)).collect(Collectors.toList()));
			Customer customer2 = new Customer();
			customer2.setId(2);
			customer2.setFirstName("Megha");
			customer2.setLastName("Dev");
			customer2.setProduct(Stream.of( new Product(1, "Phone", "Smart Phone", customer2)).collect(Collectors.toList()));
	        List<Customer> Customers =  new ArrayList<>();
	        Customers.add(customer1);
	        Customers.add(customer2);

	        Mockito.when(customerRepository.findAll()).thenReturn(Customers);

	        List<Customer> result = customerService.findAllCustomer();

	        Assertions.assertEquals(Customers.size(), result.size());


	    }


}
