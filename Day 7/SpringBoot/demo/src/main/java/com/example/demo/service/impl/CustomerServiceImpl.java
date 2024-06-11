package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.impl.CustomerDaoImpl;
import com.example.demo.model.Customer;
import com.example.demo.service.customerService;

@Service
public class CustomerServiceImpl implements customerService {
	
	@Autowired
	CustomerDaoImpl custDao;

	@Override
	public List<Customer> findAllCustomer() {
		return custDao.findAllCustomer();
		
	}

}
